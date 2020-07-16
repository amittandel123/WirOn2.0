package com.amit.tandel.wiron;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Production extends AppCompatActivity {
    EditText eDia, eSpeedSec, eSpeedMin;
    TextView tvProd;
    Button button;
    double valueDia, valueSpeed, valueProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        eDia = (EditText) findViewById(R.id.epDia);
        eSpeedSec = (EditText) findViewById(R.id.epSpeedSec);
        eSpeedMin = (EditText) findViewById(R.id.epSpeedMin);
        tvProd = (TextView) findViewById(R.id.tvProduction);
        button = (Button) findViewById(R.id.bCalcProd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eDia.getText().toString().length() == 0) {
                    Toast.makeText(Production.this, "Enter Diameter value", Toast.LENGTH_LONG).show();
                } else if (eSpeedSec.getText().toString().length() == 0) {
                    if (eSpeedMin.getText().toString().length() == 0) {
                        Toast.makeText(Production.this, "Enter Speed value", Toast.LENGTH_LONG).show();
                    } else {
                        valueSpeed = Double.parseDouble(eSpeedMin.getText().toString());
                        valueSpeed = valueSpeed / 60;
                    }
                } else if (eSpeedMin.getText().toString().length() == 0) {
                    valueSpeed = Double.parseDouble(eSpeedSec.getText().toString());
                } else {
                    Toast.makeText(Production.this, "Enter only ONE Speed value", Toast.LENGTH_LONG).show();
                }
                    /* Get entered texts from the edittexts,and convert to integers */
                valueDia = Double.parseDouble(eDia.getText().toString());
                    /* Calculate Production */
                valueProd = (0.1777 * valueDia * valueDia * valueSpeed);
                    /* Set the value to the textview to display on screen */
                tvProd.setText(String.format("%.2f", valueProd).toString() + " MT");
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}