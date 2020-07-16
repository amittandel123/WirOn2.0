package com.amit.tandel.wiron;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Length extends AppCompatActivity {
    EditText eDia, eWeight;
    TextView eLength;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        eDia = (EditText) findViewById(R.id.etDia);
        eWeight = (EditText) findViewById(R.id.etWeight);
        eLength = (TextView) findViewById(R.id.tvLength);
        button = (Button) findViewById(R.id.bCalcLen);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eDia.getText().toString().length() == 0)
                {
                    Toast.makeText(Length.this, "Enter Diameter value", Toast.LENGTH_LONG).show();
                }
                else if (eWeight.getText().toString().length() == 0)
                {
                    Toast.makeText(Length.this, "Enter Weight value", Toast.LENGTH_LONG).show();
                }
                else
                {
                    /* Get entered texts from the edittexts,and convert to integers */
                    Double valueDia = Double.parseDouble(eDia.getText().toString());
                    Double valueWeight = Double.parseDouble(eWeight.getText().toString());
                    /* Calculate Length */
                    Double valueLength = (162 * valueWeight) / (valueDia * valueDia);
                    /* Set the value to the textview to display on screen */
                    eLength.setText(String.format("%.2f", valueLength).toString() + " m");
                }
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
