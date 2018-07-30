package com.binarycase.mohamed.ontime.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.adapter.ServicesAdapter;
import com.binarycase.mohamed.ontime.data.model.Service;
import com.binarycase.mohamed.ontime.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ServicesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServicesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private ServicesAdapter mAdapter;
    private List<Service> myAdsList = new ArrayList<>();

    public ServicesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServicesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServicesFragment newInstance(String param1, String param2) {
        ServicesFragment fragment = new ServicesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_services, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        mAdapter = new ServicesAdapter(getActivity(),myAdsList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        init();
        return view;
    }


    public void init(){
        Service ourWork=new Service("id", "عنوان المشروع" ,"تصميم الجرافيك");

        ourWork=new Service("id","عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);
        ourWork=new Service("id","عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);

        ourWork=new Service("id", "عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);

        ourWork=new Service("id", "عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);

        ourWork=new Service("id", "عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);

        ourWork=new Service("id", "عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);

        ourWork=new Service("id","عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);
        ourWork=new Service("id","عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);

        ourWork=new Service("id", "عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);

        ourWork=new Service("id", "عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);

        ourWork=new Service("id", "عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);

        ourWork=new Service("id", "عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);

        ourWork=new Service("id","عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);
        ourWork=new Service("id","عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);

        ourWork=new Service("id", "عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);

        ourWork=new Service("id", "عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);

        ourWork=new Service("id", "عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);

        ourWork=new Service("id", "عنوان المشروع" ,"تصميم الجرافيك");
        myAdsList.add(ourWork);

        mAdapter.notifyDataSetChanged();
    }

    public void loadServices(){
        AppUtils.showProgressDialog(getActivity());

        AndroidNetworking.post("https://ontime.sa/api/client_register?appKey=ontime")
                .addBodyParameter("first_name", "mohamed")
                .addBodyParameter("second_name", "ali")
                .addBodyParameter("third_name", "sderi")
                .addBodyParameter("register_type", "1")
                .addBodyParameter("password2", "234fgMfe")
                .addBodyParameter("confirmpassword", "234fgMfe")
                .addBodyParameter("accept_terms", "1")
                .addBodyParameter("bill_firm", "1")
                .addBodyParameter("email", "tee654@gmail.com")
                .addBodyParameter("phone", "4563235")
                .addBodyParameter("addaccount", "1")
                .addBodyParameter("firm_name","tera")

                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("ggggggg",response);
                        AppUtils.dismissProgressDialog();

                    }
                    @Override
                    public void onError(ANError anError) {
                        AppUtils.dismissProgressDialog();
//                        AppUtils.showInfoDialog(SignUpActivity.this,R.string.error_dialog_cannot_register);
                    }
                });
    }
}
