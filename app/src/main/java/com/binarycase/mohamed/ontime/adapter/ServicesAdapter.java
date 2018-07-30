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
import com.binarycase.mohamed.ontime.data.model.OurWork;
import com.binarycase.mohamed.ontime.data.model.Service;
import com.binarycase.mohamed.ontime.utils.AppUtils;
import com.binarycase.mohamed.ontime.utils.CustomTypefaceSpan;

import java.util.List;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.MyViewHolder> {

    private List<Service> prices;
    private Context context;
    //    private IMyAdsClickHandler handler;
    public ServicesAdapter(Context context, List<Service> prices) {
        this.prices = prices;
        this.context=context;
//        handler= (IMyAdsClickHandler) context;
    }

    @Override
    public ServicesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.service_item, parent, false);

        return new ServicesAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ServicesAdapter.MyViewHolder holder, final int position) {
//        final OurWork price = prices.get(position);
//        holder.name.setText(price.getPhoneName());
//        holder.city.setText(price.getPhoneCity());
//        holder.status.setText(price.getPhoneStatus());
//        holder.numberView.setText(price.getNumberView());
//        try {
//            Picasso.with(context).load(price.getPhoneImage()).into(holder.phone_image);
//        }catch (Exception e){
//
//        }
//        Random rnd = new Random();
//        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//        holder.mView.setBackgroundColor(color);
//        holder.overflow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showPopupMenu(holder.overflow,price.getId(),price.getVisible());
//            }
//        });
    }

    @Override
    public int getItemCount() {
        if (prices.size()==0){
            return 0;
        }
        return prices.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, ourWork,price,askNow;
        public ImageView overflow;
        public View mView;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.service_title);
            ourWork = view.findViewById(R.id.our_works_in_this_field);
            price = view.findViewById(R.id.service_price);
            askNow = view.findViewById(R.id.ask_now);
//            numberView = view.findViewById(R.id.num_view);
//            overflow=view.findViewById(R.id.overflow);
//            phone_image=view.findViewById(R.id.phone_bg);
//            mView=view.findViewById(R.id.view);
            AppUtils.applyMediumFont(title,price,askNow);
            AppUtils.applyLightFont(ourWork);
            AppUtils.setHtmlText(R.string.our_work_in_this_field,ourWork);
        }
    }



}
