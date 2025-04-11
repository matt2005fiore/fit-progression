package com.example.gitfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

public class CalendarActivity extends Activity implements CalendarAdapter.OnItemListener{

    private TextView meseAnnoText;
    private RecyclerView calendarRecyclerView;
    private LocalDate selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar)
        initWidgets();
        selectedDate = LocalDate.now();
        setMonthView();
    }

    private void initWidgets() {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        meseAnnoText = findViewById(R.layout.meseAnno);
    }

    private void setMonthView() {
        meseAnnoText.setText(meseAnnoFromDate(selectedDate));
        ArrayList<String> giorniInUnMese = giorniInUnMeseArray(selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(giorniInUnMese, onItemListener:this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), spanCount:7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter)
    }

    private ArrayList<String> giorniInUnMeseArray(LocalDate date) {
        ArrayList<String> giorniInUnMeseArray = new ArrayList<>();
        AnnoMese annoMese = AnnoMese.from(date);
        int giorniInUnMese = annoMese.lengthOfMonth();

        LocalDate primoDelMese = selectedDate.withDayOfMonth(1);
        int giornoDellaSettimana = primoDelMese.getGiornoDellaSettimana().getValue();

        for(int i = 1; i <= 42; i++) {
            if(i<= giornoDellaSettimana || i > giorniInUnMese + giornoDellaSettimana) {
                giorniInUnMeseArray.add("");
            }
            else {
                giorniInUnMeseArray.add(String.valueOf(i - giornoDellaSettimana));
            }
        }
        return giorniInUnMeseArray;
    }

    private String meseAnnoFromDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }

    public void mesePrecedente(View view) {
        selectedDate = selectedDate.minusMonths(1);
        setMonthView();
    }

    public void meseSuccessivo(View view) {
        selectedDate = selectedDate.plusMonths(1);
        setMonthView();
    }

    @Override
    public void onItemClick(int position, String dayText) {
        if(dayText.equals("")) {
            String message = dayText + " " + meseAnnoFromDate(selectedDate);
            Toast.makeText(context:this, message, Toast.LENGTH_LONG).show();
        }
    }


    /* Codice vecchio
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // Iniazializza CalendarView
        calendarView = findViewById(R.id.calendarView);
        date = findViewById(R.id.date);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int anno, int mese, int giornoDelMese) {
                // Azione esempio: mostrami un toast con la data selezionata
<<<<<<< Updated upstream
                String date = giornoDelMese + "/" + (mese + 1) + "/" + anno;
                date.setText(" " + date + " ");
=======
                String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                Toast.makeText(CalendarActivity.this, date, Toast.LENGTH_SHORT).show();
>>>>>>> Stashed changes
            }
        });
    } */
    
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
    