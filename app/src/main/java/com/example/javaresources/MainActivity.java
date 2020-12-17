package com.example.javaresources;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner mSpinner = (Spinner) findViewById(R.id.spinner);
        TextView mTv = (TextView) findViewById(R.id.textView);

        String myCol[] = this.getResources().getStringArray(R.array.myColors);

        for (int i=0; i<myCol.length; i++){
//            mTv.setText(i);
        }

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
}