package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valor;
    private TextView gor, total, porc;
    private SeekBar seek;

    private double progr=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valor= findViewById(R.id.valor);
        total=findViewById(R.id.total);
        porc=findViewById(R.id.porce);
        gor= findViewById(R.id.gorjeta);
        seek=findViewById(R.id.seek);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progr= i;
                porc.setText(Math.round(i)+"%");
                calc();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void  calc(){


        if (valor.getText().toString()==null || valor.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"preencha um valor",Toast.LENGTH_SHORT).show();
        }else{
            double val= Double.parseDouble(valor.getText().toString());
            double gorjeta= val*(progr/100);
            double tot = val+gorjeta;
            gor.setText("R$"+gorjeta);
            total.setText("R$"+tot);


        }
    }
}