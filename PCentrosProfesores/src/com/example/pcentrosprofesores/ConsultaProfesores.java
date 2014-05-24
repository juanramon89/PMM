package com.example.pcentrosprofesores;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class ConsultaProfesores extends Activity{
public static final int CODIGO_RESPUESTA = 123;
	
	BaseDatos base;
	private Profesores[] datos;
	
	class AdaptadorProfesores extends ArrayAdapter<Profesores> {
		Activity a;
		AdaptadorProfesores(Activity b) 
		{
			super(b, R.layout.lista_profesores,datos);
			this.a = b;
		}
		public View getDropDownView (int position,View convertView,ViewGroup parent) {
			
			//if(item==null)
			return getView (position, convertView, parent);
			}
		public View getView(int position,View convertView,ViewGroup parent) 
		{
		//if(item==null)	
			LayoutInflater inflater = a.getLayoutInflater();	
			View item = inflater.inflate(R.layout.lista_profesores, null);
			 	 	 
			final TextView lblCodigo=(TextView)item.findViewById(R.id.codigo);
			final TextView lblDni = (TextView)item.findViewById(R.id.dni);
			final TextView lblApellidos = (TextView)item.findViewById(R.id.apellidos);
			final TextView lblEspecialidad = (TextView)item.findViewById(R.id.especialidad);
			
			lblCodigo.setText(datos[position].getCodCentro());
			lblDni.setText(datos[position].getDni());
			lblApellidos.setText(datos[position].getApellidos());
			lblEspecialidad.setText(datos[position].getEspecialidad());
			
			return(item);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.consulta_profesores);
		
				
		try 
		{
			
			String[] campos = new String[] {"cod_centro","dni","apellidos","especialidad"};
			
			base=new BaseDatos(this,"dbase",null,1);
			SQLiteDatabase db=base.getReadableDatabase();
			
			
			Cursor rs=db.query("profesores", campos, null,null,null,null,null);
			
			datos=new Profesores[rs.getCount()+1];//Devuelve el numero de filas + 1 
			datos[0]= new Profesores("Codigo","Dni","Apellidos","Especialidad");
			int i=1;
	        if (rs.moveToFirst()) 
	        {
	                do 
	                {
	                		String cod=rs.getString(0);
	                		String dni=rs.getString(1);
	                		String ape=rs.getString(2);
	                        String esp=rs.getString(3);
	                        
	                        datos[i]=new Profesores(cod,dni,ape,esp);
	                        i++;       
	                }
	                while (rs.moveToNext());
	        }
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		final Spinner spinner=(Spinner)findViewById(R.id.profesores);
		AdaptadorProfesores adaptador =new AdaptadorProfesores(this); 
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adaptador);
		

		
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
				Intent intent = new Intent(ConsultaProfesores.this, MostrarProfesores.class);
				
				Bundle b = new Bundle();
				String codigocentro = ((Profesores)parent.getAdapter().getItem(position)).getCodCentro();
				String dniProfesor =((Profesores)parent.getAdapter().getItem(position)).getDni();
				String apeProfesor = ((Profesores)parent.getAdapter().getItem(position)).getApellidos();
				String espProfesor = ((Profesores)parent.getAdapter().getItem(position)).getEspecialidad();
				
				b.putString("Codigo", codigocentro);
				b.putString("Dni", dniProfesor);
				b.putString("Apellidos", apeProfesor);
				b.putString("Especialidad", espProfesor);
				  				
				intent.putExtras(b);
				
				
				if(position > 0)
				startActivityForResult(intent, CODIGO_RESPUESTA);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}

			
			
		});

	}
	
	protected void onActivityResult(int requestCode,int resultCode, Intent pData)            
    {
        if ( requestCode == CODIGO_RESPUESTA )//Si el código de respuesta es igual al requestCode
            {
            if (resultCode == Activity.RESULT_OK )//Si resultCode es igual a ok
                {
                    final String dato = pData.getExtras().getString(MostrarProfesores.DATO_SUBACTIVIDAD );//Obtengo el string de la subactividad
                    //Aquí se hara lo que se desee con el valor recuperado

                    SQLiteDatabase db=base.getWritableDatabase();
                    db.execSQL(dato);
                                                           
                    Intent intent = new Intent(ConsultaProfesores.this, ConsultaProfesores.class);
                    finish();
                    startActivity(intent);
                }
            }
    }
}
