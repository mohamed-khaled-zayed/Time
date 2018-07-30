package com.binarycase.mohamed.ontime.ui.activity.commen;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.data.prefs.CacheUtils;
import com.binarycase.mohamed.ontime.ui.activity.client.HomeActivity;
import com.binarycase.mohamed.ontime.utils.AppUtils;
import com.binarycase.mohamed.ontime.utils.ValidateUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity {

    private TextView newAccount,please,persons,company,message;
    private EditText firstName,secondName,thirdName,phone,email,password,companyName;
    private Button signUp,back;
    private ImageView check_box_bg;
    private boolean isCompany=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_sign_up);

        initView();

    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void initView() {
        changeStatusBarColor();
        newAccount= findViewById(R.id.sign_up_new_account);
        please= findViewById(R.id.sign_up_please);
        persons= findViewById(R.id.sign_up_persons);
        firstName= findViewById(R.id.sign_up_first);
        secondName= findViewById(R.id.sign_up_second);
        thirdName= findViewById(R.id.sign_up_third);
        company= findViewById(R.id.sign_up_company);
        companyName= findViewById(R.id.sign_up_company_name);
        companyName.setEnabled(false);
        phone= findViewById(R.id.sign_up_phone_number);
        email= findViewById(R.id.sign_up_email);
        password= findViewById(R.id.sign_up_password);
        message= findViewById(R.id.sign_up_message);
        signUp=findViewById(R.id.sign_up_sign_up);
        back=findViewById(R.id.sign_up_back);
        check_box_bg=findViewById(R.id.check_box_bg);
        AppUtils.applyBoldFont(signUp,back,newAccount);
        AppUtils.applyMediumFont(persons,company);
        AppUtils.applyLightFont(please,firstName,secondName,thirdName,companyName,phone,email,password,message);
    }

    private void registerUser() {

        final String user_first_name=AppUtils.getTextContent(firstName);
        final String user_second_name=AppUtils.getTextContent(secondName);
        final String user_third_name=AppUtils.getTextContent(thirdName);
        final String user_phone=AppUtils.getTextContent(phone);
        final String user_email=AppUtils.getTextContent(email);
        final String user_password=AppUtils.getTextContent(password);
        if (ValidateUtils.missingInputs(user_first_name,user_second_name,user_third_name, user_phone, user_email, user_password)) {
            AppUtils.showInfoDialog(this,R.string.error_dialog_missing_inputs);
            return;
        }

        if (!ValidateUtils.validPhone(user_phone)) {
            AppUtils.showInfoDialog(this,R.string.error_dialog_invalid_phone);
            return;
        }

        if (!ValidateUtils.validPassword(user_password)) {
            AppUtils.showInfoDialog(this,R.string.error_dialog_invalid_password);
            return;
        }

        if (!AppUtils.isInternetAvailable(this)) {
            AppUtils.showNoInternetDialog(this);
            return;
        }

        AppUtils.showProgressDialog(this);

        AndroidNetworking.post("https://ontime.sa/api/client_register?appKey=ontime")
                .addBodyParameter("first_name", user_first_name)
                .addBodyParameter("addaccount", "1")
                .addBodyParameter("email", user_email)
                .addBodyParameter("password2", user_password)
                .addBodyParameter("bill_firm", "")
                .addBodyParameter("phone", user_phone)
                .addBodyParameter("second_name", user_second_name)
                .addBodyParameter("third_name", user_third_name)
                .addBodyParameter("firm_name", "")
                .addBodyParameter("register_type", "0")
                .addBodyParameter("accept_terms", "1")
                .addBodyParameter("confirmpassword", user_password)
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("ggggggg",response);
                        AppUtils.dismissProgressDialog();
                        try {
                            if (new JSONObject(response).getJSONObject("error").getString("status").equalsIgnoreCase("false")){
                                AppUtils.showSuccessToast(SignUpActivity.this,"okay");
//                                saveUser(response);
                            } else if (new JSONObject(response).getString("code").equalsIgnoreCase("205")){
                                AppUtils.showErrorToast(SignUpActivity.this,new JSONObject(response).getString("message"));
                            } else {
//                                AppUtils.showInfoDialog(SignUpActivity.this,R.string.error_dialog_cannot_register);
                            }
                        } catch (JSONException e) {
//                            AppUtils.showInfoDialog(SignUpActivity.this,R.string.error_dialog_cannot_register);
                        }
                    }
                    @Override
                    public void onError(ANError anError) {
                        AppUtils.dismissProgressDialog();
//                        AppUtils.showInfoDialog(SignUpActivity.this,R.string.error_dialog_cannot_register);
                    }
                });
    }


    public void signUpButton(View view) {
        registerUser();
    }

    public void cancel(View view) {
        onBackPressed();
    }

    public void login(View view) {
        onBackPressed();
    }

    public void checkBoxListener(View view) {
        if (!isCompany){
            isCompany=true;
            check_box_bg.setImageResource(R.drawable.check_box_bg_image);
            companyName.setEnabled(true);
        }else {
            isCompany=false;
            check_box_bg.setImageResource(R.drawable.uncheck_box_bg_image);
            companyName.setEnabled(false);
        }
    }

    private void saveUser(String response) {

        try {
            JSONObject save_object=new JSONObject();
            JSONObject rec_object = new JSONObject(response);
            JSONObject object = rec_object.getJSONObject("data");

            save_object.put("id",object.getString("id"));
            save_object.put("name",object.getString("name"));
            save_object.put("phone",object.getString("phone"));
            save_object.put("email",object.getString("email"));
            save_object.put("token",object.getString("token"));
            save_object.put("gender",object.getString("gender"));
            save_object.put("city",object.getString("city_id"));
            save_object.put("role_id",object.getString("role_id"));
            save_object.put("photo",object.getString("photo"));


            String user=save_object.toString();
            CacheUtils.getSharedPreferences(SignUpActivity.this).edit().putString("user", user).apply();
            AppUtils.dismissProgressDialog();
            Intent intent=new Intent(SignUpActivity.this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        } catch (JSONException e) {
            AppUtils.dismissProgressDialog();
            AppUtils.showErrorToast(SignUpActivity.this,getString(R.string.error));
        }

    }

}
