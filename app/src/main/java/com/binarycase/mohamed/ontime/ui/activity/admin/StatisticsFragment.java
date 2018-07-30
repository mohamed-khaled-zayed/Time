package com.binarycase.mohamed.ontime.ui.activity.admin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.utils.AppUtils;


public class StatisticsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private TextView projects,revision,revisionNum,executing,executingNum,late,lateNum,tolalNoti,totalChats,support,chats,lastNoti,lastChat,totNotiNum,totChatNum;
    public StatisticsFragment() {
        // Required empty public constructor
    }

    public static StatisticsFragment newInstance(String param1, String param2) {
        StatisticsFragment fragment = new StatisticsFragment();
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
        View view=inflater.inflate(R.layout.fragment_statistics, container, false);
        projects=view.findViewById(R.id.admin_projects);
        revision=view.findViewById(R.id.admin_revision);
        revisionNum=view.findViewById(R.id.admin_revision_numbers);
        executing=view.findViewById(R.id.admin_execting);
        executingNum=view.findViewById(R.id.admin_execting_numbers);
        late=view.findViewById(R.id.admin_late);
        lateNum=view.findViewById(R.id.admin_late_numbers);
        tolalNoti=view.findViewById(R.id.admin_total_noti);
        totalChats=view.findViewById(R.id.admin_total_chats);
        support=view.findViewById(R.id.admin_support);
        chats=view.findViewById(R.id.chats);
        lastNoti=view.findViewById(R.id.last_notification);
        lastChat=view.findViewById(R.id.last_chat);
        totChatNum=view.findViewById(R.id.admin_total_chats_numbers);
        totNotiNum=view.findViewById(R.id.admin_total_noti_numbers);


        executing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ProjectDetailsActivity.class));
            }
        });
        AppUtils.applyMediumFont(projects,executing,revision,late,support,chats,revisionNum,executingNum,lateNum,tolalNoti,totalChats,totNotiNum,totChatNum);
        AppUtils.applyLightFont(lastChat,lastNoti);



        return view;
    }





}
