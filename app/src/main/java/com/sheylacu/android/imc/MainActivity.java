package com.sheylacu.android.imc;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText campoPeso;
    private EditText campoEstatura;
    private Button BotonCalcular;
    private Button BotonLimpiar;
    private TextView textoImc;
    private String TEXTO_IMC;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXTO_IMC, textoImc.getText().toString());
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campoPeso = (EditText) findViewById(R.id.campo_Peso);
        campoEstatura = (EditText) findViewById(R.id.campo_estatura);
        BotonCalcular = (Button) findViewById(R.id.boton_calcular);
        BotonLimpiar = (Button) findViewById(R.id.boton_limpiar);
        textoImc = (TextView) findViewById(R.id.texto_imc);

        if (savedInstanceState != null) {
            String s = savedInstanceState.getString(TEXTO_IMC);
            textoImc.setText(s);
        }


        BotonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = campoPeso.getText().toString();
                double peso = Double.parseDouble(s);
                s = campoEstatura.getText().toString();
                double estatura = Double.parseDouble(s);
                double imc = peso / (estatura * estatura);
                s = String.format("%2.2f", imc);
                textoImc.setText(s);

            }

        });

        BotonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                campoPeso.setText("");
                campoEstatura.setText("");
                textoImc.setText("0.0");
            }
            });
    }
}