package com.example.examen;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultado);
		
		//localizar los controles
		TextView txtnombre = (TextView)findViewById(R.id.textView1);

		Bundle bundle = getIntent().getExtras();
		

		
		

		txtnombre.setText(bundle.getString("VALOR")+"\n"+(bundle.getString("TARIFA"))
				+"\nPESO: "+(bundle.getString("TOTAL")));

	}
}
