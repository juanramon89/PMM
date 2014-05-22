package com.example.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ControlSeleccion extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.control_seleccion);
		
		final TextView tituloCS = (TextView)findViewById(R.id.textViewCS);
		tituloCS.setTextSize(0x00000001, 20);
		final Button botonSpinner = (Button)findViewById(R.id.botonSpinner);
		final Button botonLista = (Button)findViewById(R.id.botonLista);
		
		botonSpinner.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(ControlSeleccion.this,PantallaSpinner.class);
				
				startActivity(intent);
			}
		});
		
		botonLista.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(ControlSeleccion.this,PantallaListView.class);
				
				startActivity(intent);
			}
		});
	}

}
