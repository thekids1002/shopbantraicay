package com.example.shopbantraicay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText fullNameEditText;
    private EditText addressEditText;
    private EditText phoneEditText;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Lấy tham chiếu đến các thành phần trong layout
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        fullNameEditText = findViewById(R.id.fullNameEditText);
        addressEditText = findViewById(R.id.addressEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        signUpButton = findViewById(R.id.signUpButton);

        // Đặt sự kiện cho nút Đăng ký
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Thực hiện xử lý đăng ký tài khoản tại đây
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String fullName = fullNameEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String phone = phoneEditText.getText().toString();

                // Ví dụ đơn giản: Kiểm tra các trường thông tin không rỗng
                if (!TextUtils.isEmpty(username)
                        && !TextUtils.isEmpty(password)
                        && !TextUtils.isEmpty(fullName)
                        && !TextUtils.isEmpty(address)
                        && !TextUtils.isEmpty(phone)) {
                    // Thực hiện đăng ký thành công, có thể thêm logic xử lý tài khoản mới vào đây
                    Intent intent = new Intent(SignUpActivity.this, OTPActivity.class);
                    startActivity(intent);
                    finish(); // Kết thúc SignUpActivity và quay lại màn hình trước đó (đăng nhập)
                } else {
                    // Hiển thị thông báo nếu một hoặc nhiều trường thông tin rỗng
                    Toast.makeText(SignUpActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Phương thức xử lý khi click vào "Đã có tài khoản? Đăng nhập ngay"
    public void onLoginLinkClicked(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish(); // Kết thúc SignUpActivity khi chuyển sang màn hình đăng nhập
    }
}