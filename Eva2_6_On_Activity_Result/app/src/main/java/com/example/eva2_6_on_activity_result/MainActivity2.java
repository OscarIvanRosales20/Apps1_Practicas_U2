package com.example.eva2_6_on_activity_result;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button btn2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //setResult();
        //intent = new Intent();
        intent = getIntent();
        Toast.makeText(this, intent.getStringExtra("Datos"), Toast.LENGTH_SHORT).show();
    }

    public void onClick (View view){
        intent.putExtra("Valor", "Hola Mundo");
        setResult(Activity.RESULT_OK, intent);
        //Toast.makeText(this, intent.getStringExtra("Valor"), Toast.LENGTH_SHORT).show();
        finish();
    }
    /*@Override
    protected void onStart() {
        super.onStart();
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getApplicationContext()).set
            }
        });
    }*/

    public void onClickCancel(View view){
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}