package com.example.shopbantraicay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DetailProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        Product product = (Product) getIntent().getSerializableExtra("PRODUCT");

        ImageView img = findViewById(R.id.imgProduct);
        if (product != null) {

            Picasso.get().load(product.getImage()).fit().into(img);
        }

    }
}