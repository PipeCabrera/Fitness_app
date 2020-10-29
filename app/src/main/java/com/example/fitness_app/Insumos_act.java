package com.example.fitness_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Insumos_act extends AppCompatActivity {

    private EditText edcodigo, ednombre, edprecio, edstock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos_act);

        edcodigo = (EditText) findViewById(R.id.codigo);
        ednombre = (EditText) findViewById(R.id.nombre);
        edprecio = (EditText) findViewById(R.id.precio);
        edstock = (EditText) findViewById(R.id.stock);

    }

    public void añadirInsumo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        if (!edcodigo.getText().toString().isEmpty()) {
            ContentValues registro = new ContentValues();

            registro.put("codigo", edcodigo.getText().toString());
            registro.put("nombre", ednombre.getText().toString());
            registro.put("precio", edprecio.getText().toString());
            registro.put("stock", edstock.getText().toString());

            bd.insert("Insumos", null, registro);
            bd.close();
            Toast.makeText(this, "Se ha guardado un insumo", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Debe ingresar un insumo", Toast.LENGTH_LONG).show();
        }
    }

    public void MostrarInsumo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        if (!codigo.isEmpty()) {
            Cursor fila = bd.rawQuery("SELECT nombre, precio, stock FROM Insumos WHERE codigo =" + codigo, null);

            if (fila.moveToFirst()) {
                ednombre.setText(fila.getString(0));
                edprecio.setText(fila.getString(1));
                edstock.setText(fila.getString(2));

            } else {
                Toast.makeText(this, "Debe Ingresar el codigo del insumo", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void EliminarInsumo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        bd.delete("Insumos", "codigo=" + codigo, null);
        bd.close();

        Toast.makeText(this, "Se ha eliminado el insumo", Toast.LENGTH_LONG).show();

    }

public void actualizarInsumo(View v) {
    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
    SQLiteDatabase bd = admin.getWritableDatabase();

    String codigo = edcodigo.getText().toString();
    ContentValues content = new ContentValues();

    content.put("codigo", edcodigo.getText().toString());
    content.put("nombre", ednombre.getText().toString());
    content.put("precio", edprecio.getText().toString());
    content.put("stock", edstock.getText().toString());

    if (!codigo.isEmpty()) {
        bd.update("Insumos", content, "codigo=" + codigo, null);
        Toast.makeText(this, "Se ha actualizado el insumo", Toast.LENGTH_LONG).show();

    }
}
}
