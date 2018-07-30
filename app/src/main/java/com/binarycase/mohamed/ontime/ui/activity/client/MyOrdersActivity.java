package com.binarycase.mohamed.ontime.ui.activity.client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.utils.AppUtils;

public class MyOrdersActivity extends AppCompatActivity {
    private TextView stillWorking,completed,revision,canceled;

    private TextView title,num_projects,name,date,run,name2,date2,run2,name3,date3,run3,num_projects2,namew,titleb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        titleb=findViewById(R.id.toolbar_title);

        stillWorking= findViewById(R.id.stillWorking);
        completed= findViewById(R.id.completed);
        revision= findViewById(R.id.revision);
        canceled= findViewById(R.id.canceled);

        title= findViewById(R.id.order_title);
        num_projects= findViewById(R.id.orders_number);
        name= findViewById(R.id.order_name);
        date= findViewById(R.id.order_date);
        run= findViewById(R.id.run);
        name2= findViewById(R.id.order_name2);
        date2= findViewById(R.id.order_date2);
        run2= findViewById(R.id.run2);
        name3= findViewById(R.id.order_name3);
        date3= findViewById(R.id.order_date3);
        run3= findViewById(R.id.run3);
        num_projects2= findViewById(R.id.project_num);
        namew= findViewById(R.id.pro_nam);

        AppUtils.applyMediumFont(stillWorking,title,name,run,name2,run2,namew,run3,name3,titleb);
        AppUtils.applyLightFont(completed,revision,canceled,num_projects,date,date2,num_projects2,date3);

        stillWorking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.applyMediumFont(stillWorking);
                AppUtils.applyLightFont(completed,revision,canceled);
            }
        });

        completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.applyMediumFont(completed);
                AppUtils.applyLightFont(stillWorking,revision,canceled);
            }
        });

        revision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.applyMediumFont(revision);
                AppUtils.applyLightFont(stillWorking,completed,canceled);
            }
        });

        canceled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.applyMediumFont(canceled);
                AppUtils.applyLightFont(stillWorking,completed,revision);
            }
        });
    }
}
