package com.example.menu;




import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class ActivityMenu extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		ImageView imagen =(ImageView)findViewById(R.id.imageView1);
		imagen.setImageResource(R.drawable.rec);
		
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.control_basico:
        	Intent intent = new Intent(ActivityMenu.this,ControlBasico.class);
        	startActivity(intent);
            return true;
        case R.id.control_seleccion:
        	Intent intent2 = new Intent(ActivityMenu.this,ControlSeleccion.class);
        	startActivity(intent2);
            return true;
        case R.id.acercaDe:
        	Intent intent3 = new Intent(ActivityMenu.this,AcercaDe.class);
        	startActivity(intent3);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }

}
