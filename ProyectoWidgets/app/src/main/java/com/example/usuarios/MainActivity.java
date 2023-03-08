package com.example.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Datos datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle intent = this.getIntent().getExtras();
        if(intent == null) {
            datos = new Datos();
        }else {
            datos = (Datos) getIntent().getSerializableExtra("datos");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void alta (View  view){
        Intent intent= new Intent (MainActivity.this, activity_Alta.class);
        intent.putExtra("datos", datos);
        startActivity(intent);
    }

    public void recomendacion (View  view){
        Intent intent= new Intent (MainActivity.this, activity_Recomendacion.class);
        intent.putExtra("datos", datos);
        startActivity(intent);
    }
    public void aficiones (View  view){
        Intent intent= new Intent (MainActivity.this, activity_Aficiones.class);
        intent.putExtra("datos", datos);
        startActivity(intent);
    }

    public void verDatos (View  view){
        Intent intent= new Intent (MainActivity.this, activity_VerDatos.class);
        intent.putExtra("datos", datos);
        startActivity(intent);
    }

    public void valoracion (View  view){
        Intent intent= new Intent (MainActivity.this, activity_Valoracion.class);
        intent.putExtra("datos", datos);
        startActivity(intent);
    }

    public void cerrar (View  view){
        finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }


}

