package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private TextView minValueTextView;
    private TextView maxValueTextView;

    private TextView textViewHistory;
    private Button randbtn;
    private SeekBar min;
    private SeekBar max;
    int min_numb;
    int max_numb;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        resultTextView = findViewById(R.id.resultTextView);
        randbtn = findViewById(R.id.randbtn);
        min = findViewById(R.id.max);
        max = findViewById(R.id.min);
        textViewHistory = findViewById(R.id.textViewHistory);
        minValueTextView = findViewById(R.id.minValueTextView);
        maxValueTextView = findViewById(R.id.maxValueTextView);
        minValueTextView.setText(String.valueOf(min.getProgress()));
        maxValueTextView.setText(String.valueOf(max.getProgress()));

        min.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                minValueTextView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        max.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                maxValueTextView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        randbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min_numb =  min.getProgress();
                max_numb =  max.getProgress();
                int random_int = (int)Math.floor(Math.random() * (max_numb - min_numb + 1) + min_numb);
                resultTextView.setText(String.valueOf(random_int));
                textViewHistory.append(String.valueOf(random_int) + "\n");

            }
        });
    }
}