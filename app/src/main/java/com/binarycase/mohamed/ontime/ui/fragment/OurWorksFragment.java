package com.binarycase.mohamed.ontime.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.utils.AppUtils;
import com.binarycase.mohamed.ontime.adapter.OurWorkAdapter;
import com.binarycase.mohamed.ontime.data.model.OurWork;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class OurWorksFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private OurWorkAdapter mAdapter;
    private List<OurWork> myAdsList = new ArrayList<>();

    private TextView graphicDesign,moshanGraphic,webAndApps,online;
    public OurWorksFragment() {
    }

    public static OurWorksFragment newInstance(String param1, String param2) {
        OurWorksFragment fragment = new OurWorksFragment();
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
        View view=inflater.inflate(R.layout.fragment_our_works, container, false);
        graphicDesign= view.findViewById(R.id.graphic_design);
        moshanGraphic= view.findViewById(R.id.graphic_moshian);
        webAndApps= view.findViewById(R.id.web_and_apps);
        online= view.findViewById(R.id.online_trade);
        recyclerView = view.findViewById(R.id.recycler_view);
        mAdapter = new OurWorkAdapter(getActivity(),myAdsList);

        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        graphicDesign();
        AppUtils.applyMediumFont(graphicDesign);
        AppUtils.applyLightFont(moshanGraphic,webAndApps,online);

        graphicDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.applyMediumFont(graphicDesign);
                AppUtils.applyLightFont(moshanGraphic,webAndApps,online);
                myAdsList.clear();
                mAdapter.notifyDataSetChanged();
                graphicDesign();
            }
        });

        moshanGraphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.applyMediumFont(moshanGraphic);
                AppUtils.applyLightFont(graphicDesign,webAndApps,online);
            }
        });

        webAndApps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.applyMediumFont(webAndApps);
                AppUtils.applyLightFont(graphicDesign,moshanGraphic,online);
            }
        });

        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.applyMediumFont(online);
                AppUtils.applyLightFont(graphicDesign,moshanGraphic,webAndApps);
            }
        });
        return view;
    }


    public void graphicDesign(){
        AppUtils.showProgressDialog(getActivity());

        AndroidNetworking.get("https://ontime.sa/api/front?appKey=ontime")
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("ggggggg",response);
                        AppUtils.dismissProgressDialog();

                        try {
                            JSONObject object=new JSONObject(response).getJSONObject("response");
                            JSONArray jsonArray=object.getJSONArray("images_works");

                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject object1=jsonArray.getJSONObject(i);

                                OurWork ourWork=new OurWork(object1.getString("name"),object1.getString("path"),object1.getString("url"),object1.getString("description"));
                                myAdsList.add(ourWork);
                            }
                            mAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    @Override
                    public void onError(ANError anError) {
                        AppUtils.dismissProgressDialog();
//                        AppUtils.showInfoDialog(SignUpActivity.this,R.string.error_dialog_cannot_register);
                    }
                });
    }

    public void motionDesign(){
        AppUtils.showProgressDialog(getActivity());

        AndroidNetworking.get("https://ontime.sa/api/front?appKey=ontime")
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("ggggggg",response);
                        AppUtils.dismissProgressDialog();

                        try {
                            JSONObject object=new JSONObject(response).getJSONObject("response");
                            JSONArray jsonArray=object.getJSONArray("images_works");

                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject object1=jsonArray.getJSONObject(i);

                                OurWork ourWork=new OurWork(object1.getString("name"),object1.getString("path"),object1.getString("url"),object1.getString("description"));
                                myAdsList.add(ourWork);
                            }
                            mAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    @Override
                    public void onError(ANError anError) {
                        AppUtils.dismissProgressDialog();
//                        AppUtils.showInfoDialog(SignUpActivity.this,R.string.error_dialog_cannot_register);
                    }
                });
    }

    public void wedAndApps(){
        AppUtils.showProgressDialog(getActivity());

        AndroidNetworking.get("https://ontime.sa/api/front?appKey=ontime")
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("ggggggg",response);
                        AppUtils.dismissProgressDialog();

                        try {
                            JSONObject object=new JSONObject(response).getJSONObject("response");
                            JSONArray jsonArray=object.getJSONArray("images_works");

                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject object1=jsonArray.getJSONObject(i);

                                OurWork ourWork=new OurWork(object1.getString("name"),object1.getString("path"),object1.getString("url"),object1.getString("description"));
                                myAdsList.add(ourWork);
                            }
                            mAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    @Override
                    public void onError(ANError anError) {
                        AppUtils.dismissProgressDialog();
//                        AppUtils.showInfoDialog(SignUpActivity.this,R.string.error_dialog_cannot_register);
                    }
                });
    }

    public void onlieMarkting(){
        AppUtils.showProgressDialog(getActivity());

        AndroidNetworking.get("https://ontime.sa/api/front?appKey=ontime")
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("ggggggg",response);
                        AppUtils.dismissProgressDialog();

                        try {
                            JSONObject object=new JSONObject(response).getJSONObject("response");
                            JSONArray jsonArray=object.getJSONArray("images_works");

                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject object1=jsonArray.getJSONObject(i);

                                OurWork ourWork=new OurWork(object1.getString("name"),object1.getString("path"),object1.getString("url"),object1.getString("description"));
                                myAdsList.add(ourWork);
                            }
                            mAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    @Override
                    public void onError(ANError anError) {
                        AppUtils.dismissProgressDialog();
//                        AppUtils.showInfoDialog(SignUpActivity.this,R.string.error_dialog_cannot_register);
                    }
                });
    }


}
