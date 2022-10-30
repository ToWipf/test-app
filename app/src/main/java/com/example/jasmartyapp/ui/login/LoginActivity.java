package com.example.jasmartyapp.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jasmartyapp.SaveSettings;
import com.example.jasmartyapp.data.model.JsSettings;
import com.example.jasmartyapp.databinding.ActivityLoginBinding;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private SaveSettings settings = new SaveSettings();

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

                //loadingProgressBar.setVisibility(View.VISIBLE);

                settings.write(jss.toJson().toString());
            }
        });
        this.loadSettings();

    }

    private void loadSettings() {
        try {
            JsSettings jsLoad = new JsSettings(new JSONObject(settings.read()));
            binding.jsUrl.setText(jsLoad.getsUrl());
            binding.cookie1Key.setText(jsLoad.getsCo1_key());
            binding.cookie1Val.setText(jsLoad.getsCo1_val());
            binding.cookie2Key.setText(jsLoad.getsCo2_key());
            binding.cookie2Val.setText(jsLoad.getsCo2_val());
        } catch (Exception e) {
            // Keine Config vorhanden
            e.printStackTrace();
        }
    }
}