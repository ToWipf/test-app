package com.example.jasmartyapp.ui.login;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import android.text.Editable;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.jasmartyapp.SaveSettings;
import com.example.jasmartyapp.data.model.JsSettings;
import com.example.jasmartyapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Button loginButton = binding.saveSettings;
        final ProgressBar loadingProgressBar = binding.loading;

         loginButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 JsSettings jss = new JsSettings(
                         binding.jsUrl.getText().toString(),
                         binding.cookie1Key.getText().toString(),
                         binding.cookie1Val.getText().toString(),
                         binding.cookie2Key.getText().toString(),
                         binding.cookie2Val.getText().toString()
                 );

                 loadingProgressBar.setVisibility(View.VISIBLE);
                 SaveSettings s = new SaveSettings();
                 s.write(jss.toMyString());
             }
         });
    }
}