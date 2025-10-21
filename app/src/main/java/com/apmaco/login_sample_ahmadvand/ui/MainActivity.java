package com.apmaco.login_sample_ahmadvand.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.apmaco.login_sample_ahmadvand.R;
import com.apmaco.login_sample_ahmadvand.view_model.AuthViewModel;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ProgressBar progressBar;
    private TextView resultTextView;

    private AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.buttonLogin);
        progressBar = findViewById(R.id.progressBar);
        resultTextView = findViewById(R.id.textViewResult);

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        authViewModel.getLoginResult().observe(this, result -> {
            progressBar.setVisibility(View.GONE);
            loginButton.setEnabled(true);

            if (result == null || result.isEmpty()) {
                resultTextView.setText("پاسخی دریافت نشد");
            } else if (result.toLowerCase().contains("success")) {
                resultTextView.setText("ورود موفق ✅");
            } else if (result.toLowerCase().contains("خطا")) {
                resultTextView.setText("❌ " + result);
            } else {
                resultTextView.setText("نتیجه: " + result);
            }
        });

        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                resultTextView.setText("⚠️ لطفاً نام کاربری و رمز عبور را وارد کنید");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);
            loginButton.setEnabled(false);
            resultTextView.setText("");

            authViewModel.login(username, password);
        });
    }
}