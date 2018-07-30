package com.binarycase.mohamed.ontime.ui.activity.client;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.utils.AppUtils;

public class UserProfileActivity extends AppCompatActivity {

    private TextView userName,myOrders,compeleted,compeletedValue,stillWorking,stillWorkingValue,payments,paymentsValue,late,lateValue,pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_user_profile);

        changeStatusBarColor();
        userName = findViewById(R.id.user_name);
        myOrders = findViewById(R.id.user_profile_my_orders);
        compeleted = findViewById(R.id.user_profile_compeleted);
        compeletedValue = findViewById(R.id.user_profile_compeleted_value);
        stillWorking = findViewById(R.id.user_profile_execeting);
        stillWorkingValue = findViewById(R.id.user_profile_compeleted_value);
        payments = findViewById(R.id.user_profile_payments);
        paymentsValue = findViewById(R.id.user_profile_payments_value);
        late = findViewById(R.id.user_profile_late);
        lateValue = findViewById(R.id.user_profile_late_value);
        pay = findViewById(R.id.user_profile_pay);


        AppUtils.applyLightFont(compeleted,compeletedValue,stillWorking,stillWorkingValue,payments,paymentsValue,late,lateValue);
        AppUtils.applyMediumFont(pay,myOrders);
        AppUtils.applyBoldFont(userName);

    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public void loadUserData(){
        AndroidNetworking.post("https://ontime.sa/api/client_login?appKey=ontime")
                .addBodyParameter("userlogin","1")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        AppUtils.dismissProgressDialog();
                        Log.e("response",response);
                        parseData(response);
                    }
                    @Override
                    public void onError(ANError anError) {
                        AppUtils.dismissProgressDialog();
                        Log.e("Error" , anError.getMessage().toString());
                    }
                });
    }

    private void parseData(String response) {

    }
}
