/*package com.example.gitfit;

import java.time.LocalDate;
import java.time.YearMonth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
<<<<<<< HEAD
=======
import android.widget.Toast;
>>>>>>> 5eea5bb1b6087fa6de338c4f2e984dc4d19b0314
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class CalendarActivity extends Activity implements CalendarAdapter.OnItemListener {

    private TextView meseAnnoText;
    private RecyclerView calendarRecyclerView;
    private LocalDate selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initWidgets();
        selectedDate = LocalDate.now();
        setMonthView();
    }

    private void initWidgets() {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        meseAnnoText = findViewById(R.id.meseAnno);
    }

    private void setMonthView() {
        meseAnnoText.setText(meseAnnoFromDate(selectedDate));
        ArrayList<String> giorniInUnMese = giorniInUnMeseArray(selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(giorniInUnMese, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }

    private ArrayList<String> giorniInUnMeseArray(LocalDate date) {
        ArrayList<String> giorniInUnMeseArray = new ArrayList<>();
        YearMonth annoMese = YearMonth.from(date);
        int giorniInUnMese = annoMese.lengthOfMonth();

        LocalDate primoDelMese = date.withDayOfMonth(1);
        int giornoDellaSettimana = primoDelMese.getDayOfWeek().getValue(); // 1 = Lunedì, ..., 7 = Domenica

        for (int i = 1; i <= 42; i++) {
            if (i <= giornoDellaSettimana || i > giorniInUnMese + giornoDellaSettimana) {
                giorniInUnMeseArray.add("");
            } else {
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
        if (!dayText.equals("")) {
            String message = dayText + " " + meseAnnoFromDate(selectedDate);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

    public void onAddExerciseClick(View view) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setData(CalendarContract.Events.CONTENT_URI);
        intent.putExtra(CalendarContract.Events.TITLE, "Esercizio x");
        intent.putExtra(CalendarContract.Events.DESCRIPTION, "Dieci ripetizioni da dodici");

        GregorianCalendar calDate = new GregorianCalendar(2025, 0, 1); // Gennaio è 0
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, calDate.getTimeInMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, calDate.getTimeInMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
        intent.putExtra(CalendarContract.Events.ACCESS_LEVEL, CalendarContract.Events.ACCESS_PRIVATE);

        startActivity(intent);
    }
}
*/