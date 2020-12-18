package com.example.javaresources;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class HomeFragment extends Fragment {

    private TextView mTimeNow;
    private TextView mDateNow;
    private Button mTimeBtn;
    private Button mDateBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Spinner mSpinner = (Spinner) view.findViewById(R.id.spinner);
        mTimeBtn = view.findViewById(R.id.getTimeBtn);
        mDateBtn = view.findViewById(R.id.getDateBtn);

        mTimeNow = view.findViewById(R.id.timeNowTV);
        mDateNow = view.findViewById(R.id.dateNowTV);

        mTimeBtn.setOnClickListener(v -> {
            withTime();
        });

        mDateBtn.setOnClickListener(v -> {
            withDate();
        });

        String myCol[] = this.getResources().getStringArray(R.array.myColors);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.planets,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_item
        );
        mSpinner.setAdapter(adapter);

        return view;
    }

    private void withDate() {
        Calendar calendar = Calendar.getInstance();
//      Get Year, Month, and Date
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);
//      Date Picker Dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(), (view, year, month, dayOfMonth) -> {
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
        TimePickerDialog timePickerDialog = new TimePickerDialog(requireContext(), (view, hourOfDay, minute) -> {
            String timeString = "Hour-> " + hourOfDay + " Mintue-> " + minute;
            mTimeNow.setText(timeString);
        }, HOUR, MINTUE, true);

        timePickerDialog.show();
    }

}