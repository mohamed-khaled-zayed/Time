package com.binarycase.mohamed.ontime.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.interfaces.IOurWorkHandler;
import com.binarycase.mohamed.ontime.utils.CustomTypefaceSpan;
import com.binarycase.mohamed.ontime.data.model.OurWork;
import com.binarycase.mohamed.ontime.utils.AppUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OurWorkAdapter extends RecyclerView.Adapter<OurWorkAdapter.MyViewHolder> {

    private List<OurWork> ourWorks;
    private Context context;
    private IOurWorkHandler handler;
    public OurWorkAdapter(Context context, List<OurWork> ourWorks) {
        this.ourWorks = ourWorks;
        this.context=context;
        handler= (IOurWorkHandler) context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.our_work_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final OurWork ourWork = ourWorks.get(position);
        holder.title.setText(ourWork.getName());

        try {
            Picasso.with(context).load("https://ontime.sa/"+ourWork.getImage()).into(holder.poster);
        }catch (Exception e){

        }

        holder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.onClick(ourWork.getUrl());
            }
        });

    }

    @Override
    public int getItemCount() {
        if (ourWorks.size()==0){
            return 0;
        }
        return ourWorks.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, type;
        public ImageView poster;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.project_address);
            type = view.findViewById(R.id.project_type);
            poster=view.findViewById(R.id.our_works_poster);
            AppUtils.applyMediumFont(title);
            AppUtils.applyLightFont(type);
        }
    }

}