package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodapp.Adapter.CategoryAdapter;
import com.example.foodapp.Adapter.PopularAdapter;
import com.example.foodapp.Domain.CategoryDomain;
import com.example.foodapp.Domain.FoodDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter,adapter2;
private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList=findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);
        ArrayList<FoodDomain> foodList=new ArrayList<>();
        foodList.add(new FoodDomain("Pepperonni Pizza","@pizza2","",12.0,0));
        foodList.add(new FoodDomain("Sushi","@pizza2","",10.0,0));
        foodList.add(new FoodDomain("Tacos","@pizza2","",8.0,0));
        foodList.add(new FoodDomain("Drink","@pizza2","",2.0,0));
        foodList.add(new FoodDomain("Fries","@pizza2","",3.0,0));

        adapter2=new PopularAdapter(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList=new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza","@cat_1"));
        categoryList.add(new CategoryDomain("Sushi","cat_2"));
        categoryList.add(new CategoryDomain("Tacos","cat_3"));
        categoryList.add(new CategoryDomain("Drink","cat_4"));
        categoryList.add(new CategoryDomain("Fries","cat_5"));

        adapter=new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);

    }
}