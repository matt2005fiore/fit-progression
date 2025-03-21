    package com.example.gitfit;

    import android.app.Activity;
    import android.content.Intent;
    import android.content.SharedPreferences;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.Spinner;
    import android.widget.Toast;

    public class FormActivity extends Activity {

        private EditText nameEditText, surnameEditText, weightEditText, ageEditText, usernameEditText, passwordEditText;
        private Spinner goalSpinner;
        private Button submitButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_form);

            // Inizializzazione dei campi
            nameEditText = findViewById(R.id.nameEditText);
            surnameEditText = findViewById(R.id.surnameEditText);
            weightEditText = findViewById(R.id.weightEditText);
            ageEditText = findViewById(R.id.ageEditText);
            usernameEditText = findViewById(R.id.usernameEditText);
            passwordEditText = findViewById(R.id.passwordEditText);
            goalSpinner = findViewById(R.id.goalSpinner);
            submitButton = findViewById(R.id.submitButton);

            // Definizione della lista di obiettivi
            String[] goals = {"Perdere peso", "Mantenere peso", "Aumentare massa muscolare"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, goals);
            goalSpinner.setAdapter(adapter);

            // Gestione del click sul bottone "Submit"
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = nameEditText.getText().toString();
                    String surname = surnameEditText.getText().toString();
                    String weight = weightEditText.getText().toString();
                    String age = ageEditText.getText().toString();
                    String goal = goalSpinner.getSelectedItem().toString();
                    String username = usernameEditText.getText().toString();
                    String password = passwordEditText.getText().toString();

                    if (name.isEmpty() || surname.isEmpty() || weight.isEmpty() || age.isEmpty() || username.isEmpty() || password.isEmpty()) {
                        Toast.makeText(FormActivity.this, "Tutti i campi sono obbligatori", Toast.LENGTH_SHORT).show();
                    } else {
                        // Salvataggio delle informazioni dell'utente nelle SharedPreferences
                        SharedPreferences preferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.putBoolean("isFirstRun", false); // Marca che il primo avvio è stato completato
                        editor.apply(); // Commit in modo asincrono

                        // Log per verificare che il valore venga salvato correttamente
                        String savedUsername = preferences.getString("username", "default");
                        String savedPassword = preferences.getString("password", "default");
                        boolean isFirstRun = preferences.getBoolean("isFirstRun", true);
                        Log.d("FormActivity", "Salvato: " + savedUsername + ", " + savedPassword + ", isFirstRun: " + isFirstRun);

                        Toast.makeText(FormActivity.this, "Profilo salvato!", Toast.LENGTH_SHORT).show();

                        // Passaggio alla LoginActivity (puoi sostituirla con la tua attività di login)
                        Intent intent = new Intent(FormActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    }