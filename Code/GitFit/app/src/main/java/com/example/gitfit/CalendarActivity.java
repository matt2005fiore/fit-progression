package com.example.gitfit;

import android.app.Activity;
import android.content.Intent;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;

public class CalendarActivity extends Activity {
    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_calendar);

        Button goalsButton = (Button) findViewById(R.id.GoalsButton);

        goalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalendarActivity.this, SettingsActivity.class));
            }
        });

    /* Intent per inserire gli esercizi svolti nel calendario
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType("vnd.android.cursor.item/event");
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

// barra dei pulsanti

    private BottomBar mBottomBar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            cBottomBar = BottomBar.bind(this, R.layout.activity_calendar,
                    savedInstanceState);

            cBottomBar.setItems(
                    new BottomBarTab(R.drawable.ic_home, "Home"),
                    new BottomBarTab(R.drawable.ic_scheda, "Scheda"),
                    new BottomBarTab(R.drawable.ic_calendar, "Calendario"),
                    new BottomBarTab(R.drawable.ic_profile, "Profilo")
            );

            cBottomBar.setOnItemSelectedListener(new OnTabSelectedListener() {
                @Override
                public void onItemSelected(final int position) {
                    // l'utente ha selezionato un'altra tab
                }
            });
        }

        @Override
        protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            cBottomBar.onSaveInstanceState(outState);
        }
    } */
    }
}