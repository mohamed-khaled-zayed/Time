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
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.ui.activity.admin.AdminHomeActivity;
import com.binarycase.mohamed.ontime.ui.activity.client.HomeActivity;
import com.binarycase.mohamed.ontime.ui.activity.employee.EmployeeHomeActivity;
import com.binarycase.mohamed.ontime.utils.AppUtils;
import com.binarycase.mohamed.ontime.utils.ValidateUtils;
import com.binarycase.mohamed.ontime.data.prefs.CacheUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class SignInActivity extends AppCompatActivity {

    private TextView loginText,please,newAccount,forgetPassword;
    private Button login;
    private EditText phone,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_sign_in);
        initView();
    }

    public void initView(){
        changeStatusBarColor();

        loginText=findViewById(R.id.sign_in_login);
        please=findViewById(R.id.sign_in_please);
        newAccount=findViewById(R.id.sign_in_new_account);
        forgetPassword=findViewById(R.id.sign_in_forget_password);

        login=findViewById(R.id.sign_in_sign_in);

        phone=findViewById(R.id.sign_in_phone);
        password=findViewById(R.id.sign_in_password);

        AppUtils.applyBoldFont(login,loginText);
        AppUtils.applyLightFont(please,newAccount,forgetPassword,phone,password);
    }

    public void signUp(View view) {
        startActivity(new Intent(this,SignUpActivity.class));
    }

    private void loginUser() {

        final String user_phone=AppUtils.getTextContent(phone);
        final String user_password=AppUtils.getTextContent(password);
        if (ValidateUtils.missingInputs(user_phone, user_password)) {
            AppUtils.showInfoDialog(this,R.string.error_dialog_missing_inputs);
            return;
        }

//        if (!ValidateUtils.validPhone(user_phone)) {
//            AppUtils.showInfoDialog(this,R.string.error_dialog_invalid_phone);
//            return;
//        }
//
//        if (!ValidateUtils.validPassword(user_password)) {
//            AppUtils.showInfoDialog(this,R.string.error_dialog_invalid_password);
//            return;
//        }

        if (!AppUtils.isInternetAvailable(this)) {
            AppUtils.showNoInternetDialog(this);
            return;
        }


        AndroidNetworking.post("https://ontime.sa/api/client_login?appKey=ontime")
                .addBodyParameter("signin-phone", user_phone)
                .addBodyParameter("signin-password", user_password)
                .addBodyParameter("userlogin","1")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        AppUtils.dismissProgressDialog();
                        Log.e("response",response);
                        String state;
                        String error_msg ;
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Log.e("jsonObject",jsonObject.toString());
                            JSONObject jsonObject1 =   jsonObject.getJSONObject("error");
                            Log.e("jsonObject1",jsonObject1.toString());
                            state =  jsonObject1.getString("status");
                            Log.e("state",state.toString());
                            if(state.equalsIgnoreCase("true")){
                                JSONObject jsonObject2 =  jsonObject.getJSONObject("response");
                                error_msg = jsonObject2.getString("error");
                                Toast.makeText(SignInActivity.this, error_msg, Toast.LENGTH_SHORT).show();
                            }else if(state.equalsIgnoreCase("false")){
                                Toast.makeText(SignInActivity.this, "Login_Success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignInActivity.this,HomeActivity.class));
                            }

                        } catch (Exception e) {
                            AppUtils.dismissProgressDialog();
                        }

                    }
                    @Override
                    public void onError(ANError anError) {
                        AppUtils.dismissProgressDialog();
                        Log.e("Error" , anError.getMessage().toString());
                    }
                });
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
            CacheUtils.getSharedPreferences(SignInActivity.this).edit().putString("user", user).apply();
            AppUtils.dismissProgressDialog();
            Intent intent=new Intent(SignInActivity.this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        } catch (JSONException e) {
            AppUtils.dismissProgressDialog();
            AppUtils.showErrorToast(SignInActivity.this,getString(R.string.error));
        }

    }

    public void home(View view) {
//        startActivity(new Intent(this,HomeActivity.class));
        if (AppUtils.isInternetAvailable(this)) {
            loginUser();
        }else {
            AppUtils.showInfoDialog(this,R.string.device_id_null);
        }
    }

    public void restore(View view) {
        if (AppUtils.isInternetAvailable(this)) {
            startActivity(new Intent(this,RestorePasswordActivity.class));
        }else {
            AppUtils.showInfoDialog(SignInActivity.this,R.string.device_id_null);
        }
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }


    public void Client(View view) {
    }

    public void Employee(View view) {
        startActivity(new Intent(this,EmployeeHomeActivity.class));
    }

    public void Admin(View view) {
        startActivity(new Intent(this,AdminHomeActivity.class));
    }
}
