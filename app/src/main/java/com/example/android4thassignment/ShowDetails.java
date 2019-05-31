package com.example.android4thassignment;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

public class ShowDetails extends AppCompatActivity {
    TextView name, description, price;
    CircleImageView circleImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        name = findViewById(R.id.detailName);
        description = findViewById(R.id.detailDescription);
        price = findViewById(R.id.detailPrice);
        circleImageView = findViewById(R.id.detailImgView);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {

            String imgpath = Url.BASE_URL + bundle.getString("image");
            URL url = null;
            try {
                url = new URL(imgpath);
                circleImageView.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            name.setText(bundle.getString("name"));
            price.setText(bundle.getString("price"));
            description.setText(bundle.getString("description"));
        }
    }
}
