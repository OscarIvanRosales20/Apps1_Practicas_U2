package com.example.eva2_14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView TxtVwMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TxtVwMostrar = findViewById(R.id.TxtVwMostrar);

        MiClaseAsincrona MiCla = new MiClaseAsincrona();
        MiCla.execute(10, 500);

        //15 --> Banner_AsyncTask
        //16 --> Load_Image_AsyncTask
    }

    class MiClaseAsincrona extends AsyncTask<Integer, String, Void>{

        @Override
        protected void onPreExecute() { //Si puede interatuar con la UI
            super.onPreExecute();
            TxtVwMostrar.append("Iniciando La Tarea Asignada!! \n");
        }

        @Override //No puede interactuar con la UI
        protected Void doInBackground(Integer... integers) { //Equivalente al metodo run() en un Thread
            int Limite = integers[0], time = integers[1];
            for(int i = 0; i < Limite; i++){
                try {
                    Thread.sleep(1000);
                    publishProgress("i = " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {//Si puede interatuar con la UI
            super.onProgressUpdate(values);
            TxtVwMostrar.append(values[0] + "\n");
        }

        @Override
        protected void onPostExecute(Void aVoid) { //Si puede interatuar con la UI
            super.onPostExecute(aVoid);
            TxtVwMostrar.append("Fin De La Tarea Asincrona");
        }
    }
}