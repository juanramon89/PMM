package com.example.menu;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PantallaHola extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantalla_hola);
		
		//localizar los controles
		TextView txtmensaje = (TextView)findViewById(R.id.textViewHola);
		
		//accedemos al intent que a originado la actividad original y recuperamos su informacion asociada.
		Bundle bundle = getIntent().getExtras();
		
		//Construimos el mensaje a mostrar.
		txtmensaje.setText("Hola me llamo "+ bundle.getString("NOMBRE"));
	}

}
