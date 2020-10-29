package com.example.fitness_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[]images ={R.drawable.a,R.drawable.b,R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        vf = (ViewFlipper) findViewById(R.id.slider);

        for(int i = 0; i < images.length; i++)
        {
            flip_image(images[i]);
        }
    }

    public void flip_image(int i)
    {
        ImageView View = new ImageView(this);
        View.setBackgroundResource(i);

        vf.addView(View);
        vf.setFlipInterval(2300);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    public void Clientes (View v)
    {
        ArrayList<String> Clientes = new ArrayList<String>();
        ArrayList<String> Planes = new ArrayList<String>();

        Clientes.add("Roberto");
        Clientes.add("Fernando");

        Planes.add("Xtreme");
        Planes.add("Mindfullness");

        Intent i = new Intent(this, Clientes_act.class);
        i.putExtra("listadoClientes", Clientes);
        i.putExtra("listadoPlanes", Planes);
        startActivity(i);
    }

    public void Maps (View v)
    {
        Intent i = new Intent(this,Maps_act.class);
        startActivity(i);
    }

    public void Info (View v)
    {
        Intent i = new Intent(this,Info_act.class);
        startActivity(i);
    }

    public void Insumos (View v)
    {
        Intent i = new Intent(this,Insumos_act.class);
        startActivity(i);
    }
}