package com.example.shopbantraicay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Lấy tham chiếu đến các thành phần trong layout
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        // Đặt sự kiện cho nút Đăng nhập
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Thực hiện xử lý đăng nhập tại đây
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Kiểm tra đăng nhập, ví dụ: (Đây chỉ là ví dụ đơn giản)
                if (username.equals("admin") && password.equals("admin")) {
                    // Đăng nhập thành công, có thể chuyển đến màn hình chính
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Đăng nhập thất bại, hiển thị thông báo
                    Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Lấy tham chiếu đến TextView
        TextView signUpTextView = findViewById(R.id.signUpTextView);

        // Đặt sự kiện click cho TextView
        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Chuyển đến màn hình đăng ký khi click vào "Chưa có tài khoản đăng ký"
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });



    }

    // Function to check and request permission
    public void checkPermission(String permission, int requestCode)
    {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(LoginActivity.this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(LoginActivity.this, new String[] { permission }, requestCode);
        }
        else {
            Toast.makeText(LoginActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }


}