package com.example.menu;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ControlBasico extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.control_basico);
		
		final TextView textViewCB = (TextView)findViewById(R.id.textViewCB);
		textViewCB.setTextSize(0x00000001, 20);
		final Button botonCheck = (Button)findViewById(R.id.botonCheck);
		final Button botonRadio = (Button)findViewById(R.id.botonRadio);
		final Button botonHola = (Button)findViewById(R.id.botonHola);
		final EditText editTextNombre = (EditText)findViewById(R.id.editTextNombre);
		
		botonHola.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(ControlBasico.this,PantallaHola.class);
				
				Bundle b = new Bundle();
				b.putString("NOMBRE", editTextNombre.getText().toString());
				
				intent.putExtras(b);
				
				startActivity(intent);
			}

			
		});
		
		botonCheck.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(ControlBasico.this,PantallaCheckBox.class);
				
				startActivity(intent);
			}
		});
		
		botonRadio.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(ControlBasico.this,PantallaRadioButton.class);
				
				startActivity(intent);
			}
		});
	}

}
