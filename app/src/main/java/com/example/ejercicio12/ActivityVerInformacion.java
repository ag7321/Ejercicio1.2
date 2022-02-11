package com.example.ejercicio12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityVerInformacion extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_informacion);

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);

        String nombre = getIntent().getStringExtra("nombre");
        String apellido = getIntent().getStringExtra("apellido");
        String edad = getIntent().getStringExtra("edad");
        String correo = getIntent().getStringExtra("correo");

        tv1.setText("Nombre: "+nombre);
        tv2.setText("Apellidos: "+apellido);
        tv3.setText("Edad: "+edad);
        tv4.setText("Correo: "+correo);

    }
}