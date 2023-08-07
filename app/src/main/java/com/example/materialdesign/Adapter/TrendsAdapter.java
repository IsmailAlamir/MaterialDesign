package com.example.materialdesign.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.materialdesign.Domains.TrendsDomain;
import com.example.materialdesign.R;

import java.util.ArrayList;

public class TrendsAdapter extends RecyclerView.Adapter<TrendsAdapter.ViewHolder> {
    ArrayList <TrendsDomain> items;
    Context context;

    public TrendsAdapter(ArrayList<TrendsDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public TrendsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflater= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_trend_list,parent,false);
        context= parent.getContext();
        return new ViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendsAdapter.ViewHolder holder, int position) {
    holder.title.setText(items.get(position).getTitle());
    holder.subtitle.setText(items.get(position).getSubtitle());

    int drawableResourceId= holder.itemView.getResources().getIdentifier(items.get(position).getPicAddress(),"drawable",holder.itemView.getContext().getPackageName());

    Glide
        .with(holder.itemView.getContext()) //Fragment
        .load(drawableResourceId) //url
        .transform(new GranularRoundedCorners(30,30,0,0))
        .into(holder.pic); //myImageView


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,subtitle;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.titleTxt);
            subtitle= itemView.findViewById(R.id.subtitleTxt);
            subtitle= itemView.findViewById(R.id.pic);

        }
    }
}
