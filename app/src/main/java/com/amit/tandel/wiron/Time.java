package com.amit.tandel.wiron;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Time extends AppCompatActivity {
    EditText eDia, eWeight, eSpeedSec, eSpeedMin;
    TextView tvtTime;
    Button button;
    double valueDia, valueWeight, valueTime, valueSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        eDia = (EditText) findViewById(R.id.ettDia);
        eWeight = (EditText) findViewById(R.id.ettWeight);
        eSpeedSec = (EditText) findViewById(R.id.ettSpeedSec);
        eSpeedMin = (EditText) findViewById(R.id.ettSpeedMin);
        tvtTime = (TextView) findViewById(R.id.tvTime);
        button = (Button) findViewById(R.id.bCalcTime);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eDia.getText().toString().length() == 0) {
                    Toast.makeText(Time.this, "Enter Diameter value", Toast.LENGTH_LONG).show();
                } else if (eWeight.getText().toString().length() == 0) {
                    Toast.makeText(Time.this, "Enter Weight value", Toast.LENGTH_LONG).show();
                } else if (eSpeedSec.getText().toString().length() == 0) {
                    if (eSpeedMin.getText().toString().length() == 0) {
                        Toast.makeText(Time.this, "Enter Speed value", Toast.LENGTH_LONG).show();
                    } else {
                        valueSpeed = Double.parseDouble(eSpeedMin.getText().toString());
                        valueSpeed = valueSpeed / 60;
                    }
                } else if (eSpeedMin.getText().toString().length() == 0) {
                    valueSpeed = Double.parseDouble(eSpeedSec.getText().toString());
                } else {
                    Toast.makeText(Time.this, "Enter only ONE Speed value", Toast.LENGTH_LONG).show();
                }
                    /* Get entered texts from the edittexts,and convert to integers */
                valueDia = Double.parseDouble(eDia.getText().toString());
                valueWeight = Double.parseDouble(eWeight.getText().toString());
                    /* Calculate Length */
                valueTime = (2.7 * valueWeight) / (valueDia * valueDia * valueSpeed);
                    /* Set the value to the textview to display on screen */
                tvtTime.setText(String.format("%.2f", valueTime).toString() + " Min");
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}