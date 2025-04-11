package com.example.gitfit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

    private final ArrayList<String> giorniDelMese;
    private final OnItemListener onItemListener;

    public interface OnItemListener {
        void onItemClick(int position, String dayText);
    }

    public CalendarAdapter(ArrayList<String> giorniDelMese, OnItemListener onItemListener) {
        this.giorniDelMese = giorniDelMese;
        this.onItemListener = onItemListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_calendar_cell, parent, false);
        return new ViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.dayOfMonth.setText(giorniDelMese.get(position));
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
}
