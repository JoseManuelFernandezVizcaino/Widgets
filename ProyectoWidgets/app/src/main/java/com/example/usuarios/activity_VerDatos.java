package com.example.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class activity_VerDatos extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textViewValoracion;

    Datos datos;

    private TextView textAficiones;
    private TextView textRecomendacion;

    private static final String TAG="activity_ver_datos";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"Entramos en onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos);

        datos = (Datos) getIntent().getSerializableExtra("datos");

        textView1 = (TextView) findViewById(R.id.txtnombre);
        textView2 = (TextView) findViewById(R.id.txtfecha);
        textView3 = (TextView) findViewById(R.id.txtemail);

        textView1.setText(datos.getNombre());
        textView2.setText(datos.getFecha());
        textView3.setText(datos.getEmail());


        textViewValoracion = (TextView) findViewById(R.id.textValoracion);
        textViewValoracion.setText(datos.getSpinner());


        textAficiones = findViewById(R.id.textAficiones);
        textAficiones.setText(TextUtils.join(", ", datos.getAficiones()));


        textRecomendacion = findViewById(R.id.textRecomendacion);
        textRecomendacion.setText(datos.getRecomendacion());


    }

    public void volver(View view) {
        Intent intent = new Intent(activity_VerDatos.this, MainActivity.class);
        startActivity(intent);
    }

}