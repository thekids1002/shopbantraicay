package com.example.shopbantraicay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopbantraicay.models.Product;
import com.squareup.picasso.Picasso;

public class DetailProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        Product product = (Product) getIntent().getSerializableExtra("PRODUCT");
        TextView tvProductName, tvProductPrice,tvProductDescription,textViewProductQuantity;
        Button btnThemGioHang,btnMua;
        ImageView img = findViewById(R.id.imgProduct);
        if (product != null) {
            tvProductName = findViewById(R.id.tvProductName);
            tvProductPrice = findViewById(R.id.tvProductPrice);
            tvProductDescription = findViewById(R.id.tvProductDescription);
            textViewProductQuantity = findViewById(R.id.textViewProductQuantity);
            btnThemGioHang = findViewById(R.id.btnThemGioHang);
            btnMua = findViewById(R.id.btnMua);

            Picasso.get().load(product.getImage()).fit().into(img);
            tvProductPrice.setText(product.getPrice() + "");
            tvProductDescription.setText(product.getDescription());
            btnThemGioHang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(DetailProduct.this, "Thêm giỏ hàng thành công", Toast.LENGTH_SHORT).show();
                }
            });
            btnMua.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(DetailProduct.this, "Mua thành công", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}