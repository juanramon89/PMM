package com.example.visornoticias;

import java.util.ArrayList;

import com.example.pruebalistview.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VerLista extends Activity {
	
	private ListView lista;
	private ArrayList<String> noticias = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ver_lista);
		
		lista = (ListView)findViewById(R.id.listView1);
		
		Bundle bundle = getIntent().getExtras();
		
		noticias = bundle.getStringArrayList("DATOS");
		
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, noticias);
		lista.setAdapter(adaptador);
	}
	


}
