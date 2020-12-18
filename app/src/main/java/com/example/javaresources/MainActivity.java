package com.example.javaresources;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView mTimeNow;
    private TextView mDateNow;
    private Button mTimeBtn;
    private Button mDateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner mSpinner = (Spinner) findViewById(R.id.spinner);
        mTimeBtn = findViewById(R.id.getTimeBtn);
        mDateBtn = findViewById(R.id.getDateBtn);

        mTimeNow = findViewById(R.id.timeNowTV);
        mDateNow = findViewById(R.id.dateNowTV);

        mTimeBtn.setOnClickListener(v -> {
            withTime();
        });

        mDateBtn.setOnClickListener(v -> {
            withDate();
        });

        String myCol[] = this.getResources().getStringArray(R.array.myColors);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.planets,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_item
        );
        mSpinner.setAdapter(adapter);
    }

    private void withDate() {
        Calendar calendar = Calendar.getInstance();
//      Get Year, Month, and Date
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);
//      Date Picker Dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            String dateString = year + " " + month + "" + dayOfMonth;
            mDateNow.setText(dateString);
        }, YEAR, MONTH, DATE);

        datePickerDialog.show();
    }

    private void withTime() {
        Calendar calendar = Calendar.getInstance();
//       Get Hour and Mintue
        int HOUR = calendar.get(Calendar.HOUR);
        int MINTUE = calendar.get(Calendar.MINUTE);
//      Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view, hourOfDay, minute) -> {
            String timeString = "Hour-> " + hourOfDay + " Mintue-> " + minute;
            mTimeNow.setText(timeString);
        }, HOUR, MINTUE, true);

        timePickerDialog.show();
    }
}
