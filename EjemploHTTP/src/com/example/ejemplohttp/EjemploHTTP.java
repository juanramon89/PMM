package com.example.ejemplohttp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class EjemploHTTP extends Activity {
	private Button boton;
	private TextView texto;
	private String noticias;
	private String salida;
	private String[] dato;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ejemplo_http);
		boton = (Button)findViewById(R.id.boton1);
		texto = (TextView)findViewById(R.id.texto1);
		
		
		try{
			noticias = buscarNoticias();
			texto.append(noticias);
		}catch (Exception e){
			texto.append("Error al conectar");
			e.printStackTrace();
		}
		
		boton.setOnClickListener(new OnClickListener(){
			public void onClick(View view){
				
				Intent intent = new Intent(EjemploHTTP.this,Mi_Spinner.class);
        		Bundle b = new Bundle();
        		
        		b.putString("NOTICIAS", noticias);
        		
        		intent.putExtras(b);

				startActivity(intent);
			}
		});
		
		
	         
	        
	}
	

	
	
	private String buscarNoticias() throws Exception{
		
		int i=0, j=0, k=0;
		
		
		URL url = new URL("http://www.elpais.com/rss/feed.html?feedId=1022");
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		
		conexion.setRequestProperty("User-Agent", "Mozilla/5.0"+
									"Linux; Android 1.5; es-ES) Ejemplo HTTP");
		
		if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK){
			BufferedReader lector = new BufferedReader(
					new InputStreamReader(conexion.getInputStream()));
			String linea = lector.readLine();
			while (linea != null){
				if (linea.indexOf("<title>") >= 0){
					i = linea.indexOf("<title>")+16;
					j = linea.indexOf("</title>")-3;
					salida += linea.substring(i,j);
					dato[k]= salida;
					k++;
					salida += "\n-----------------\n";
				}
				
				linea = lector.readLine();
			}
			lector.close();
		}else{
			salida = "No encontrado";
		}
		conexion.disconnect();
		return salida;
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ejemplo_htt, menu);
		return true;
	}

}
