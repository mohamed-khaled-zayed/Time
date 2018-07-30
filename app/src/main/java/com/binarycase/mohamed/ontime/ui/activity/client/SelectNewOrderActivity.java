package com.binarycase.mohamed.ontime.ui.activity.client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.ui.activity.commen.ChatActivity;
import com.binarycase.mohamed.ontime.utils.AppUtils;

public class SelectNewOrderActivity extends AppCompatActivity {
    private TextView graphicDesign,video,webSite,androidApps,online,offers,openTicket,orderHost,other,newOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Making notification bar transparent

        setContentView(R.layout.activity_select_new_order);

        graphicDesign= findViewById(R.id.select_order_graphic_design);
        video= findViewById(R.id.select_order_video);
        webSite= findViewById(R.id.select_order_web_site);
        androidApps= findViewById(R.id.select_order_android_app);
        online= findViewById(R.id.select_order_online_trade);
        offers= findViewById(R.id.select_order_offers);
        openTicket= findViewById(R.id.select_order_open_ticket);
        orderHost= findViewById(R.id.select_order_order_host);
        other= findViewById(R.id.select_order_other);
        newOrder= findViewById(R.id.select_order_new_order);

        AppUtils.applyBoldFont(newOrder);
        AppUtils.applyMediumFont(graphicDesign,video,webSite,androidApps,online,offers,openTicket,orderHost,other);
    }


    public void graphicDesign(View view) {
        Intent intent=new Intent(this,NewOrderActivity.class);
        intent.putExtra("index",0);
        startActivity(intent);
    }

    public void videoMotion(View view) {
        Intent intent=new Intent(this,NewOrderActivity.class);
        intent.putExtra("index",1);
        startActivity(intent);    }

    public void webSites(View view) {
        Intent intent=new Intent(this,NewOrderActivity.class);
        intent.putExtra("index",2);
        startActivity(intent);    }

    public void phoneApps(View view) {
        Intent intent=new Intent(this,NewOrderActivity.class);
        intent.putExtra("index",3);
        startActivity(intent);    }

    public void onlineTrade(View view) {
        Intent intent=new Intent(this,NewOrderActivity.class);
        intent.putExtra("index",4);
        startActivity(intent);    }

    public void offers(View view) {
        Intent intent=new Intent(this,NewOrderActivity.class);
        intent.putExtra("index",5);
        startActivity(intent);    }

    public void openTicket(View view) {
        Intent intent=new Intent(this,NewOrderActivity.class);
        intent.putExtra("index",6);
        startActivity(intent);    }

    public void askHost(View view) {
        Intent intent=new Intent(this,NewOrderActivity.class);
        intent.putExtra("index",7);
        startActivity(intent);    }

    public void other(View view) {
        Intent intent=new Intent(this,NewOrderActivity.class);
        intent.putExtra("index",8);
        startActivity(intent);    }

    public void addNewProject(View view) {
        Intent intent=new Intent(this,NewOrderActivity.class);
        startActivity(intent);
    }

    public void openChat(View view) {
        Intent intent=new Intent(this,ChatActivity.class);
        startActivity(intent);
    }
}
