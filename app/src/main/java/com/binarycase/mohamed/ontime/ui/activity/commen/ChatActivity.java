package com.binarycase.mohamed.ontime.ui.activity.commen;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.utils.AppUtils;

public class ChatActivity extends AppCompatActivity {
    private TextView details,orderOptions,pay,messageContent,title;
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        myDialog = new Dialog(this);

        title=findViewById(R.id.toolbar_title);
        details= findViewById(R.id.chat_details);
        orderOptions= findViewById(R.id.chat_order_option);
        pay= findViewById(R.id.chat_pay);
        messageContent= findViewById(R.id.chat_message_content);

        AppUtils.applyMediumFont(orderOptions,messageContent,title);
        AppUtils.applyLightFont(details,pay);

    }

    public void details(View view) {
        AppUtils.applyMediumFont(details);
        AppUtils.applyLightFont(orderOptions,pay);

//        DialogFragment dialogFragment = new OrderDetailFragment();
//        dialogFragment.show(getSupportFragmentManager(), "dialog");


        ShowPopup();

    }

    public void ShowPopup() {
        myDialog.setContentView(R.layout.details_layout);

        ImageView imageView=myDialog.findViewById(R.id.close_dialog);
        TextView orderNote=myDialog.findViewById(R.id.note);
        TextView orderName=myDialog.findViewById(R.id.order_name);
        TextView orderDate=myDialog.findViewById(R.id.order_date);
        TextView orderDateValue=myDialog.findViewById(R.id.order_date_value);
        TextView orderStatus=myDialog.findViewById(R.id.order_status);
        TextView orderStatusValue=myDialog.findViewById(R.id.order_status_value);
        TextView orderPeriod=myDialog.findViewById(R.id.order_period);
        TextView orderPeriodValue=myDialog.findViewById(R.id.order_period_value);
        TextView employee=myDialog.findViewById(R.id.employee_name);
        TextView employeeName=myDialog.findViewById(R.id.employee_name_value);
        TextView department=myDialog.findViewById(R.id.department_name);
        TextView departmentValue=myDialog.findViewById(R.id.department_name_value);
        TextView orderPrice=myDialog.findViewById(R.id.order_price);
        TextView orderPriceValue=myDialog.findViewById(R.id.order_price_value);
        TextView orderNumber=myDialog.findViewById(R.id.order_number);
        TextView orderNumberValue=myDialog.findViewById(R.id.order_number_value);
        TextView sum=myDialog.findViewById(R.id.remain_sum);
        TextView sumValue=myDialog.findViewById(R.id.remain_sum_value);
        TextView services=myDialog.findViewById(R.id.services);
        TextView servicesValue1=myDialog.findViewById(R.id.services_name);
        TextView servicesValue2=myDialog.findViewById(R.id.services_name_2);
        TextView projectDetails=myDialog.findViewById(R.id.project_details);
        TextView projectDetailsValue=myDialog.findViewById(R.id.project_details_value);

        TextView circle_1=myDialog.findViewById(R.id.services_name_circle);
        TextView circle_2=myDialog.findViewById(R.id.services_name2_circle);

        circle_1.setText(Html.fromHtml("&#8226;"));
        circle_1.setTextSize(25);

        circle_2.setText(Html.fromHtml("&#8226;"));
        circle_2.setTextSize(25);
        AppUtils.applyMediumFont(orderNote,orderName,services,projectDetails,orderStatusValue,orderPriceValue,sumValue);
        AppUtils.applyLightFont(orderDate,servicesValue1,servicesValue2,projectDetailsValue,orderDateValue,orderStatus,orderPeriod,orderPeriodValue,employee,employeeName,department,departmentValue,orderPrice,orderNumber,orderNumberValue,sum);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void orderOptions(View view) {
        AppUtils.applyMediumFont(orderOptions);
        AppUtils.applyLightFont(details,pay);
        myDialog.setContentView(R.layout.order_option_layout);
        ImageView imageView=myDialog.findViewById(R.id.close_dialog);

        TextView coupon=myDialog.findViewById(R.id.coupon);
        TextView bill=myDialog.findViewById(R.id.bill);
        TextView receiveProject=myDialog.findViewById(R.id.receive_project);
        TextView rate=myDialog.findViewById(R.id.rate);
        TextView chatAdmin=myDialog.findViewById(R.id.chat_with_admin);

        AppUtils.applyLightFont(coupon,bill,receiveProject,rate,chatAdmin);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void pay(View view) {
        AppUtils.applyMediumFont(pay);
        AppUtils.applyLightFont(orderOptions,details);
    }


}
