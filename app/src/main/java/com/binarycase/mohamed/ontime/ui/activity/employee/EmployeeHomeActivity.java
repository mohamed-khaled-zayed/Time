package com.binarycase.mohamed.ontime.ui.activity.employee;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.ui.fragment.OrderDetailFragment;
import com.binarycase.mohamed.ontime.ui.fragment.ServicesFragment;
import com.binarycase.mohamed.ontime.utils.AppUtils;

import java.lang.reflect.Field;

public class EmployeeHomeActivity extends AppCompatActivity {

    private TextView projects,support,management,messageContent,title;
    private ImageView main_menu;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        projects= findViewById(R.id.employee_projects);
        support= findViewById(R.id.employee_support);
        management= findViewById(R.id.employee_management);
        toolbar=findViewById(R.id.toolbar_employee);
        main_menu=findViewById(R.id.main_menu_icon);

        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PopupMenu popupMenu = new PopupMenu(EmployeeHomeActivity.this, v);
//                popupMenu.inflate(R.menu.main_menu);
//
//// Force icons to show
//                Object menuHelper;
//                Class[] argTypes;
//                try {
//                    Field fMenuHelper = PopupMenu.class.getDeclaredField("mPopup");
//                    fMenuHelper.setAccessible(true);
//                    menuHelper = fMenuHelper.get(popupMenu);
//                    argTypes = new Class[] { boolean.class };
//                    menuHelper.getClass().getDeclaredMethod("setForceShowIcon", argTypes).invoke(menuHelper, true);
//                } catch (Exception e) {
//                    // Possible exceptions are NoSuchMethodError and NoSuchFieldError
//                    //
//                    // In either case, an exception indicates something is wrong with the reflection code, or the
//                    // structure of the PopupMenu class or its dependencies has changed.
//                    //
//                    // These exceptions should never happen since we're shipping the AppCompat library in our own apk,
//                    // but in the case that they do, we simply can't force icons to display, so log the error and
//                    // show the menu normally.
//
////                    Log.w(TheseAG, "error forcing menu icons to show", e);
//                    popupMenu.show();
//                    return;
//                }
//
//                popupMenu.show();

//
//                int[] location = new int[2];
////                currentRowId = position;
////                currentRow = v;
//                // Get the x, y location and store it in the location[] array
//                // location[0] = x, location[1] = y.
//                v.getLocationOnScreen(location);
//
//                Point point;
//                //Initialize the Point with x, and y positions
//                point = new Point();
//                point.x = location[0];
//                point.y = location[1];
//                showStatusPopup(EmployeeHomeActivity.this, point);

                //Open popup window
                if (p != null)
                    showPopup(EmployeeHomeActivity.this, p);

            }
        }); //closing the setOnClickListener method
        AppUtils.applyMediumFont(projects);
        AppUtils.applyLightFont(support,management);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, EmployeeProjectsFragment.newInstance("",""));
        transaction.commit();
    }
    //The "x" and "y" position of the "Show Button" on screen.
    Point p;


    // Get the x and y position after the button is draw on screen
// (It's important to note that we can't get the position in the onCreate(),
// because at that stage most probably the view isn't drawn yet, so it will return (0, 0))
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        int[] location = new int[2];
//        Button button = (Button) findViewById(R.id.show_popup);

        // Get the x, y location and store it in the location[] array
        // location[0] = x, location[1] = y.
        main_menu.getLocationOnScreen(location);

        //Initialize the Point with x, and y positions
        p = new Point();
        p.x = location[0];
        p.y = location[1];
    }

    // The method that displays the popup.
    private void showPopup(final Activity context, Point p) {
        int popupWidth = 400;
        int popupHeight = 580;

        // Inflate the popup_layout.xml
        CardView viewGroup = (CardView) context.findViewById(R.id.llSortChangePopup);
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.custom_popup_layout, viewGroup);
//        layout.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView main=layout.findViewById(R.id.home_page);
        TextView myAccount=layout.findViewById(R.id.my_account);
        TextView projects=layout.findViewById(R.id.projects);
        ImageView close=layout.findViewById(R.id.close_btn);

        AppUtils.applyMediumFont(main,myAccount,projects);
        // Creating the PopupWindow
        final PopupWindow popup = new PopupWindow(context);
        popup.setContentView(layout);
        popup.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popup.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popup.setFocusable(true);

        // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
        int OFFSET_X = 30;
        int OFFSET_Y = -50;

        // Clear the default translucent background
        popup.setBackgroundDrawable(new BitmapDrawable());

        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y + OFFSET_Y);

        // Getting a reference to Close button, and close the popup when clicked.
        close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });
    }
    public void userProfile(View view) {
    }

    public void projects(View view) {
        AppUtils.applyMediumFont(projects);
        AppUtils.applyLightFont(support,management);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, EmployeeProjectsFragment.newInstance("",""));
        transaction.commit();
    }

    public void support(View view) {
        AppUtils.applyMediumFont(support);
        AppUtils.applyLightFont(projects,management);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, EmployeeSupportFragment.newInstance("",""));
        transaction.commit();
    }

    public void management(View view) {
        AppUtils.applyMediumFont(management);
        AppUtils.applyLightFont(projects,support);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, EmployeeManagementFragment.newInstance("",""));
        transaction.commit();
    }


}
