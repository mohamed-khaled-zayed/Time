package com.binarycase.mohamed.ontime.ui.activity.client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.data.prefs.CacheUtils;
import com.binarycase.mohamed.ontime.utils.AppUtils;

import org.json.JSONObject;

public class ContinueActivity extends AppCompatActivity {

    private TextView please,orderField,orderFieldValue,orderType,orderTypeValue,price,priceValue,descreption,addFiles,
            message,extentions,fileUploal,title;
    private Button send,back;
    private EditText project_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);
        title=findViewById(R.id.toolbar_title);

        project_name=findViewById(R.id.project_name);
        please = findViewById(R.id.continue_please);
        orderField = findViewById(R.id.continue_order_field);
        orderFieldValue = findViewById(R.id.continue_order_field_value);
        orderType = findViewById(R.id.continue_order_type);
        orderTypeValue = findViewById(R.id.continue_order_type_value);
        price = findViewById(R.id.continue_price);
        priceValue = findViewById(R.id.continue_price_value);
        descreption = findViewById(R.id.project_descreption);
        addFiles = findViewById(R.id.attach_files);
        message = findViewById(R.id.user_message);
        extentions = findViewById(R.id.extentions);
        fileUploal = findViewById(R.id.upload_files);

        send= findViewById(R.id.continue_order_send);
        back= findViewById(R.id.continue_order_cancel);
        AppUtils.applyLightFont(orderFieldValue,orderTypeValue,priceValue,message,extentions,project_name);
        AppUtils.applyMediumFont(orderField,orderType,price,descreption,addFiles,fileUploal,title);
        AppUtils.applyBoldFont(please,send,back);
    }

    public void back(View view) {
        onBackPressed();
    }

    public void send(View view) {
    }

    public void addNewOrder(){

        if (!AppUtils.isInternetAvailable(this)) {
            AppUtils.showNoInternetDialog(this);
            return;
        }


        AppUtils.showProgressDialog(this);
        AndroidNetworking.post("http://athelapps.com/phone/api/order/create")
                .addBodyParameter("api_key", "BUNgDZlDqosZXWJtjYUgdx5aWbqKC2gr7wRxzVFh8Pg")
                .addBodyParameter("token", CacheUtils.getUserToken(this,"user"))
                .addBodyParameter("status", "")
                .addBodyParameter("city_id", "")
                .addBodyParameter("category_id", "")
                .addBodyParameter("type_id", "")
                .addBodyParameter("memory_id","")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        AppUtils.dismissProgressDialog();
//                        try {
//
//                            if (new JSONObject(response).getString("code").toString().equalsIgnoreCase("200")) {
//                                AppUtils.showSuccessToast(this,getString(R.string.your_request_done));
//                                startActivity(new Intent(getActivity(), CongratulationActivity.class));
//                            }else if (new JSONObject(response).getString("code").toString().equalsIgnoreCase("401")){
//                                AppUtils.showErrorToast(getActivity(),getString(R.string.your_request_not_done));
//                            }else {
//                                AppUtils.showErrorToast(getActivity(),getString(R.string.your_request_not_done));
//                            }
//
//                        } catch (Exception e) {
//                            AppUtils.showErrorToast(getActivity(),getString(R.string.your_request_not_done));
//                        }

                    }
                    @Override
                    public void onError(ANError anError) {
                        AppUtils.dismissProgressDialog();
//                        AppUtils.showErrorToast(getActivity(),getString(R.string.your_request_not_done));
                    }
                });
    }
}
