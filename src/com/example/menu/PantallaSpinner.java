package com.example.menu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class PantallaSpinner extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_spinner);
        
        final TextView mensaje = (TextView)findViewById(R.id.textViewSpinner);
        final Spinner opciones = (Spinner)findViewById(R.id.OpcionesSpinner);
        
        final String[] datos =
            new String[]{"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
        		"Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
     
        ArrayAdapter<String> adaptador =
            new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);
        
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
         
        opciones.setAdapter(adaptador);

        opciones.setOnItemSelectedListener(
        	new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,
                    android.view.View v, int position, long id) {
                        mensaje.setText("Seleccionado: " + datos[position]);
                }
         
                public void onNothingSelected(AdapterView<?> parent) {
                    mensaje.setText("");
                }
        });
    }

}
