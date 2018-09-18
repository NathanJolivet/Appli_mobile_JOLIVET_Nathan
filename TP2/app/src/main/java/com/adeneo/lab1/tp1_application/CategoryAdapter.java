package com.adeneo.lab1.tp1_application;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter{

    private List<Category> categories;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category, parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Category currentCategory = categories.get(position);
        if(viewHolder instanceof CategoryViewHolder && currentCategory != null){
            CategoryViewHolder viewHolder1 = (CategoryViewHolder) viewHolder;
            viewHolder1.layoutForCategory(currentCategory);
        }
    }

    @Override
    public int getItemCount() {
        if(categories != null){
            return categories.size();
        }
        return 0;
    }


    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
