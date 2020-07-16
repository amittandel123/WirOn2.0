package com.amit.tandel.wir_on;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.amit.tandel.wiron.R;

public class FwdLength extends AppCompatActivity {

    EditText eDia, eWeight;
    TextView eLength, eCalLength;
    Spinner spinner;
    Button button;
    private static Double mFactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwd_length);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eDia = (EditText) findViewById(R.id.etclDia);
        eWeight = (EditText) findViewById(R.id.etclWeight);
        eLength = (TextView) findViewById(R.id.tvLen);
        eCalLength = (TextView) findViewById(R.id.tvCalLength);
        spinner = (Spinner) findViewById(R.id.machinNumber);
        button = (Button) findViewById(R.id.bCalcLength);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.machine_array));
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getItemAtPosition(position).toString()) {
                    case "Select Machine":
                        mFactor = 0.0;
                        Toast.makeText(getApplicationContext(), "Please select a machine", Toast.LENGTH_LONG).show();
                        break;
                    case "Machine 201":
                        mFactor = 1.0;
                        Toast.makeText(getApplicationContext(), "Machine Factor = " + mFactor, Toast.LENGTH_LONG).show();
                        break;
                    case "Machine 202":
                        mFactor = 0.947910994687348;
                        Toast.makeText(getApplicationContext(), "Machine Factor = " + mFactor, Toast.LENGTH_LONG).show();
                        break;
                    case "Machine 203":
                        mFactor = 1.08807987375197;
                        Toast.makeText(getApplicationContext(), "Machine Factor = " + mFactor, Toast.LENGTH_LONG).show();
                        break;
                    case "Machine 204":
                        mFactor = 1.04423310786198;
                        Toast.makeText(getApplicationContext(), "Machine Factor = " + mFactor, Toast.LENGTH_LONG).show();
                        break;
                    case "Machine 205":
                        mFactor = 0.995693181497607;
                        Toast.makeText(getApplicationContext(), "Machine Factor = " + mFactor, Toast.LENGTH_LONG).show();
                        break;
                    case "Machine 206":
                        mFactor = 0.92035595166794;
                        Toast.makeText(getApplicationContext(), "Machine Factor = " + mFactor, Toast.LENGTH_LONG).show();
                        break;
                    case "Machine 207":
                        mFactor = 1.00322692307692;
                        Toast.makeText(getApplicationContext(), "Machine Factor = " + mFactor, Toast.LENGTH_LONG).show();
                        break;
                    case "Machine 208":
                        mFactor = 0.993952589739142;
                        Toast.makeText(getApplicationContext(), "Machine Factor = " + mFactor, Toast.LENGTH_LONG).show();
                        break;
                    case "Machine 209":
                        mFactor = 0.938413311157197;
                        Toast.makeText(getApplicationContext(), "Machine Factor = " + mFactor, Toast.LENGTH_LONG).show();
                        break;
                    case "Machine 210":
                        mFactor = 1.09426315789474;
                        Toast.makeText(getApplicationContext(), "Machine Factor = " + mFactor, Toast.LENGTH_LONG).show();
                        break;
                    default:
                        mFactor = 0.0;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "Please select a machine", Toast.LENGTH_LONG).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFactor.equals(0.0)) {
                    Toast.makeText(getApplicationContext(), "Please select a machine", Toast.LENGTH_LONG).show();
                } else {
                    if (eDia.getText().toString().length() == 0) {
                        Toast.makeText(FwdLength.this, "Enter Diameter value", Toast.LENGTH_LONG).show();
                    } else if (eWeight.getText().toString().length() == 0) {
                        Toast.makeText(FwdLength.this, "Enter Weight value", Toast.LENGTH_LONG).show();
                    } else {
                    /* Get entered texts from the edittexts,and convert to integers */
                        Double valueDia = Double.parseDouble(eDia.getText().toString());
                        Double valueWeight = Double.parseDouble(eWeight.getText().toString());
                    /* Calculate Length */
                        Log.d("Tag", "mFactor = " + mFactor);
                        Double valueLength = (162 * valueWeight) / (valueDia * valueDia);
                        Double valueCalLength = valueLength/mFactor;
                    /* Set the value to the textview to display on screen */
                        eLength.setText(String.format("%.2f", valueLength) + " m");
                        eCalLength.setText(String.format("%.2f", valueCalLength) + " m");
                    }
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
