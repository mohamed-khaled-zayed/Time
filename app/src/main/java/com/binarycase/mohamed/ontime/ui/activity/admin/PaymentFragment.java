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


public class PaymentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView revision,revisionNum,paymentConfirm,paymentConfirmNum,paymentNotPay,paymentNotPayNum;

    public PaymentFragment() {
        // Required empty public constructor
    }


    public static PaymentFragment newInstance(String param1, String param2) {
        PaymentFragment fragment = new PaymentFragment();
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
        View view=inflater.inflate(R.layout.fragment_payment, container, false);
        revision=view.findViewById(R.id.payment_revision);
        revisionNum=view.findViewById(R.id.payment_revision_numbers);
        paymentConfirm=view.findViewById(R.id.payment_confirm);
        paymentConfirmNum=view.findViewById(R.id.payment_confirm_numbers);
        paymentNotPay=view.findViewById(R.id.payment_not_pay);
        paymentNotPayNum=view.findViewById(R.id.payment_not_pay_numbers);

        AppUtils.applyMediumFont(revision,revisionNum,paymentConfirm,paymentConfirmNum,paymentNotPay,paymentNotPayNum);
        return view;
    }


}
