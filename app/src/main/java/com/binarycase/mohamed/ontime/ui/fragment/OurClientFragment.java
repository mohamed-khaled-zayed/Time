package com.binarycase.mohamed.ontime.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.adapter.OurClientAdapter;
import com.binarycase.mohamed.ontime.adapter.OurWorkAdapter;
import com.binarycase.mohamed.ontime.adapter.ServicesAdapter;
import com.binarycase.mohamed.ontime.data.model.OurClient;
import com.binarycase.mohamed.ontime.data.model.OurWork;
import com.binarycase.mohamed.ontime.data.model.Service;
import com.binarycase.mohamed.ontime.utils.AppUtils;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class OurClientFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private OurClientAdapter mAdapter;
    private List<OurClient> myAdsList = new ArrayList<>();
    ArrayList<String> customerImages;
    private ImageView mItem1,mItem2,mItem3,mNextBtn,mBackBtn;
    public OurClientFragment() {
        // Required empty public constructor
    }

    public static OurClientFragment newInstance(String param1, String param2) {
        OurClientFragment fragment = new OurClientFragment();
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
        View view=inflater.inflate(R.layout.fragment_our_client, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        mAdapter = new OurClientAdapter(getActivity(),myAdsList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mItem1=view.findViewById(R.id.first_item);
        mItem2=view.findViewById(R.id.second_item);
        mItem3=view.findViewById(R.id.third_item);
        mNextBtn=view.findViewById(R.id.next);
        mBackBtn=view.findViewById(R.id.back);


        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOurCustomersImages(3);
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOurCustomersImages(-3);
            }
        });
        ourCustomers();
        ourWorks();
        return view;
    }


    public void ourCustomers(){

        AndroidNetworking.get("https://ontime.sa/api/front?appKey=ontime")
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("ggggggg",response);

                        customerImages=new ArrayList<>();
                        try {
                            JSONObject object=new JSONObject(response).getJSONObject("response");
                            JSONArray jsonArray=object.getJSONArray("images_partners");

                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject object1=jsonArray.getJSONObject(i);
                                customerImages.add(object1.getString("path"));
                            }
                            setOurCustomersImages(3);
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

    private int counter=-1;
    private void setOurCustomersImages(int index) {
        int customersNumbers=customerImages.size();



        if (index>0){

            if (counter>=customersNumbers-1){
                AppUtils.showSuccessToast(getActivity(),"done");
            }else {
                counter=counter+index;
                try {
                    Picasso.with(getActivity()).load("https://ontime.sa/"+customerImages.get(counter-2)).into(mItem1);
                    Picasso.with(getActivity()).load("https://ontime.sa/"+customerImages.get(counter-1)).into(mItem2);
                    Picasso.with(getActivity()).load("https://ontime.sa/"+customerImages.get(counter)).into(mItem3);
                }catch (Exception e){

                }
            }

        }else if (index<0){
            if (counter==-1){
                AppUtils.showSuccessToast(getActivity(),"done");
            }else {
                counter=counter+index;
                try {
                    Picasso.with(getActivity()).load("https://ontime.sa/"+customerImages.get(counter+3)).into(mItem1);
                    Picasso.with(getActivity()).load("https://ontime.sa/"+customerImages.get(counter+2)).into(mItem2);
                    Picasso.with(getActivity()).load("https://ontime.sa/"+customerImages.get(counter+1)).into(mItem3);
                }catch (Exception e){

                }
            }
        }

    }

    public void ourWorks(){

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
                                myAdsList.add(ourWork);
                            }
                            mAdapter.notifyDataSetChanged();
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
