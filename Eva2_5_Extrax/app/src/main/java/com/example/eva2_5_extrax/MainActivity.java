package com.example.eva2_5_extrax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText edtTxtNom, edtTxtSal;
    CheckBox chkBxInfo;
    RadioGroup rdGrpEstado;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, MainActivity2.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        edtTxtNom = findViewById(R.id.edtTxtNom);
        edtTxtSal = findViewById(R.id.edtTxtSal);
        chkBxInfo = findViewById(R.id.chkBxInfo);
        rdGrpEstado = findViewById(R.id.rdGrpEstado);
    }

    public void onClick(View view){
        intent.putExtra("Nombre", edtTxtNom.getText().toString());
        Double dSalario = 0.0;
        dSalario = Double.parseDouble(edtTxtSal.getText().toString());
        intent.putExtra("Salario", dSalario);
        intent.putExtra("Info", chkBxInfo.isChecked());
        intent.putExtra("Estado_Civil", rdGrpEstado.getCheckedRadioButtonId());
        startActivity(intent);
    }
}