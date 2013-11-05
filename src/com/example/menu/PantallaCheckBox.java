package com.example.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class PantallaCheckBox extends Activity{
	CheckBox checkBoxViajes; 
	CheckBox checkBoxInformatica;
	CheckBox checkBoxMusica;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantalla_checkbox);
		
		initialUISetup();

		
	}
	
	public void initialUISetup(){
		checkBoxViajes = (CheckBox)findViewById(R.id.checkBoxViajes);
		checkBoxInformatica = (CheckBox)findViewById(R.id.checkBoxInformatica);
		checkBoxMusica = (CheckBox)findViewById(R.id.checkBoxMusica);
	}
	
	public void botonCheckOnClick(View v){ //atencion a este metodo, botonCheckOnClick hace referencia al botonCheck del .xml
		String strMessage = "";			   //el cual lleva se le a añadido el metodo onClick llamado 'botonCheckOnClick'

		if(checkBoxViajes.isChecked())
		{
			strMessage+="viajes ";
		}

		if(checkBoxInformatica.isChecked())
		{
			strMessage+="informática ";
		}

		if(checkBoxMusica.isChecked())
		{
			strMessage+="música ";
		}
		
		showTextNotification(strMessage);

		
	}
	
	public void showTextNotification(String msgToDisplay)
	{
	    	Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
	}

	

}
