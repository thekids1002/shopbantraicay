package com.example.shopbantraicay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);


        TextView shopNameTextView = findViewById(R.id.shopNameTextView);
        TextView loadingTextView = findViewById(R.id.loadingTextView);
        ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);


        shopNameTextView.setText("Tên Shop XYZ");
        loadingTextView.setText("Đang tải dữ liệu...");


        loadingProgressBar.setVisibility(View.VISIBLE);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Kết thúc hiển thị loadingProgressBar
                //loadingProgressBar.setVisibility(View.GONE);
                // Chuyển đến màn hình chính hoặc màn hình tiếp theo
                Intent intent = new Intent(LoadingActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000); // Giả sử dữ liệu sẽ tải trong 3 giây
    }
}