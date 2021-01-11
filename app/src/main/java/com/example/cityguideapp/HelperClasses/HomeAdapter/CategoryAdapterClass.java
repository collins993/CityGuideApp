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

public class CategoryAdapterClass extends RecyclerView.Adapter<CategoryAdapterClass.CategoryViewHolder> {

    ArrayList<CategoryHelperClass> categoryLocation;

    public CategoryAdapterClass(ArrayList<CategoryHelperClass> categoryLocation) {
        this.categoryLocation = categoryLocation;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryHelperClass categoryHelperClass = categoryLocation.get(position);

        holder.catImage.setImageResource(categoryHelperClass.getImage());
        holder.catTitle.setText(categoryHelperClass.getTitle());
    }

    @Override
    public int getItemCount() {
        return categoryLocation.size();
    }


    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        ImageView catImage;
        TextView catTitle;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            catImage = itemView.findViewById(R.id.category_image);
            catTitle = itemView.findViewById(R.id.category_title);
        }
    }
}
