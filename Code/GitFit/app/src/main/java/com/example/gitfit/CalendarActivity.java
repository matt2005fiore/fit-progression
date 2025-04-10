package com.example.gitfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

public class CalendarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // Initialize CalendarView
        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // Azione esempio: mostrami un toast con la data selezionata
                String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                Toast.makeText(CalendarActivity.this, "Selected date: " + date, Toast.LENGTH_SHORT).show();
            }
        });
    }
    
        public void onAddExerciseClick(View view) {
        // Intent per aggiungere un esercizio al calendario
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setData(CalendarContract.Events.CONTENT_URI);
        intent.putExtra(CalendarContract.Events.TITLE, "Esercizio x");
        intent.putExtra(CalendarContract.Events.DESCRIPTION, "Dieci ripetizioni da dodici");

        // Impostare data e ora
        GregorianCalendar calDate = new GregorianCalendar(2025, 01, 01);
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, calDate.getTimeInMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, calDate.getTimeInMillis());

        // Oppure farla apparire come attività svolta quel giorno come intero
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

        // Renderlo privato
        intent.putExtra(CalendarContract.Events.ACCESS_LEVEL, CalendarContract.Events.ACCESS_PRIVATE);

        startActivity(intent);
    }
}
    