package com.example.gitfit;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapp.api.ApiService;
import com.example.myapp.api.RetrofitClient;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends Activity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        SharedPreferences preferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);

        registerButton.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, FormActivity.class));
            finish();
        });

        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Inserisci username e password", Toast.LENGTH_LONG).show();
                return;
            }

            Retrofit retrofit = RetrofitClient.getClient();
            ApiService api = retrofit.create(ApiService.class);

            User user = new User(username, password);
            Call<ResponseBody> call = api.login(user);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response.body().string());
                            String token = jsonResponse.getString("token");

                            // Store token securely
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("token", token);
                            editor.putBoolean("isLoggedIn", true);
                            editor.apply();

                            Toast.makeText(LoginActivity.this, "Login avvenuto con successo", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(LoginActivity.this, MainPageActivity.class));
                            finish();
                        } catch (Exception e) {
                            Log.e("LoginActivity", "Error parsing JSON response", e);
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Credenziali non valide", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Errore di connessione", Toast.LENGTH_SHORT).show();
                    Log.e("LoginActivity", t.getMessage());
                }
            });
        });
    }

}
