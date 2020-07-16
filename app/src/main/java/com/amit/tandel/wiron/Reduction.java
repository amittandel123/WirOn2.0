package com.amit.tandel.wiron;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Reduction extends AppCompatActivity {

    EditText inletDia,outletDia;
    TextView tvRed;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reduction);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        inletDia = (EditText)findViewById(R.id.erInDia);
        outletDia = (EditText)findViewById(R.id.erOutDia);
        tvRed = (TextView)findViewById(R.id.tvReduction);
        button = (Button)findViewById(R.id.bCalcRed);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inletDia.getText().toString().length() == 0) {
                    Toast.makeText(Reduction.this, "Enter inlet Diameter value", Toast.LENGTH_LONG).show();
                } else if (outletDia.getText().toString().length() == 0) {
                    Toast.makeText(Reduction.this, "Enter outlet Diameter value", Toast.LENGTH_LONG).show();
                } else {
                    /* Get entered texts from the edittexts,and convert to integers */
                    Double valueInDia = Double.parseDouble(inletDia.getText().toString());
                    Double valueOutDia = Double.parseDouble(outletDia.getText().toString());
                    /* Calculate Production */
                    Double valueRed = (1-((valueOutDia*valueOutDia)/(valueInDia*valueInDia)))*100;
                    /* Set the value to the textview to display on screen */
                    tvRed.setText(String.format("%.2f", valueRed).toString() + " %");
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
