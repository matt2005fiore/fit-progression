package com.example.gitfit;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExercisesListActivity extends AppCompatActivity {
    private String ExerciseName[] = {"Piegamento", "ChestPress"};
    Dialog pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        pop = new Dialog(this);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(ExercisesListActivity.this, android.R.layout.simple_spinner_dropdown_item, ExerciseName);
        autoCompleteTextView.setThreshold(2);
        autoCompleteTextView.setAdapter(adapter);

        Button searchButton = findViewById(R.id.searchButton);
        ImageButton Piegamento = findViewById(R.id.Piegamento);
        ImageButton ChestPress = findViewById(R.id.BicepCurl);

        // Add more ImageButton references as needed
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputId = autoCompleteTextView.getText().toString();
                hideAllImageButtons();

                if (inputId.equals("Piegamento") ||
                        inputId.equalsIgnoreCase("corpo libero") ||
                        inputId.equalsIgnoreCase("Petto")) {
                    Piegamento.setVisibility(View.VISIBLE);
                } else if (inputId.equals("Curl") ||
                        inputId.equalsIgnoreCase("Peso") ||
                        inputId.equalsIgnoreCase("Bicipite")) {
                    ChestPress.setVisibility(View.VISIBLE);
                } else if (inputId.equals("")) {
                    Piegamento.setVisibility(View.VISIBLE);
                    ChestPress.setVisibility(View.VISIBLE);
                }
            }

            private void hideAllImageButtons() {
                Piegamento.setVisibility(View.GONE);
                ChestPress.setVisibility(View.GONE);
                // Hide other ImageButtons
            }
        });
    }

    public void Piegamento(View v) {
        TextView txtclose;
        pop.setContentView(R.layout.popup);
        txtclose = pop.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
        pop.show();
    }

    public void Curl(View v) {
        TextView txtclose;
        pop.setContentView(R.layout.popup);
        txtclose = (TextView) pop.findViewById(R.id.txtclose);

        // Corretto il metodo da onClicker a setOnClickListener
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
        pop.show();
    }
}
