package com.example.eva2_5_extrax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Intent intent; mn

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Devuelve el intento que lo creo
        intent = getIntent();
        String dNom = intent.getStringExtra("Nombre");
        Double dSal = intent.getDoubleExtra("Salario", 0.0);
        boolean bInfo = intent.getBooleanExtra("Info", false);
        int iEstado = intent.getIntExtra("Estado_Civil", 0);

        TextView txtVwDatos;
        txtVwDatos = findViewById(R.id.txtVwDatos);
        txtVwDatos.append("Nombre: \n" );
        txtVwDatos.append(dNom + "\n" );
        txtVwDatos.append("Salario: \n" );
        txtVwDatos.append(dSal + "\n" );
        txtVwDatos.append("Información \n" );
        if (bInfo)
            txtVwDatos.append("Con Información " );
        else
            txtVwDatos.append("Sin Información " );

        //RadioButton rdTemp = findViewById(iEstado);
        txtVwDatos.append("Estado Civil: \n" );
        txtVwDatos.append(iEstado + "\n" );
    }

    public void onClickSal(View view){
        finish();
    }
}