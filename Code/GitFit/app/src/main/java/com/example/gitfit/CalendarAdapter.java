package com.example.gitfit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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

    /* public interface OnItemListener {
        void onItemClick(int position, String dayText);
    } */

    // Implemento la logica, inserendo i giorni del mese come stringhe in un arraylist
    public CalendarAdapter(ArrayList<String> giorniDelMese, OnItemListener onItemListener) {
        this.giorniDelMese = giorniDelMese;
        this.onItemListener = onItemListener;
    }

    // Imposto il LayoutInflater
    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_calendar_cell, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight() * 0.1666666666);
        return new CalendarViewHolder(view, onItemListener);
    }


    // Implemento la logica
    @Override
    public void onBindViewHolder(CalendarViewHolder holder, int position) {
        holder.giornoDelMese.setText(giorniDelMese.get(position));
    }

    @Override
    public int getItemCount() {
        return giorniDelMese.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView dayOfMonth;
        private final OnItemListener onItemListener;

        public ViewHolder(View itemView, OnItemListener onItemListener) {
            super(itemView);
            dayOfMonth = itemView.findViewById(R.id.cellDayText);
            this.onItemListener = onItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition(), dayOfMonth.getText().toString());
        }
    }


    // Definisco l'interfaccia pre invocare un callback quando un oggetto in questa view viene selezionato
    public interface OnItemListener {
        void onItemClick(int position, String dayText);
    }
}

