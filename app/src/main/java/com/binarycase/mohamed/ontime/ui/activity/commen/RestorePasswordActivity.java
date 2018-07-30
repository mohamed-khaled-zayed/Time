package com.binarycase.mohamed.ontime.ui.activity.commen;

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
import com.binarycase.mohamed.ontime.utils.AppUtils;
import com.binarycase.mohamed.ontime.utils.ValidateUtils;

import org.json.JSONObject;

public class RestorePasswordActivity extends AppCompatActivity {

    private TextView restoreText,restoreBy,email,sms,message;
    private EditText emailRestore,smsRestore;
    private Button restore;
    private ImageView restore_email,restore_sms;
    private String restoreByValue="mail";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_restore_password);

        changeStatusBarColor();

        restoreText=findViewById(R.id.restore_restore_password);
        restoreBy=findViewById(R.id.restore_by);
        email=findViewById(R.id.restore_by_email);
        sms=findViewById(R.id.restore_by_sms);
        message=findViewById(R.id.restore_re_try);
        emailRestore=findViewById(R.id.restore_email);
        smsRestore=findViewById(R.id.restore_sms);
        restore=findViewById(R.id.restore_restore);

        restore_email=findViewById(R.id.email);
        restore_sms=findViewById(R.id.sms);
        AppUtils.applyBoldFont(restore,restoreText);
        AppUtils.applyLightFont(emailRestore,restoreBy,message);
        AppUtils.applyMediumFont(email,sms);
    }

    private void restorePasswordByEmail() {

        final String email=AppUtils.getTextContent(emailRestore);
        if (ValidateUtils.missingInputs(email)) {
            AppUtils.showInfoDialog(this,R.string.error_dialog_missing_inputs);
            return;
        }


        if (!AppUtils.isInternetAvailable(this)) {
            AppUtils.showNoInternetDialog(this);
            return;
        }





        AndroidNetworking.post("https://ontime.sa/api/forget_password?appKey=ontime")
                .addBodyParameter("user_email", "1")
                .addBodyParameter("your_email",email)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("ggggggg mail",response);
                        try {


                        } catch (Exception e) {
//                            AppUtils.showErrorToast(SignInActivity.this,getString(R.string.common_signin_button_text));
                        }

                    }
                    @Override
                    public void onError(ANError anError) {
//                        showCanNotLoadDataDialog();
                    }
                });
    }

    private void restorePasswordByPhone() {

        final String phone=AppUtils.getTextContent(smsRestore);
        if (ValidateUtils.missingInputs(phone)) {
            AppUtils.showInfoDialog(this,R.string.error_dialog_missing_inputs);
            return;
        }
//
//        if (!ValidateUtils.validPhone(phone)) {
//            AppUtils.showInfoDialog(this,R.string.error_dialog_invalid_phone);
//            return;
//        }


        if (!AppUtils.isInternetAvailable(this)) {
            AppUtils.showNoInternetDialog(this);
            return;
        }


        Log.e("ggggggg phone",phone);



        AndroidNetworking.post("https://ontime.sa/api/forget_password_phone?appKey=ontime")
                .addBodyParameter("user_email", "1")
                .addBodyParameter("your_phone",phone)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("ggggggg phone",response);
                        try {


                        } catch (Exception e) {
                            AppUtils.dismissProgressDialog();
//                            AppUtils.showErrorToast(SignInActivity.this,getString(R.string.common_signin_button_text));
                        }

                    }
                    @Override
                    public void onError(ANError anError) {
                        AppUtils.dismissProgressDialog();
//                        showCanNotLoadDataDialog();
                    }
                });
    }

    public void onEmailChecked(View view) {
        restoreByValue="mail";
        smsRestore.setVisibility(View.GONE);
        emailRestore.setVisibility(View.VISIBLE);
        restore_email.setImageResource(R.drawable.check_box_bg_image);
        restore_sms.setImageResource(R.drawable.uncheck_box_bg_image);
    }

    public void onSMSChecked(View view) {
        restoreByValue="phone";
        smsRestore.setVisibility(View.VISIBLE);
        emailRestore.setVisibility(View.GONE);
        restore_email.setImageResource(R.drawable.uncheck_box_bg_image);
        restore_sms.setImageResource(R.drawable.check_box_bg_image);
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public void back(View view) {
        onBackPressed();
    }

    public void restore(View view) {
//        restorePassword();

        if (restoreByValue.equals("mail")){
            restorePasswordByEmail();
        }else {
            restorePasswordByPhone();
        }

    }
}
