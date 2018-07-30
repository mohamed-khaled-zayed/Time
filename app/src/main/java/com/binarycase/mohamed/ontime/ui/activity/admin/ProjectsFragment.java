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


public class ProjectsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView revision,revisionNum,executing,executingNum,completed,completedNum,canceled,canceledNum,late,lateNum;

    public ProjectsFragment() {
        // Required empty public constructor
    }


    public static ProjectsFragment newInstance(String param1, String param2) {
        ProjectsFragment fragment = new ProjectsFragment();
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
        View view=inflater.inflate(R.layout.fragment_projects, container, false);
        revision=view.findViewById(R.id.project_revision);
        revisionNum=view.findViewById(R.id.project_revision_number);
        executing=view.findViewById(R.id.project_executing);
        executingNum=view.findViewById(R.id.project_executing_number);
        completed=view.findViewById(R.id.project_completed);
        completedNum=view.findViewById(R.id.project_completed_number);
        canceled=view.findViewById(R.id.project_canceled);
        canceledNum=view.findViewById(R.id.project_canceled_number);
        late=view.findViewById(R.id.project_late);
        lateNum=view.findViewById(R.id.project_late_number);

        AppUtils.applyMediumFont(revision,revisionNum,executing,executingNum,completed,completedNum,canceled,canceledNum,late,lateNum);

        return view;
    }



}
