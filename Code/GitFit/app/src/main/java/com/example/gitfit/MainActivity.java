package com.example.gitfit;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gitfit.R;

public class MainActivity extends AppCompatActivity {

    private String countryName[] = {"Piegamento", "Capibara"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, countryName);
        autoCompleteTextView.setThreshold(2);
        autoCompleteTextView.setAdapter(adapter);
        Button searchButton = findViewById(R.id.searchButton);
        ImageButton Piegamento = findViewById(R.id.Piegamento);
        ImageButton Capibara = findViewById(R.id.Capibara);

        // Add more ImageButton references as needed

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputId = autoCompleteTextView.getText().toString();
                hideAllImageButtons();

                if (inputId.equals("Piegamento")) {
                    Piegamento.setVisibility(View.VISIBLE);
                } else if (inputId.equals("Capibara")) {
                    Capibara.setVisibility(View.VISIBLE);
                } else if (inputId.equals("")) {
                    Piegamento.setVisibility(View.VISIBLE);
                    Capibara.setVisibility(View.VISIBLE);
                }
                // Add more conditions for other ImageButtons
            }

            private void hideAllImageButtons() {
                Piegamento.setVisibility(View.GONE);
                Capibara.setVisibility(View.GONE);
                // Hide other ImageButtons
            }
        });
    }
}