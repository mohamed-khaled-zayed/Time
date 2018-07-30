package com.binarycase.mohamed.ontime.ui.fragment;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;


import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.data.model.OurClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class OrderDetailFragment extends DialogFragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order_detail, container, false);

        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return v;
    }

    public void loadOrderDetails(){

        AndroidNetworking.get("https://ontime.sa/api/front?appKey=ontime")
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("ggggggg",response);

                        try {
                            JSONObject object=new JSONObject(response).getJSONObject("response");
                            JSONArray jsonArray=object.getJSONArray("images_customers_opinion");

                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject object1=jsonArray.getJSONObject(i);

                                OurClient ourWork=new OurClient(object1.getString("name"),object1.getString("image"),object1.getString("description"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    @Override
                    public void onError(ANError anError) {
//                        AppUtils.showInfoDialog(SignUpActivity.this,R.string.error_dialog_cannot_register);
                    }
                });
    }

}


