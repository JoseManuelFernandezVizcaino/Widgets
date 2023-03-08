package com.example.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

public class activity_Recomendacion extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Datos datos;

    private Button botonGuardar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendacion);

        datos = (Datos) getIntent().getSerializableExtra("datos");
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                botonGuardar.setEnabled(true);
            }
        });

        botonGuardar = (Button) findViewById(R.id.btnGuardarRecomendacion);
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // obtener el valor seleccionado del RadioGroup
                int radioButtonId = radioGroup.getCheckedRadioButtonId();
                String seleccion = "";
                if (radioButtonId == R.id.rdbtnSI) {
                    seleccion = "SÍ, SIN DUDARLO";
                } else if (radioButtonId == R.id.rdbtnNO) {
                    seleccion = "NO, NO ME HA GUSTADO";
                } else if (radioButtonId == R.id.rdbtnQUIZAS) {
                    seleccion = "DEPENDE COMO ME PILLE EL DÍA";
                }

                Intent intent = new Intent(activity_Recomendacion.this, MainActivity.class);
                datos.setRecomendacion(seleccion);
                intent.putExtra("datos", datos);
                startActivity(intent);
            }
        });
    }

    public void volver (View  view){
        Intent intent= new Intent (activity_Recomendacion.this, MainActivity.class);
        startActivity(intent);
    }

    protected void onResume() 	{
        super.onResume();
        botonGuardar.setEnabled(false);
    }
}