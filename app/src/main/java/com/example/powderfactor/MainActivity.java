package com.example.powderfactor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button calculate;

    TextView d_t,ED_t,alpha_t,BH_t,SU_t,ST_t,S_t,rho_t,N_t;
    float d,ED,alpha,BH,SU,ST,S,B,N,L,C,Vc,rho,Mc,Vr,pf_soft_rock,pf_hard_rock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate = (Button)findViewById(R.id.calculate);





        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                d_t= (TextView)findViewById(R.id.hole_diameter);
                d = Float.parseFloat(d_t.getText().toString());
                ED_t = (TextView)findViewById(R.id.explosive_density);
                ED = Float.parseFloat(ED_t.getText().toString());
                alpha_t = (TextView)findViewById(R.id.hole_angle);
                alpha = Float.parseFloat(alpha_t.getText().toString());
                BH_t = (TextView)findViewById(R.id.bh);
                BH = Float.parseFloat(BH_t.getText().toString());
                SU_t = (TextView)findViewById(R.id.subgrade);
                SU = Float.parseFloat(SU_t.getText().toString());
                ST_t = (TextView)findViewById(R.id.stemming);
                ST = Float.parseFloat(ST_t.getText().toString());
                N_t = (TextView)findViewById(R.id.number_of_holes);
                N = Float.parseFloat(N_t.getText().toString());
                rho_t = (TextView)findViewById(R.id.rho);
                rho = Float.parseFloat(rho_t.getText().toString());



                B = (float) (35.0*d);

                S = 14*d/10;

                L = (float) (BH/Math.cos(Math.toRadians(alpha)));



                C = L - ST;

                Vc = (float) ((3.14*d*d/4000)*C);

                Mc = Vc*ED;

                Vr = S*BH*N* rho;

                pf_soft_rock = Mc/Vr;
                B = (float) (25.0*d);

                S = 12*d/10;

                L = (float) (BH/Math.cos(Math.toRadians(alpha)));



                C = L - ST;

                Vc = (float) ((3.14*d*d/4000)*C);

                Mc = Vc*ED;

                Vr = S*BH*N* rho;
                pf_hard_rock = Mc/Vr;

                Intent i = new Intent(MainActivity.this,Results.class);
                i.putExtra("pf_hard_rock",pf_hard_rock);
                i.putExtra("pf_soft_rock",pf_soft_rock);
                startActivity(i);
            }
        });
    }
}
