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
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);


        // Recupera username e password salvati in SharedPreferences
        SharedPreferences preferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        String savedUsername = preferences.getString("username", null);
        String savedPassword = preferences.getString("password", null);

        Log.d("LoginActivity", "Saved Username: " + savedUsername);
        Log.d("LoginActivity", "Saved Password: " + savedPassword);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, FormActivity.class);
                startActivity(intent);
                finish();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Fetch updated SharedPreferences here
                SharedPreferences preferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
                String savedUsername = preferences.getString("username", null);
                String savedPassword = preferences.getString("password", null);

                Log.d("LoginActivity", "Entered Username: " + username);
                Log.d("LoginActivity", "Entered Password: " + password);
                Log.d("LoginActivity", "Saved Username: " + savedUsername);
                Log.d("LoginActivity", "Saved Password: " + savedPassword);

                // Check if credentials exist
                if (savedUsername == null || savedPassword == null) {
                    Toast.makeText(LoginActivity.this, "Errore: dati mancanti. Registrati di nuovo.", Toast.LENGTH_LONG).show();
                    return;
                }


                // Validate credentials
                if (username.equals(savedUsername) && password.equals(savedPassword)) {
                    Intent intent = new Intent(LoginActivity.this, MainPageActivity.class);
                    startActivity(intent);
                    // Controlliamo se l'utente ha già completato il Form
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("isFirstRun", false);
                    editor.apply();

                    //finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Credenziali non valide", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

/*    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        // Controlliamo se l'utente ha già completato il Form
        SharedPreferences preferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isFirstRun", true);
        editor.apply();

       finish();
    }
*/
    @Override
    protected void onResume() {
        super.onResume();
        // Controlliamo se l'utente ha già completato il Form
        SharedPreferences preferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        boolean isFirstRun = preferences.getBoolean("isFirstRun", true);

        if (!isFirstRun)/* {
            // Se è la prima apertura, vai a FormActivity
            startActivity(new Intent(this, LoginActivity.class));
        } /*else*/ {
            // Se non è la prima apertura, vai a MainPageActivity
            startActivity(new Intent(this, MainPageActivity.class));
        }

    }

}
