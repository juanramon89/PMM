package com.example.pcentrosprofesores;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class PCentrosProfesores extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pcentros_profesores);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		Button buttonCentros = (Button)findViewById(R.id.buttonCentros);
		Button buttonProfesores = (Button)findViewById(R.id.buttonProfesores);
		Button buttonPersonal = (Button)findViewById(R.id.buttonPersonal);
		
		buttonCentros.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(PCentrosProfesores.this,ConsultaCentros.class);
				
				startActivity(intent);
			}
		});
		
		buttonProfesores.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(PCentrosProfesores.this,ConsultaProfesores.class);
				
				startActivity(intent);
			}
		});
		
		buttonPersonal.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(PCentrosProfesores.this,ConsultaPersonal.class);
				
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pcentros_profesores, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_pcentros_profesores, container, false);
			return rootView;
		}
	}

}
