package com.binarycase.mohamed.ontime.ui.activity.admin;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.ui.fragment.OrderDetailFragment;

public class ProjectDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details);



    }

    public void showPopUp(View view) {
        DialogFragment dialogFragment = new OrderDetailFragment();
        dialogFragment.show(getSupportFragmentManager(), "dialog");
    }
}
