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

public class LoginActivity extends Activity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        // Recupera username e password salvati in SharedPreferences
        SharedPreferences preferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        String savedUsername = preferences.getString("username", null);
        String savedPassword = preferences.getString("password", null);

        Log.d("LoginActivity", "Saved Username: " + savedUsername);
        Log.d("LoginActivity", "Saved Password: " + savedPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Controllo se le credenziali salvate sono null
                if (savedUsername == null || savedPassword == null) {
                    Toast.makeText(LoginActivity.this, "Errore: dati mancanti. Registrati di nuovo.", Toast.LENGTH_LONG).show();
                    return; // Aggiungi questa riga per evitare un tentativo di login se non ci sono credenziali salvate
                }

                if (username.equals(savedUsername) && password.equals(savedPassword)) {
                    // Se le credenziali sono corrette, vai alla MainActivity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Credenziali non valide", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
