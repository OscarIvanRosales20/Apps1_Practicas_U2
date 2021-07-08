package com.example.eva2_6_on_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.IntentCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnIniciarSecu;
    Intent intent, intentCont, intentImg, intentMusic;
    final static int RequestCode_Main2 = 1000;
    final static int Codigo_Contactos = 2000;
    final static int Codigo_Imagenes = 3000;
    final static int Codigo_Music = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, MainActivity2.class);
        intentCont = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        intentImg = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intentMusic = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnIniciarSecu = findViewById(R.id.btnIniciarSecu);
        btnIniciarSecu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Datos", "Información enviada desde principal");
                startActivityForResult(intent, RequestCode_Main2);

            }
        });
    }

    public void onClickCont(View view){
        if (view.getId() == R.id.btnCont) {
            startActivityForResult(intentCont, Codigo_Contactos);
        }
        else if (view.getId() == R.id.btnImg){
            startActivityForResult(intentImg, Codigo_Imagenes);
        }
        else if (view.getId() == R.id.btnMusic){
            startActivityForResult(intentMusic, Codigo_Music);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Aqui procesamos La Respuesta De La Actividad
        //1.- Identificar la actividad que devolvio el resultado
        //2.- Identificar si se devolvio un valor o no
        //3.- Leer los Datos (Intent)
        switch (requestCode){
            case RequestCode_Main2:
                if (resultCode == Activity.RESULT_OK){
                //Si me devolvio un valor LEER los datos
                Toast.makeText(this, data.getStringExtra( "Valor"), Toast.LENGTH_SHORT).show();
            }
            break;
                case Codigo_Contactos: //un case para cada actvidad que devuelve un valor
                    if (resultCode == Activity.RESULT_OK){
                        //Si me devolvio un valor LEER los datos
                        String returnedData = data.getDataString();
                        Toast.makeText(this, returnedData, Toast.LENGTH_SHORT).show();
                    }
                    break;

            case Codigo_Imagenes:
                if (resultCode == Activity.RESULT_OK){
                    String returnedData = data.getDataString();
                    Toast.makeText(this, returnedData, Toast.LENGTH_SHORT).show();
                }

            case Codigo_Music: //un case para cada actvidad que devuelve un valor
                if (resultCode == Activity.RESULT_OK){
                    String returnedData = data.getDataString();
                    Toast.makeText(this, returnedData, Toast.LENGTH_LONG).show();
                }
                break;
            default:
        }
    }
}