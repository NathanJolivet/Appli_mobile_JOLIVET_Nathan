package com.adeneo.lab1.tp1_application.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.adeneo.lab1.tp1_application.manager.MovieManager;
import com.adeneo.lab1.tp1_application.objects.Category;
import com.adeneo.lab1.tp1_application.adapters.CategoryAdapter;
import com.adeneo.lab1.tp1_application.R;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView categories_recyclerView;

    private ImageView btn_close;
    private LinearLayout btn_back;
    private Button categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        btn_close = findViewById(R.id.btn_close);
        btn_close.setOnClickListener(this);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
/*
        categoryName = findViewById(R.id.categoryName);
        categoryName.setOnClickListener(this);
*/
        this.categories_recyclerView = findViewById(R.id.categories_recyclerView);

        List<Category> categories = new ArrayList<>();

        categories = MovieManager.getInstance().getCategories();

        CategoryAdapter categoryAdapter = new CategoryAdapter();
        categoryAdapter.setCategories(categories);

        this.categories_recyclerView.setAdapter(categoryAdapter);
        this.categories_recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    @Override
    public void onClick(View v) {
        if (v.equals(btn_close) || v.equals(btn_back)) {
            CategoriesActivity.this.finish();
        }
/*
        if (v.equals(categoryName)) {
            Intent intent = new Intent(CategoriesActivity.this, CellsActivity.class);
            startActivity(intent);
        }
*/
    }
}
