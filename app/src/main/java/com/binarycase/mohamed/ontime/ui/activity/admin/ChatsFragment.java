package com.binarycase.mohamed.ontime.ui.activity.admin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.utils.AppUtils;


public class ChatsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView employees,chats,chatsNum,lastChat,customers,total,customersNum,lastNoti;

    public ChatsFragment() {
        // Required empty public constructor
    }


    public static ChatsFragment newInstance(String param1, String param2) {
        ChatsFragment fragment = new ChatsFragment();
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
        View view=inflater.inflate(R.layout.fragment_chats, container, false);
        employees=view.findViewById(R.id.chats_employees);
        chats=view.findViewById(R.id.chats_total_chat);
        chatsNum=view.findViewById(R.id.chats_total_chat_numbers);
        lastChat=view.findViewById(R.id.chats_last_chat);
        customers=view.findViewById(R.id.customers);
        total=view.findViewById(R.id.chats_total_customers);
        customersNum=view.findViewById(R.id.chats_total_customers_numbers);
        lastNoti=view.findViewById(R.id.chats_last_noti);

        AppUtils.applyMediumFont(customers,employees,chats,total,chatsNum,customersNum);
        AppUtils.applyLightFont(lastChat,lastNoti);
        return view;
    }


}
