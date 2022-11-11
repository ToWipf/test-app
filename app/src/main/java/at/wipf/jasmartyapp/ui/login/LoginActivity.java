package at.wipf.jasmartyapp.ui.login;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import at.wipf.jasmartyapp.databinding.ActivityLoginBinding;

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
                SharedPreferences sp = getSharedPreferences("jss", MODE_PRIVATE);
                sp.edit()
                        .putString("jsUrl", binding.jsUrl.getText().toString())
                        .putString("cookie1Key", binding.cookie1Key.getText().toString())
                        .putString("cookie1Val", binding.cookie1Val.getText().toString())
                        .putString("cookie2Key", binding.cookie2Key.getText().toString())
                        .putString("cookie2Val", binding.cookie2Val.getText().toString())
                        .commit();
              //  Log.d("MyApp","I am here");
            }
        });
        this.loadSettings();

    }

    @Override
    public void onBackPressed() {
            super.onBackPressed(); // close app
    }

    private void loadSettings() {
            SharedPreferences sp = getSharedPreferences("jss", MODE_PRIVATE);
            binding.jsUrl.setText(sp.getString("jsUrl", null));
            binding.cookie1Key.setText(sp.getString("cookie1Key", null));
            binding.cookie1Val.setText(sp.getString("cookie1Val", null));
            binding.cookie2Key.setText(sp.getString("cookie2Key", null));
            binding.cookie2Val.setText(sp.getString("cookie2Val", null));
    }
}