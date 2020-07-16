package com.amit.tandel.wiron;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Coil extends AppCompatActivity {
    EditText eDia, eWeight, eSpeed1, eSpeed2, eHandleTime;
    TextView tvCoil;
    Button button;
    double valueSpeed, valueDia, valueWeight, valueHT, valueCoil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coil);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        eDia = (EditText) findViewById(R.id.ecDia);
        eWeight = (EditText) findViewById(R.id.ecWeight);
        eSpeed1 = (EditText) findViewById(R.id.ecSpeed1);
        eSpeed2 = (EditText) findViewById(R.id.ecSpeed2);
        eHandleTime = (EditText) findViewById(R.id.ecHandleTime);
        tvCoil = (TextView) findViewById(R.id.tcCoil);
        button = (Button) findViewById(R.id.bCalcCoil);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eDia.getText().toString().length() == 0) {
                    Toast.makeText(Coil.this, "Enter Diameter value", Toast.LENGTH_LONG).show();
                } else if (eWeight.getText().toString().length() == 0) {
                    Toast.makeText(Coil.this, "Enter Weight value", Toast.LENGTH_LONG).show();
                } else if (eHandleTime.getText().toString().length() == 0) {
                    Toast.makeText(Coil.this, "Enter Handle Time value", Toast.LENGTH_LONG).show();
                } else if (eSpeed1.getText().toString().length() == 0) {
                    if (eSpeed2.getText().toString().length() == 0) {
                        Toast.makeText(Coil.this, "Enter Speed value", Toast.LENGTH_LONG).show();
                    } else {
                        valueSpeed = Double.parseDouble(eSpeed2.getText().toString());
                        valueSpeed = valueSpeed / 60;
                    }
                } else if (eSpeed2.getText().toString().length() == 0) {
                    valueSpeed = Double.parseDouble(eSpeed1.getText().toString());
                } else {
                    Toast.makeText(Coil.this, "Enter only ONE Speed value", Toast.LENGTH_LONG).show();
                }
                    /* Get entered texts from the edittexts,and convert to integers */
                valueDia = Double.parseDouble(eDia.getText().toString());
                valueWeight = Double.parseDouble(eWeight.getText().toString());
                valueHT = Double.parseDouble(eHandleTime.getText().toString());
                    /* Calculate Length */
                valueCoil = 480 / (((2.7 * valueWeight) / (valueDia * valueDia * valueSpeed)) + valueHT);
                    /* Set the value to the textview to display on screen */
                tvCoil.setText(String.format("%.2f", valueCoil).toString() + " coils");
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
