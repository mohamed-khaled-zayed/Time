package com.binarycase.mohamed.ontime.ui.activity.client;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.interfaces.IOurWorkHandler;
import com.binarycase.mohamed.ontime.ui.activity.commen.SettingsActivity;
import com.binarycase.mohamed.ontime.ui.activity.admin.AdminHomeActivity;
import com.binarycase.mohamed.ontime.ui.activity.admin.ProjectsActivity;
import com.binarycase.mohamed.ontime.ui.activity.employee.EmployeeHomeActivity;
import com.binarycase.mohamed.ontime.utils.AppUtils;
import com.binarycase.mohamed.ontime.utils.CustomTypefaceSpan;
import com.binarycase.mohamed.ontime.ui.fragment.OurClientFragment;
import com.binarycase.mohamed.ontime.ui.fragment.OurWorksFragment;
import com.binarycase.mohamed.ontime.ui.fragment.ServicesFragment;

public class HomeActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener,IOurWorkHandler {
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private ImageView mani_menu;

    private TextView services,ourWork,ourClient,startProject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mani_menu=findViewById(R.id.main_menu_icon);
        drawer = findViewById(R.id.drawer_layout);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        services= findViewById(R.id.home_services);
        ourWork= findViewById(R.id.home_our_work);
        ourClient= findViewById(R.id.home_our_client);
        startProject= findViewById(R.id.home_project);


        services.setTextColor(getResources().getColor(R.color.text_color));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, ServicesFragment.newInstance("",""));
        transaction.commit();
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                services.setTextColor(getResources().getColor(R.color.text_color));
                ourWork.setTextColor(getResources().getColor(R.color.text_red_color));
                ourClient.setTextColor(getResources().getColor(R.color.text_red_color));
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, ServicesFragment.newInstance("",""));
                transaction.commit();
            }
        });

        ourWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                services.setTextColor(getResources().getColor(R.color.text_red_color));
                ourWork.setTextColor(getResources().getColor(R.color.text_color));
                ourClient.setTextColor(getResources().getColor(R.color.text_red_color));
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, OurWorksFragment.newInstance("",""));
                transaction.commit();
            }
        });

        ourClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                services.setTextColor(getResources().getColor(R.color.text_red_color));
                ourWork.setTextColor(getResources().getColor(R.color.text_red_color));
                ourClient.setTextColor(getResources().getColor(R.color.text_color));
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, OurClientFragment.newInstance("",""));
                transaction.commit();
            }
        });

        AppUtils.applyMediumFont(services,ourWork,ourClient,startProject);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.app_name);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);

        Menu m = navigationView.getMenu();
        for (int i=0;i<m.size();i++) {
            MenuItem mi = m.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu!=null && subMenu.size() >0 ) {
                for (int j=0; j <subMenu.size();j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    subMenuItem.setVisible(false);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            applyFontToMenuItem(mi);
        }
        navigationView.setNavigationItemSelectedListener(this);
        disableNavigationViewScrollbars(navigationView);
        toolbar.setNavigationIcon(null);

        mani_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

    }

    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "GE_SS_Two_Medium.otf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("5" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    private void disableNavigationViewScrollbars(NavigationView navigationView) {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }

    @Override
    public void onBackPressed() {
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.home:
                // my account click.
                    startActivity(new Intent(HomeActivity.this,HomeActivity.class));

                break;

            case R.id.my_account:
                    startActivity(new Intent(HomeActivity.this,UserProfileActivity.class));

                break;

            case R.id.my_orders:
                    startActivity(new Intent(HomeActivity.this,MyOrdersActivity.class));

                break;

            case R.id.department:
                startActivity(new Intent(this,SelectNewOrderActivity.class));
                break;

            case R.id.services:
//                Intent intent=new Intent(HomeActivity.this,HomeActivity.class);
//                intent.putExtra("")
//                startActivity(intent);
                services.setTextColor(getResources().getColor(R.color.text_color));
                ourWork.setTextColor(getResources().getColor(R.color.text_red_color));
                ourClient.setTextColor(getResources().getColor(R.color.text_red_color));
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, ServicesFragment.newInstance("",""));
                transaction.commit();
                break;

            case R.id.our_works:
                services.setTextColor(getResources().getColor(R.color.text_red_color));
                ourWork.setTextColor(getResources().getColor(R.color.text_color));
                ourClient.setTextColor(getResources().getColor(R.color.text_red_color));
                FragmentTransaction our_works = getSupportFragmentManager().beginTransaction();
                our_works.replace(R.id.framelayout, OurWorksFragment.newInstance("",""));
                our_works.commit();
                break;

            case R.id.who_us:
                startActivity(new Intent(HomeActivity.this,AdminHomeActivity.class));
                break;

            case R.id.terms:
                startActivity(new Intent(HomeActivity.this,ProjectsActivity.class));
                break;

            case R.id.bank:
                startActivity(new Intent(HomeActivity.this,EmployeeHomeActivity.class));
                break;

            case R.id.language:
                startActivity(new Intent(HomeActivity.this,SettingsActivity.class));
                break;

            case R.id.logout:

                break;


        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void startProject(View view) {
        startActivity(new Intent(this,SelectNewOrderActivity.class));
    }

    public void userProfile(View view) {
        startActivity(new Intent(this,UserProfileActivity.class));
    }

    @Override
    public void onClick(String url) {
        AppUtils.showSuccessToast(this,url);
    }
}
