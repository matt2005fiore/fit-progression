package com.example.gitfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder> {

    private final ArrayList<String> giorniDelMese;
    private final OnItemListener onItemListener;

    public CalendarAdapter(ArrayList<String> giorniDelMese) {
        this.giorniDelMese = giorniDelMese;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_calendar_cell, parent, attachToRoot:false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight() * 0.1666666666);
        return new CalendarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        holder.giornoDelMese.setText(giorniDelMese.get(position));
    }

    @Override
    public int getItemCount() {
        return giorniDelMese.size();
    }

    public interface onItemListener {
        void onItemClick(int position, String dayText);
    }

}