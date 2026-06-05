package com.saeidaria.mobile.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEt, passwordEt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        usernameEt = findViewById(R.id.username_et);
        passwordEt = findViewById(R.id.password_et);
        loginBtn = findViewById(R.id.login_btn);
        
        loginBtn.setOnClickListener(v -> login());
    }

    private void login() {
        String username = usernameEt.getText().toString().trim();
        String password = passwordEt.getText().toString().trim();
        
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "لطفا تمام فیلد‌ها را پر کنید", Toast.LENGTH_SHORT).show();
            return;
        }
        
        Toast.makeText(this, "ورود موفق", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}
