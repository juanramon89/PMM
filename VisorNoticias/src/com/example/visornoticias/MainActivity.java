package com.example.visornoticias;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;



import com.example.pruebalistview.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Button buscar;
	private TextView text;
	private Button ver;
	public ArrayList<String> datos= new ArrayList<String>();
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		buscar = (Button)findViewById(R.id.button1);
		ver = (Button)findViewById(R.id.button2);
		text = (TextView)findViewById(R.id.textView1);
		
		
		buscar.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				try{
					String noticias =
							buscarNoticias();
					text.append(noticias);
							
					/*for(int i =0;i<=datos.size();i++){
						Log.d("ARRAY", " " + datos.get(i));
					}*/
				}catch (Exception e){
					text.append("Error "+e);
					e.printStackTrace();
				}
			}
		});
		
		ver.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				
				Intent i= new Intent(MainActivity.this,VerLista.class);
				
				i.putStringArrayListExtra("DATOS", datos);
				startActivity(i);
			}
		});
		
		
	}
	
	private String buscarNoticias() throws Exception{
		String salida = "";
		String noticia = "";
		int i=0,j=0,c=0;
		int count=0;
		
		try{
			URL enlace = new URL("http://www.elpais.com/rss/feed.html?feedId=1022");
			HttpURLConnection conexion=(HttpURLConnection)enlace.openConnection();
			conexion.setRequestProperty("User-Agent", "Mozilla/5.0"+
										"(Linux; Android 1.5; es-ES) Ejemplo HTTP");
			
			if(conexion.getResponseCode()==HttpURLConnection.HTTP_OK){
				BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				String lectura = lector.readLine();
				while(lectura!=null){
					if(lectura.indexOf("<title>")>=0){
						i=lectura.indexOf("<title>")+16;
						j=lectura.indexOf("</title>")-3;
						noticia = lectura.substring(i,j);
						salida += noticia;
						datos.add(c, noticia);
						//System.out.println(lectura.substring(i,j));
						salida+= "\n***************\n";
						c++;
					}
					
					
					lectura=lector.readLine();
				}
				lector.close();
			}
			else{
				salida="No encontrado";
			}
			conexion.disconnect();
		}catch (Exception e){
			salida ="No encontrado servidor o noticia";
		}
		
		return salida;
	}

}
