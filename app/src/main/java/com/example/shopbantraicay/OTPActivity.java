package com.example.shopbantraicay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OTPActivity extends AppCompatActivity {

    private EditText otp1EditText;
    private EditText otp2EditText;
    private EditText otp3EditText;
    private EditText otp4EditText;
    private Button verifyOtpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpactivity);

        // Lấy tham chiếu đến các thành phần trong layout
        otp1EditText = findViewById(R.id.otp1EditText);
        otp2EditText = findViewById(R.id.otp2EditText);
        otp3EditText = findViewById(R.id.otp3EditText);
        otp4EditText = findViewById(R.id.otp4EditText);
        verifyOtpButton = findViewById(R.id.verifyOtpButton);

        verifyOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Thực hiện xử lý xác nhận OTP tại đây
                String otp = getOtpFromEditTexts();
                if (otp.length() == 4) {
                    Toast.makeText(OTPActivity.this, "Xác nhận OTP thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(OTPActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {

                    Toast.makeText(OTPActivity.this, "Vui lòng nhập đủ 4 chữ số OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Đặt sự kiện để chuyển focus giữa các ô nhập OTP khi người dùng nhập liệu
        setupOtpEditTextFocusChangeListeners();
    }

    private void setupOtpEditTextFocusChangeListeners() {
        otp1EditText.addTextChangedListener(new FocusChangeTextWatcher(otp2EditText));
        otp2EditText.addTextChangedListener(new FocusChangeTextWatcher(otp3EditText));
        otp3EditText.addTextChangedListener(new FocusChangeTextWatcher(otp4EditText));
    }

    private String getOtpFromEditTexts() {
        return otp1EditText.getText().toString()
                + otp2EditText.getText().toString()
                + otp3EditText.getText().toString()
                + otp4EditText.getText().toString();
    }

    // Lớp nghe sự kiện thay đổi focus để di chuyển giữa các ô nhập OTP
    private static class FocusChangeTextWatcher implements TextWatcher, View.OnFocusChangeListener {

        private final EditText nextEditText;

        FocusChangeTextWatcher(EditText nextEditText) {
            this.nextEditText = nextEditText;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }

        @Override
        public void onFocusChange(View view, boolean hasFocus) {
            if (hasFocus && nextEditText != null) {
                nextEditText.requestFocus();
            }
        }
    }
}