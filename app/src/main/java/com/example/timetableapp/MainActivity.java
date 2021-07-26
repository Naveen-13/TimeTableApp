package com.example.timetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timeTableListView;
    public void generateTimeTable(int timeTable){
        ArrayList<String> timeTableContent = new ArrayList<String>();
        for (int i=1;i<=10; i++){
            timeTableContent.add(timeTable + " x " + i + " = " + i * timeTable);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timeTableContent);
        timeTableListView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timeTableSeekBar = (SeekBar) findViewById(R.id.timeTableSeekBar);
         timeTableListView =(ListView) findViewById(R.id.timeTableListView);

        timeTableSeekBar.setMax(20);
        timeTableSeekBar.setProgress(10);

        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timeTable;
                if (progress<min){
                    timeTable = min;
                }
                else {
                    timeTable = progress;
                }
                generateTimeTable(timeTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimeTable(10);


    }
}