package com.example.ejercicio12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombres, apellidos, edad, correo;
    Button btnenviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres = (EditText) findViewById(R.id.txtNombre);
        apellidos = (EditText) findViewById(R.id.txtApellidos);
        edad = (EditText) findViewById(R.id.txtEdad);
        correo = (EditText) findViewById(R.id.txtCorreo);
        btnenviar = (Button) findViewById(R.id.btnEnviar);


        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validar() != true ){
                    Intent intent = new Intent(getApplicationContext(), ActivityVerInformacion.class);
                    intent.putExtra("nombre", nombres.getText().toString());
                    intent.putExtra("apellido", apellidos.getText().toString());
                    intent.putExtra("edad", edad.getText().toString());
                    intent.putExtra("correo", correo.getText().toString());
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(),"Debe rellenar todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    private boolean validar(){
        boolean v = false;
        if(nombres.getText().toString().isEmpty()||apellidos.getText().toString().isEmpty()||
                edad.getText().toString().isEmpty()||correo.getText().toString().isEmpty()){
            v = true;
        }
        return v;
    }

}