package com.example.primerosdibujos;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.Rect;
import android.graphics.Region;
import android.text.ClipboardManager;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
    	public EjemploView(Context contexto) {
    		super(contexto);
    		
    	}
    	
    	protected void onDraw(Canvas canvas) {

    		
    		Paint pincel=new Paint();

    		canvas.drawRGB(0, 0, 0);
    		
    		//Circulo central:
    		pincel.setColor( Color.MAGENTA);
    		pincel.setStrokeWidth(10);
    		pincel.setStyle(Paint.Style.STROKE);
    		canvas.drawCircle(getLeft() +120, getTop() +145, 100, pincel);
    		
    		//cuadrado medio:
    		pincel.setColor(Color.CYAN);
    		canvas.drawRect(getLeft()+120, getTop() +145, getRight()-120, getBottom()-145, pincel);
    		
    		//cuadrado azul superior derecha:
    		pincel.setStrokeWidth(20);
    		pincel.setColor(Color.BLUE);
    		canvas.drawRect(getLeft()+215, getTop() +20, getRight()-20, getBottom()-260, pincel);
    		
    		
    		//cuadrado rojo superior izkierda:
    		pincel.setColor(Color.RED);
    		canvas.drawRect(getLeft()+20, getTop() +20, getRight()-215, getBottom()-260, pincel);
    		
    		//cuadrado verde inferior izkierda:
    		pincel.setColor(Color.GREEN);
    		canvas.drawRect(getLeft()+20, getTop() +260, getRight()-215, getBottom()-20, pincel);
    		
    		//cuadrado amarillo inferior derecha:
    		pincel.setColor(Color.YELLOW);
    		canvas.drawRect(getLeft()+215, getTop() +260, getRight()-20, getBottom()-20, pincel);
    		
    	}
    }
}
