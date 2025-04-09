package com.example.gitfit;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseActivity extends AppCompatActivity {
    private String countryName[] = {"Piegamento", "Capibara"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(ExerciseActivity.this, android.R.layout.simple_spinner_dropdown_item, countryName);
        autoCompleteTextView.setThreshold(2);
        autoCompleteTextView.setAdapter(adapter);
        Button searchButton = findViewById(R.id.searchButton);
        ImageButton Piegamento = findViewById(R.id.Piegamento);
        ImageButton ChestPress = findViewById(R.id.ChestPress);

        // Add more ImageButton references as needed

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputId = autoCompleteTextView.getText().toString();
                hideAllImageButtons();

                if (inputId.equals("Piegamento")) {
                    Piegamento.setVisibility(View.VISIBLE);
                } else if (inputId.equals("ChestPress")) {
                    ChestPress.setVisibility(View.VISIBLE);
                } else if (inputId.equals("")) {
                    Piegamento.setVisibility(View.VISIBLE);
                    ChestPress.setVisibility(View.VISIBLE);
                }
                // Add more conditions for other ImageButtons
            }

            private void hideAllImageButtons() {
                Piegamento.setVisibility(View.GONE);
                ChestPress.setVisibility(View.GONE);
                // Hide other ImageButtons
            }
        });
    }
}
