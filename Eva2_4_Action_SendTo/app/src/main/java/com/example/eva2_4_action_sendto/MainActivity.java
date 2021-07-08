package com.example.eva2_4_action_sendto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtTel, edtMen;
    Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTel = findViewById(R.id.edtTele);
        edtMen = findViewById(R.id.edtMensaje);
        btnEnviar = findViewById(R.id.btnEnviar);
    }

    public void onClick(View view) {
        String sTel, sMensaje;

        sTel = "smsto:" + edtTel.getText().toString();
        sMensaje = edtMen.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(sTel));
        intent.putExtra("sms_body", sMensaje);
        startActivity(intent);
    }
}