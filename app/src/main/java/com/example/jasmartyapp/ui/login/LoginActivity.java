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

        final EditText jsUrl = binding.jsUrl;
        final EditText co1_key = binding.cookie1Key;
        final EditText co1_val = binding.cookie1Val;
        final EditText co2_key = binding.cookie2Key;
        final EditText co2_val = binding.cookie2Val;
        final Button loginButton = binding.saveSettings;
        final ProgressBar loadingProgressBar = binding.loading;

        JsSettings jss = new JsSettings(jsUrl.toString(), co1_key.toString(), co1_val.toString(), co2_key.toString(), co2_val.toString());

        Editable aa = jsUrl.getText();

         loginButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 loadingProgressBar.setVisibility(View.VISIBLE);
                 //TODO hier jss speichern
                 SaveSettings s = new SaveSettings();

                 s.write(jss.toMyString() + "_AAA\nAAA_" + binding.jsUrl.toString() + "_AAA\nAAA_" + binding.jsUrl + "_AAA\nAAA_" + aa + "_AAA\nAAA_" + aa.toString());

             }
         });
    }
}