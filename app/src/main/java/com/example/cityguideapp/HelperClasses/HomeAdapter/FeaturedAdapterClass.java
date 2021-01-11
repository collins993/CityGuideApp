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

public class FeaturedAdapterClass extends RecyclerView.Adapter<FeaturedAdapterClass.FeaturedViewHolder> {

    ArrayList<FeaturedHelperClass> featuredLocation;

    public FeaturedAdapterClass(ArrayList<FeaturedHelperClass> featuredLocation) {
        this.featuredLocation = featuredLocation;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design, parent, false);
        return new FeaturedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        FeaturedHelperClass featuredHelperClass = featuredLocation.get(position);

        holder.imageView.setImageResource(featuredHelperClass.getImage());
        holder.txtTitle.setText(featuredHelperClass.getTitle());
        holder.txtDescriptions.setText(featuredHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return featuredLocation.size();
    }

    public class FeaturedViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtTitle, txtDescriptions;
        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.featured_image);
            txtTitle = itemView.findViewById(R.id.featured_title);
            txtDescriptions = itemView.findViewById(R.id.featured_desc);
        }
    }
}
