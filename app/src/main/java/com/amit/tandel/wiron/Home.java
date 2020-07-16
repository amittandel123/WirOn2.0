package com.amit.tandel.wiron;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.amit.tandel.wir_on.FwdLength;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onButtonClick(View v)
    {
        switch (v.getId())
        {
            case R.id.bLength:
                Intent lengthIntent = new Intent(this,Length.class);
                startActivity(lengthIntent);
                break;
            case R.id.bProduction:
                Intent prodIntent = new Intent(this,Production.class);
                startActivity(prodIntent);
                break;
            case R.id.bTime:
                Intent timeIntent = new Intent(this,Time.class);
                startActivity(timeIntent);
                break;
            case R.id.bCoil:
                Intent coilIntent = new Intent(this,Coil.class);
                startActivity(coilIntent);
                break;
            case R.id.bReduction:
                Intent reductionIntent = new Intent(this,Reduction.class);
                startActivity(reductionIntent);
                break;
            case R.id.bFwdLength:
                Intent fwdLengthIntent = new Intent(this,FwdLength.class);
                startActivity(fwdLengthIntent);
                break;
        }
    }
}
