package com.binarycase.mohamed.ontime.ui.activity.client;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.utils.AppUtils;
import com.binarycase.mohamed.ontime.adapter.SpinnerItemsAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewOrderActivity extends AppCompatActivity {

    private TextView please,ask,field,type,extra,voice_1_2,voice_2_4,voice_4_8,writeStory,fastService,price,title;
    private Button conutine,cancel;
    private Spinner fieldTypeSpinner,ordersTypeSpinner;
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        index=getIntent().getIntExtra("index",0);
        title=findViewById(R.id.toolbar_title);
        ordersTypeSpinner=findViewById(R.id.order_type_spinner);
        fieldTypeSpinner=findViewById(R.id.field_type_spinner);
        please= findViewById(R.id.new_order_please);
        ask= findViewById(R.id.new_order_ask);
        field= findViewById(R.id.new_order_field);
        type= findViewById(R.id.new_order_type);
        extra= findViewById(R.id.new_order_extra);
        voice_1_2= findViewById(R.id.new_order_voice_1_2);
        voice_2_4= findViewById(R.id.new_order_voice_2_4);
        voice_4_8= findViewById(R.id.new_order_voice_4_8);
        writeStory= findViewById(R.id.new_order_write_story);
        fastService= findViewById(R.id.new_order_fast_service);
        price= findViewById(R.id.new_order_price);

        conutine= findViewById(R.id.new_order_conutine);
        cancel= findViewById(R.id.new_order_cancel);
        setOrderrSpinner(getOrderType(this));
        setFieldSpinner(getFieldType(this));

        fieldTypeSpinner.setSelection(index);

        AppUtils.applyBoldFont(please,conutine,cancel);
        AppUtils.applyLightFont(ask,voice_1_2,voice_2_4,voice_4_8,writeStory,fastService);
        AppUtils.applyMediumFont(field,type,extra,price,title);

    }

    public void setOrderrSpinner(List<String> list){
        SpinnerItemsAdapter adapter=new SpinnerItemsAdapter(list);
        ordersTypeSpinner.setAdapter(adapter);
    }

    public void setFieldSpinner(List<String> list){
        SpinnerItemsAdapter adapter=new SpinnerItemsAdapter(list);
        fieldTypeSpinner.setAdapter(adapter);
    }
    public static List<String> getFieldType(Context context) {
        String[] genderArray = context.getResources().getStringArray(R.array.field_type);
        final List<String> arrayList = new ArrayList<>(genderArray.length);
        arrayList.add(genderArray[0]);
        arrayList.add(genderArray[1]);
        arrayList.add(genderArray[2]);
        arrayList.add(genderArray[3]);
        arrayList.add(genderArray[4]);
        arrayList.add(genderArray[5]);
        arrayList.add(genderArray[6]);
        arrayList.add(genderArray[7]);
        arrayList.add(genderArray[8]);
        return arrayList;
    }

    public static List<String> getOrderType(Context context) {
        String[] genderArray = context.getResources().getStringArray(R.array.order_type);
        final List<String> arrayList = new ArrayList<>(genderArray.length);
        arrayList.add(genderArray[0]);
        arrayList.add(genderArray[1]);
        arrayList.add(genderArray[2]);
        arrayList.add(genderArray[3]);
        arrayList.add(genderArray[4]);
        arrayList.add(genderArray[5]);
        arrayList.add(genderArray[6]);
        arrayList.add(genderArray[7]);
        arrayList.add(genderArray[8]);
        return arrayList;
    }
    public void continueOrder(View view) {
        startActivity(new Intent(this,ContinueActivity.class));
    }

    public void back(View view) {
        onBackPressed();
    }

    public void loadFieldType(){
        AndroidNetworking.post("https://ontime.sa/api/client_login?appKey=ontime")
                .addBodyParameter("userlogin","1")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        AppUtils.dismissProgressDialog();
                        Log.e("response",response);
                    }
                    @Override
                    public void onError(ANError anError) {
                        AppUtils.dismissProgressDialog();
                        Log.e("Error" , anError.getMessage().toString());
                    }
                });
    }

    public void loadOrderType(){
        AndroidNetworking.post("https://ontime.sa/api/client_login?appKey=ontime")
                .addBodyParameter("userlogin","1")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        AppUtils.dismissProgressDialog();
                        Log.e("response",response);
                    }
                    @Override
                    public void onError(ANError anError) {
                        AppUtils.dismissProgressDialog();
                        Log.e("Error" , anError.getMessage().toString());
                    }
                });
    }
}
