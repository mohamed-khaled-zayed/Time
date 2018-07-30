package com.binarycase.mohamed.ontime.ui.activity.admin;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.ui.fragment.ServicesFragment;
import com.binarycase.mohamed.ontime.utils.AppUtils;

public class AdminHomeActivity extends AppCompatActivity {

    private TextView statistics,projects,payment,support,chats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        statistics=findViewById(R.id.statictcs);
        projects=findViewById(R.id.projects);
        payment=findViewById(R.id.payment);
        support=findViewById(R.id.center_support);
        chats=findViewById(R.id.chats);

        AppUtils.applyLightFont(payment,projects,support,chats);

        AppUtils.applyMediumFont(statistics);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, StatisticsFragment.newInstance("",""));
        transaction.commit();

        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.applyMediumFont(statistics);
                AppUtils.applyLightFont(payment,projects,support,chats);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, StatisticsFragment.newInstance("",""));
                transaction.commit();
            }
        });

        projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.applyMediumFont(projects);
                AppUtils.applyLightFont(payment,statistics,support,chats);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, ProjectsFragment.newInstance("",""));
                transaction.commit();
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.applyMediumFont(payment);
                AppUtils.applyLightFont(statistics,projects,support,chats);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, PaymentFragment.newInstance("",""));
                transaction.commit();
            }
        });

        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.applyMediumFont(support);
                AppUtils.applyLightFont(payment,projects,statistics,chats);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, SupportFragment.newInstance("",""));
                transaction.commit();
            }
        });

        chats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.applyMediumFont(chats);
                AppUtils.applyLightFont(payment,projects,support,statistics);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, ChatsFragment.newInstance("",""));
                transaction.commit();
            }
        });
    }

    public void userProfile(View view) {
    }
}
