package com.example.menu;



import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class PantallaRadioButton extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_radiobutton);
        
        final TextView opcion = (TextView)findViewById(R.id.textViewRadioButton);
        final RadioGroup grupo = (RadioGroup)findViewById(R.id.radioGroup1);

        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
	        public void onCheckedChanged(RadioGroup group, int seleccion) {
	        	opcion.setText("Opción seleccionada: " + seleccion);
	        }
        });

    }

}
