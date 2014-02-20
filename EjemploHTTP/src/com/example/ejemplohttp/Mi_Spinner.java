package com.example.ejemplohttp;


import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Mi_Spinner extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        
        final TextView lblMensaje = (TextView)findViewById(R.id.textView1);
        final Spinner cmbOpciones = (Spinner)findViewById(R.id.spinner1);
        
        Bundle bundle = getIntent().getExtras();
        
        final String[] datos = {"Elemento1","Elemento2","Elemento3"};
        String total = bundle.getString("NOTICIAS");
     
        ArrayAdapter<String> adaptador =
            new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);
        
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
         
        cmbOpciones.setAdapter(adaptador);

        cmbOpciones.setOnItemSelectedListener(
        	new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,
                    android.view.View v, int position, long id) {
                        lblMensaje.setText("Seleccionado: " + datos[position]);
                }
         
                public void onNothingSelected(AdapterView<?> parent) {
                    lblMensaje.setText("");
                }
        });
    }
}