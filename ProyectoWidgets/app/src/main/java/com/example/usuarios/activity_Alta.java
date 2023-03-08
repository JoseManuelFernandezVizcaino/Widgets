package com.example.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class activity_Alta extends AppCompatActivity {

    private static final String TAG = "activity_Alta";

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern ONLY_TEXT_REGEX =
            Pattern.compile("^[a-zA-Z\\s]+", Pattern.CASE_INSENSITIVE);

    private static Pattern DATE_PATTERN = Pattern.compile(
            "^\\d{2}/\\d{2}/\\d{4}$");
    EditText editText1;
    EditText editText2;
    EditText editText3;
    Button buttonGuardar;

    private Datos datos;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);

        datos = (Datos) getIntent().getSerializableExtra("datos");
        buttonGuardar = (Button) findViewById(R.id.botonGuardarAlta);

        editText1 = (EditText) findViewById(R.id.textoNombre);
        editText2 = (EditText) findViewById(R.id.textoFecha);
        editText3 = (EditText) findViewById(R.id.textoEmail);

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if(validarNombre(editText1.getText().toString())) {
                    enableSaveButom();
                }else {
                    Log.e(TAG, "El nombre no cumple con el patrón");
                    editText1.setError("Formato de nombre erróneo");
                }

            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(validarFecha(editText2.getText().toString())) {
                    enableSaveButom();
                }else {
                    Log.e(TAG, "La fecha no cumple con el patrón");
                    editText2.setError("Formato de fecha incorrecto (dd/mm/yyy)");
                }

            }
        });
        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(validarEmail(editText3.getText().toString())) {
                    enableSaveButom();
                }else {
                    Log.e(TAG, "El mail no cumple con el patrón");
                    editText3.setError("Formato incorrecto");
                }

            }
        });

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto1 = editText1.getText().toString();
                String texto2 = editText2.getText().toString();
                String texto3 = editText3.getText().toString();

                //Guardamos en el objeto compatido los datos pertenecientes a ESTE activity
                datos.setFecha(texto2);
                datos.setNombre(texto1);
                datos.setEmail(texto3);

                Intent intent = new Intent(activity_Alta.this, MainActivity.class);
                intent.putExtra("datos", datos);
                startActivity(intent);
            }
        });

    }

    private void enableSaveButom() {

        if(!editText1.getText().toString().isBlank()
                && !editText2.getText().toString().isBlank()
                && !editText3.getText().toString().isBlank()) {
            buttonGuardar.setEnabled(true);
        }else {
            buttonGuardar.setEnabled(false);
        }
    }

     public void volver(View view) {
        Intent intent = new Intent(activity_Alta.this, MainActivity.class);
        startActivity(intent);
     }

    protected void onResume() 	{
        super.onResume();
        buttonGuardar.setEnabled(false);
    }


    private boolean validarEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.matches();
    }

    private boolean validarFecha(String fecha) {
        return DATE_PATTERN.matcher(fecha).matches();
    }

    private boolean validarNombre(String nombre) {
        return ONLY_TEXT_REGEX.matcher(nombre).matches();
    }
}
