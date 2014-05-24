package com.example.pcentrosprofesores;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MostrarProfesores extends Activity {
public static final String DATO_SUBACTIVIDAD="";
 	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mostrar_profesores);
		
		Button guardar = (Button)findViewById(R.id.guardarProfesor);
		Button eliminar = (Button)findViewById(R.id.eliminarProfesor);
		
		// Localizamos los controladores
		final TextView codigo = (TextView)findViewById(R.id.codigoCentro);
		final TextView dni = (TextView)findViewById(R.id.dniProfesor);
		final TextView apellidos = (TextView)findViewById(R.id.apellidosProfesor);
		final TextView especialidad = (TextView)findViewById(R.id.especialidadProfesor);

		    codigo.setKeyListener(null);
		    	 
		// recuperamos informacion del intent
		   	 Bundle b = this.getIntent().getExtras();
		    	 
		   	 codigo.setText(b.getString("Codigo"));
		   	 dni.setText(b.getString("Dni"));
		   	 apellidos.setText(b.getString("Apellidos"));
		   	 especialidad.setText(b.getString("Especialidad"));
		    			   	 
		guardar.setOnClickListener(new OnClickListener() {
		 			
		 	@Override
		 	public void onClick(View v) {
		 				 		
		 		String cod = codigo.getText().toString();
		 		String dn = dni.getText().toString();
		 		String ape = apellidos.getText().toString();
		 		String esp = especialidad.getText().toString();
		 		Intent resultData = new Intent();
		 				 		
		 		String sentencia = "UPDATE profesores SET  dni = '"+dn+"', apellidos = '"+ape+"', especialidad = '"+esp+"' WHERE cod_centro = '"+cod+"'";
		 				 		
		 		resultData.putExtra(DATO_SUBACTIVIDAD, sentencia);	
				setResult(android.app.Activity.RESULT_OK, resultData);
                finish();
						 				
			}
		});
		
		   eliminar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String cod = codigo.getText().toString();
				Intent resultData = new Intent();

				String sentencia = "DELETE FROM profesores WHERE cod_centro = '"+cod+"'";
				
				resultData.putExtra(DATO_SUBACTIVIDAD, sentencia);	
				setResult(android.app.Activity.RESULT_OK, resultData);
                finish();
				
			}
		});
				
	}
}
