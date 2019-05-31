package com.example.android4thassignment.ItemsAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android4thassignment.R;
import com.example.android4thassignment.ShowDetails;
import com.example.android4thassignment.Url;
import com.example.android4thassignment.model.ItemModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {

    Context mContext;
    List<ItemModel> itemsList;

    public ItemsAdapter(Context mContext, List<ItemModel> itemsList) {
        this.mContext = mContext;
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_item, viewGroup, false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder itemsViewHolder, int i) {
        final ItemModel item = itemsList.get(i);
        String imgpath = Url.BASE_URL + item.getItemImageName();
        StrictMode();
        try{
            URL url = new URL(imgpath);
            Log.d("pathgKarean",imgpath);
            itemsViewHolder.imageView.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        }catch (IOException e) {
            e.printStackTrace();
        }
        itemsViewHolder.tvName.setText(item.getItemName());
        itemsViewHolder.tvPrice.setText(item.getItemPrice());
        itemsViewHolder.tvDec.setText(item.getItemDescription());


        itemsViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, ShowDetails.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("image",item.getItemImageName());
                intent.putExtra("name",item.getItemName());
                intent.putExtra("price",item.getItemPrice());
                intent.putExtra("description",item.getItemDescription());
                mContext.startActivity(intent);

            }
        });


    }

    private void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imageView;
        TextView tvName,tvPrice,tvDec;
                public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgview);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvDec = itemView.findViewById(R.id.tvDesc);

        }
    }


}
