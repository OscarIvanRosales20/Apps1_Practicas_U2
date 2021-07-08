package com.example.eva2_13_looper_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView TxtVwMostrar;

    Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            TxtVwMostrar.append((String)msg.obj + "\n");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TxtVwMostrar = findViewById(R.id.TxtVwMostrar);

        BackGround backGround = new BackGround();
        backGround.ejecutarTarea(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++){
                    try {
                        Thread.sleep(1000);
                        Message message = handler.obtainMessage(100, "i = " + i);
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Message message = handler.obtainMessage(100, "Fin del Hilo A");
                handler.sendMessage(message);
            }
        }).ejecutarTarea(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = handler.obtainMessage(100, "Fin del Hilo B");
                handler.sendMessage(message);
            }
        });
    }

    class BackGround extends HandlerThread{

        Handler handler;

        public BackGround(){
            super("Background");
            start();
            handler = new Handler(getLooper());
        }

        public BackGround ejecutarTarea(Runnable tarea){
            handler.post(tarea);
            return this;
        }
    }
}