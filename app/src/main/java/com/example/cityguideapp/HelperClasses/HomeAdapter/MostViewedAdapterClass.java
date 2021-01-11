package com.example.cityguideapp.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguideapp.R;

import java.util.ArrayList;

public class MostViewedAdapterClass extends RecyclerView.Adapter<MostViewedAdapterClass.MostViewHolder> {

    ArrayList<FeaturedHelperClass> featuredCatLocation;

    public MostViewedAdapterClass(ArrayList<FeaturedHelperClass> featuredCatLocation) {
        this.featuredCatLocation = featuredCatLocation;
    }

    @NonNull
    @Override
    public MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design, parent, false);

        return new MostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewHolder holder, int position) {

        FeaturedHelperClass featuredHelperClass = featuredCatLocation.get(position);

        holder.image.setImageResource(featuredHelperClass.getImage());
        holder.title.setText(featuredHelperClass.getTitle());
        holder.descriptions.setText(featuredHelperClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return featuredCatLocation.size();
    }

    public class MostViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, descriptions;
        public MostViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.mv_image);
            title = itemView.findViewById(R.id.mv_title);
            descriptions = itemView.findViewById(R.id.mv_description);
        }
    }
}
