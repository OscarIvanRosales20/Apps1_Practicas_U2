package com.example.eva2_8_permisos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eva2_8_permisos.R;

public class MainActivity extends AppCompatActivity {

    final static int PERMISO_LLAMAR = 100;
    EditText edtTxtNum;
    Intent intent;
    Button btnLlamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLlamar = (Button)findViewById(R.id.btnLlamar);

        //Aqui Verifico si no tengo el permiso
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            //Solicitar permiso
            Toast.makeText(this, "No Tienes Permisos", Toast.LENGTH_LONG).show();
            btnLlamar.setEnabled(false);
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    PERMISO_LLAMAR);
        }else{
            //Aqui ejecuta alguna acción si la app tiene permiso.
            Toast.makeText(this, "Tienes Permiso", Toast.LENGTH_SHORT).show();
            btnLlamar.setEnabled(true);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        edtTxtNum = (EditText)findViewById(R.id.edTxtNumero);
    }

    public void onClick(View view){
        String sTel = "Tel:" + edtTxtNum.getText().toString();
        intent = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISO_LLAMAR:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    btnLlamar.setEnabled(true);
                    Toast.makeText(this, "Permiso Concedido", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permiso Denegado", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}