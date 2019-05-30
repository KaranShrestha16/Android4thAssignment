package com.example.android4thassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.android4thassignment.API.UserAPI;
import com.example.android4thassignment.ItemsAdapter.ItemsAdapter;
import com.example.android4thassignment.model.ItemModel;
import com.example.android4thassignment.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayItem extends AppCompatActivity {
    private RecyclerView itemDisplay;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item);
        itemDisplay=findViewById(R.id.itemDisplay);
        btnBack= findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DisplayItem.this,MainActivity.class);
                startActivity(intent);
            }
        });


        itemDisplay.setLayoutManager( new LinearLayoutManager(this));
        UserAPI  userAPI= Url.getInstance().create(UserAPI.class);
        Call<List<ItemModel>> listCall= userAPI.getAllItems();
        listCall.enqueue(new Callback<List<ItemModel>>() {
            @Override
            public void onResponse(Call<List<ItemModel>> call, Response<List<ItemModel>> response) {
                List<ItemModel> itemModels=response.body();
                ItemsAdapter itemsAdapter= new ItemsAdapter(DisplayItem.this,itemModels);
                itemDisplay.setAdapter(itemsAdapter);
                itemDisplay.setLayoutManager(new LinearLayoutManager(DisplayItem.this));
            }

            @Override
            public void onFailure(Call<List<ItemModel>> call, Throwable t) {

            }
        });



    }
}
