package com.example.menu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PantallaListaSeleccion extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantalla_listaseleccion);
		
		//localizar los controles
		TextView textViewLista = (TextView)findViewById(R.id.textViewListaSeleccion);
		
		//accedemos al intent que a originado la actividad original y recuperamos su informacion asociada.
		Bundle bundle = getIntent().getExtras();
		
		//Construimos el mensaje a mostrar.
		textViewLista.setText(bundle.getString("NOMBRE"));
	}

}
