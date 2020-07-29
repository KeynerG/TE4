package com.recorridos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import BTS.*;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et1, et2, et3, et4, et5, et6, et7;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.editTextNumber);
        et2 = (EditText)findViewById(R.id.editTextNumber2);
        et3 = (EditText)findViewById(R.id.editTextNumber3);
        et4 = (EditText)findViewById(R.id.editTextNumber4);
        et5 = (EditText)findViewById(R.id.editTextNumber5);
        et6 = (EditText)findViewById(R.id.editTextNumber6);
        et7 = (EditText)findViewById(R.id.editTextNumber7);
        tv1 = (TextView)findViewById(R.id.textView2);
        spinner1 = (Spinner)findViewById(R.id.spinner);
        String[] opciones = {"INORDEN","PREORDEN","POSORDEN"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);
    }


    public void btn_click(View view) {



    }
}