package com.example.gitfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder> {

    private final ArrayList<String> giorniDelMese;

    // Inizializzo il onItemListener
    private final OnItemListener onItemListener;

    // Implemento la logica, inserendo i giorni del mese come stringhe in un arraylist
    public CalendarAdapter(ArrayList<String> giorniDelMese, OnItemListener onItemListener) {
        this.giorniDelMese = giorniDelMese;
        this.onItemListener = onItemListener;
    }

    // Imposto il LayoutInflater
    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_calendar_cell, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight() * 0.1666666666);
        return new CalendarViewHolder(view, (OnItemListener) this);
    }


    // Implemento la logica
    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        holder.giornoDelMese.setText(giorniDelMese.get(position));
    }

    @Override
    public int getItemCount() {
        return giorniDelMese.size();
    }

    // Definisco l'interfaccia pre invocare un callback quando un oggetto in questa view viene selezionato
    public interface OnItemListener {
        void onItemClick(int position, String dayText);
    }
}