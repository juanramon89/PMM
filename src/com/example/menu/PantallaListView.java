package com.example.menu;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PantallaListView extends Activity{

    private Titular[] datos = 
    	new Titular[]{
    		new Titular("T�tulo 1", "Subt�tulo largo 1"),
    		new Titular("T�tulo 2", "Subt�tulo largo 2"),
    		new Titular("T�tulo 3", "Subt�tulo largo 3"),
    		new Titular("T�tulo 4", "Subt�tulo largo 4"),
    		new Titular("T�tulo 5", "Subt�tulo largo 5")};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_listview);
          
        AdaptadorTitulares adaptador = 
        	new AdaptadorTitulares(this);
        
        ListView lstOpciones = (ListView)findViewById(R.id.listViewOpciones);
        
        lstOpciones.setAdapter(adaptador);
        lstOpciones.setOnItemClickListener(new OnItemClickListener(){
        	 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "Ha pulsado el item " + position, Toast.LENGTH_SHORT).show();
         
            }
         
        }); 
   
    }
    
    class AdaptadorTitulares extends ArrayAdapter {
    	
    	Activity context;
    	
    	AdaptadorTitulares(Activity context) {
    		super(context, R.layout.lista_persona, datos);
    		this.context = context;
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.lista_persona, null);
			
			TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
			lblTitulo.setText(datos[position].getTitulo());
			
			TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
			lblSubtitulo.setText(datos[position].getSubtitulo());
			
			lblTitulo.setTextColor(Color.WHITE);
			lblSubtitulo.setTextColor(Color.WHITE);
			
			return(item);
		}
    	
    }

}
