package com.example.menu;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PantallaListView extends Activity{

    private Titular[] datos = 
    	new Titular[]{
    		new Titular("AD", "Acceso a datos"),
    		new Titular("PSP", "Programación de servicios y procesos"),
    		new Titular("DI", "Desarrollo de interfaces"),
    		new Titular("RMI", "Ingles"),
    		new Titular("PMM", "Programación multimedia y dispositivos móviles"),
    		new Titular("SGE", "Sistemas de gestión empresarial"),
    		new Titular("EIE", "Empresa iniciativa y emprendedora")};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_listview);
          
        AdaptadorTitulares adaptador = 
        	new AdaptadorTitulares(this);
        
        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        
        lstOpciones.setAdapter(adaptador);
    }
    
    static class ViewHolder {
    	TextView titulo;
    	TextView subtitulo;
    	}

    
    class AdaptadorTitulares extends ArrayAdapter {
    	
    	Activity context;
    	
    	AdaptadorTitulares(Activity context) {
    		super(context, R.layout.listitem_titular, datos);
    		this.context = context;
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {View item = convertView;
    	ViewHolder holder;
    	if(item == null)
    	{ LayoutInflater inflater = context.getLayoutInflater();
    	item = inflater.inflate(R.layout.listitem_titular, null);
    	holder = new ViewHolder();
    	holder.titulo = (TextView)item.findViewById(R.id.LblTitulo);
    	holder.subtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
    	item.setTag(holder);
    	}
    	else
    	{
    	holder = (ViewHolder)item.getTag(); }
    	holder.titulo.setText(datos[position].getTitulo());
    	holder.subtitulo.setText(datos[position].getSubtitulo());
    	return(item);

		}
    }

}
