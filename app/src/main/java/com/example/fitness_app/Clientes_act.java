package com.example.fitness_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Planes;

public class Clientes_act extends AppCompatActivity {

    private Spinner Spinner1 , Spinner2;
    private EditText edit;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        Spinner1 = (Spinner) findViewById(R.id.spinnerClientes);
        Spinner2 = (Spinner) findViewById(R.id.spinnerplanes);
        edit = (EditText) findViewById(R.id.et);
        text = (TextView) findViewById(R.id.tv);

        ArrayList<String> listadoClientes = (ArrayList<String>) getIntent().getSerializableExtra("listadoClientes");
        ArrayList<String> listadoPlanes = (ArrayList<String>) getIntent().getSerializableExtra("listadoPlanes");

        ArrayAdapter<String> adapt = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listadoClientes);
        ArrayAdapter<String> adaptr = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listadoPlanes);

        Spinner1.setAdapter(adapt);
        Spinner2.setAdapter(adaptr);

    }

    public void Calcular(View v)
    {
        Planes plan = new Planes();
        String Clientes = Spinner1.getSelectedItem().toString();
        String Planes = Spinner2.getSelectedItem().toString();

        int Saldo = Integer.parseInt(edit.getText().toString());
        int Xtreme = Integer.parseInt(plan.getXtreme());
        int Mindfullness = Integer.parseInt(plan.getMindfullness());
        int resultado = Saldo - Xtreme;
        int resultadodos = Saldo - Mindfullness;

        if(Clientes.equals("Roberto") && Planes.equals("Xtreme"))
        {
            text.setText("El valor del Plan Xtreme es : " + resultado);
        }

        if(Clientes.equals("Roberto") && Planes.equals("Mindfullness"))
        {
            text.setText("El valor del Plan Mindfullness es : " + resultadodos);

        }

        if (Clientes.equals("Fernando") && Planes.equals("Xtreme"))
        {
            text.setText("El valor del Plan Xtreme es : " + resultado);
        }
        if (Clientes.equals("Fernando") && Planes.equals("Mindfullness"))
        {
            text.setText("El valor del Plan Mindullness es : " + resultadodos);
        }

    }
}