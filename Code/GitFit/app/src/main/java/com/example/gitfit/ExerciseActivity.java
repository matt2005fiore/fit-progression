package com.example.gitfit;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ExerciseActivity extends Activity {

    Dialog pop;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        pop = new Dialog(this);
    }
    public void Piegamento(View v) {
        TextView txtclose;
        pop.setContentView(R.layout.popup);
        txtclose = pop.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
        pop.show();
    }
    public void Curl(View v) {
        TextView txtclose;
        pop.setContentView(R.layout.popup);
        txtclose = (TextView) pop.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
        pop.show();

    }


}