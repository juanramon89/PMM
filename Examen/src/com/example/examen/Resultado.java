package com.example.examen;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends Activity{
	
	private int quinientos;
	private int doscientos;
	private int cien;
	private int cincuenta;
	private int veinte;
	private int diez;
	private int cinco;
	private int dos;
	private int uno;
	private double cincuentaCent;
	private double veinteCent;
	private double diezCent;
	private double aux;
	private double resto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultado);
		
		//localizar los controles
		TextView txtnombre = (TextView)findViewById(R.id.textView1);
		TextView txtConversion = (TextView)findViewById(R.id.textView2);

		Bundle bundle = getIntent().getExtras();
		

		double total = bundle.getDouble("RESULTADO");
		
		txtnombre.setText(bundle.getString("VALOR")+"\n"+(bundle.getString("TARIFA"))
				+"\nPESO: "+(bundle.getString("TOTAL")));
		
		txtConversion.setText(convertir(total));

	}
	
	
	public String convertir(double dinero){
		aux = dinero/500;
		resto = dinero%500;
		quinientos = (int)aux;
		aux = resto/200;
		resto = resto%200;
		doscientos = (int)aux;
		aux = resto/100;
		resto = resto%100;
		cien = (int)aux;
		aux = resto/50;
		resto = resto%50;
		cincuenta = (int)aux;
		aux = resto/20;
		resto = resto%20;
		veinte = (int)aux;
		aux = resto/10;
		resto = resto%10;
		diez = (int)aux;
		aux = resto/5;
		resto = resto%5;
		cinco = (int)aux;
		aux = resto/2;
		resto = resto%2;
		dos = (int)aux;
		aux = resto/1;
		resto = resto%1;
		uno = (int)aux;
		
		aux = resto/0.5;
		resto = resto%0.5;
		cincuentaCent = (int)aux;
		aux = resto/0.2;
		resto = resto%0.2;
		veinteCent = (int)aux;
		aux = resto/0.1;
		resto = resto%0.1;
		diezCent = (int)aux;
		
		
		String res = "Billetes de 500 Euros: "+String.valueOf(quinientos)+"\n"
				  +"Billetes de 200 Euros: "+String.valueOf(doscientos)+"\n"
				  +"Billetes de 100 Euros: "+String.valueOf(cien)+"\n"
				  +"Billetes de 50 Euros: "+String.valueOf(cincuenta)+"\n"
				  +"Billetes de 20 Euros: "+String.valueOf(veinte)+"\n"
				  +"Billetes de 10 Euros: "+String.valueOf(diez)+"\n"
				  +"Billetes de 5 Euros: "+String.valueOf(cinco)+"\n"
				  +"Monedas de 2 Euros: "+String.valueOf(dos)+"\n"
				  +"Monedas de 1 Euro: "+String.valueOf(uno)+"\n"
				  +"Monedas de 50 Centimos: "+String.valueOf(cincuentaCent)+"\n"
				  +"Monedas de 20 Centimos: "+String.valueOf(veinteCent)+"\n"
				  +"Monedas de 10 Centimos: "+String.valueOf(diezCent)+"\n";
		
		return res;
	}
	
	
	
}
