package com.example.examen;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class AcercaDe extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acerca_de);
		final TextView textView1 = (TextView)findViewById(R.id.textViewAD);
		textView1.setTextSize(0x00000001, 20);
	}

}