package com.example.powderfactor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    float pf_soft_rock,pf_hard_rock;

    TextView hard_rock,soft_rock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        pf_hard_rock = getIntent().getFloatExtra("pf_hard_rock",0);
        pf_soft_rock = getIntent().getFloatExtra("pf_soft_rock",0);

        hard_rock = findViewById(R.id.pf_hard_rock);
        soft_rock = findViewById(R.id.pf_soft_rock);


        hard_rock.setText("Powder Factor (PF) = Mc/Vr = " + pf_hard_rock+ "   kg/m^3");
        soft_rock.setText("Powder Factor (PF) = Mc/Vr = " + pf_soft_rock+"   kg/m^3");


    }
}
