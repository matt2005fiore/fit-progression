package com.example.gitfit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Controlliamo se l'utente ha già completato il Form
        SharedPreferences preferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        boolean isFirstRun = preferences.getBoolean("isFirstRun", true);

        if (isFirstRun) {
            // Se è la prima apertura, vai a FormActivity
            startActivity(new Intent(this, FormActivity.class));
        } else {
            // Se non è la prima apertura, vai a MainPageActivity
            startActivity(new Intent(this, MainPageActivity.class));
        }

        // Chiudiamo questa activity
        finish();
    }
}
