package com.adeneo.lab1.tp1_application;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    private Button categoryName;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        this.categoryName = itemView.findViewById(R.id.categoryName);
    }

    public void layoutForCategory(Category category){
        if(category != null){
            categoryName.setText(category.getName());
        }
    }
}
