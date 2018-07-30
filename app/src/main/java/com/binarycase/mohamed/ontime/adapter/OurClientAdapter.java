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
import com.binarycase.mohamed.ontime.data.model.OurClient;
import com.binarycase.mohamed.ontime.utils.CustomTypefaceSpan;
import com.binarycase.mohamed.ontime.data.model.OurWork;
import com.binarycase.mohamed.ontime.utils.AppUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OurClientAdapter extends RecyclerView.Adapter<OurClientAdapter.MyViewHolder> {

    private List<OurClient> ourClients;
    private Context context;
    public OurClientAdapter(Context context, List<OurClient> ourClients) {
        this.ourClients = ourClients;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final OurClient ourClient = ourClients.get(position);
        holder.name.setText(ourClient.getName());
        holder.review.setText(ourClient.getReview());

        try {
//            Picasso.with(context).load(ourClient.getImage()).into(holder.profile);
        }catch (Exception e){

        }

    }

    @Override
    public int getItemCount() {
        if (ourClients.size()==0){
            return 0;
        }
        return ourClients.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, review;
        public ImageView profile;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.customer_name);
            review = view.findViewById(R.id.customer_review);

        }
    }

}