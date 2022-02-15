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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                if(validar() != false ){

                    Toast.makeText(getApplicationContext(),"Debe rellenar todos los campos", Toast.LENGTH_LONG).show();
                }else if(correoval(correo.getText().toString())!=true){
                    Toast.makeText(getApplicationContext(),"Debe ingresar un correo valido", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(getApplicationContext(), ActivityVerInformacion.class);
                    intent.putExtra("nombre", nombres.getText().toString());
                    intent.putExtra("apellido", apellidos.getText().toString());
                    intent.putExtra("edad", edad.getText().toString());
                    intent.putExtra("correo", correo.getText().toString());
                    startActivity(intent);
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

    public boolean correoval(String email){
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean soloTexto(String texto){
       Pattern pattern = Pattern.compile("[a-zA-Z]") ;

        Matcher mather = pattern.matcher(texto);

        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    }

}