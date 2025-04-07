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

import com.example.myapp.api.ApiService;
import com.example.myapp.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FormActivity extends Activity {

    private EditText nameEditText, surnameEditText, weightEditText, ageEditText, usernameEditText, passwordEditText, heightEditText;
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
        heightEditText = findViewById(R.id.heightEditText);

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
                String height =heightEditText.getText().toString();


                if (name.isEmpty() || surname.isEmpty() || weight.isEmpty() || age.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(FormActivity.this, "Tutti i campi sono obbligatori", Toast.LENGTH_SHORT).show();
                } else {
                    // Creazione del modello User per inviarlo tramite Retrofit
                    User user = new User();
                    user.setName(name);
                    user.setSurname(surname);
                    user.setWeight(Float.parseFloat(weight));
                    user.setHeight(Float.parseFloat(height));
                   // user.setGender(true);
                    user.seteMail(username);
                    user.setPassword(password);

                    // Retrofit per inviare i dati al backend
                    Retrofit retrofit = RetrofitClient.getClient();
                    ApiService api = retrofit.create(ApiService.class);

                    // Calling createUser method from ApiService
                    Call<User> call = api.createUser(user);
                    call.enqueue(new Callback<User>() {

                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            Log.e("API_RESPONSE", "Code: " + response.code() + ", Body: " + response.errorBody().toString());
                            if (response.isSuccessful()) {
                                // Salvataggio delle informazioni dell'utente nelle SharedPreferences
                                SharedPreferences preferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("username", username);
                                editor.putString("password", password);
                                editor.putBoolean("isFirstRun", false); // Marca che il primo avvio è stato completato
                                editor.apply();

                                Toast.makeText(FormActivity.this, "Profilo salvato con successo!", Toast.LENGTH_SHORT).show();

                                // Passaggio alla LoginActivity
                                Intent intent = new Intent(FormActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(FormActivity.this, "Errore durante la registrazione. Riprova!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(FormActivity.this, "Errore di connessione: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
