package com.example.dibujocasa;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Paint.Style;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(new EjemploView(this));
	}
	
	public class EjemploView extends View{
		public EjemploView(Context contexto){
			super(contexto);
		}
		
		@Override
		protected void onDraw(Canvas canvas){
			
			
			//Insertar imagen de fondo:
			Bitmap imagen = BitmapFactory.decodeResource(getResources(),R.drawable.bosque);
			canvas.drawBitmap(imagen, null, new Rect(0, 0, canvas.getHeight(), canvas.getHeight()), null);
		
			Paint pincel = new Paint();
			
			//Dibujo de las paredes:
			pincel.setColor(Color.rgb(240, 185, 32));
			pincel.setStrokeWidth(5);
			pincel.setStyle(Style.FILL_AND_STROKE);
		
			canvas.drawRect(50, 350, 250, 550, pincel);
			canvas.drawRect(250, 350, 450, 550, pincel);
		
			Path path = new Path();
		
			path.setFillType(FillType.EVEN_ODD);
			path.moveTo(50, 350);
			path.lineTo(150, 200);
			path.lineTo(250, 350);
			path.close();
			canvas.drawPath(path, pincel);
		
			//Dibujo del tejado
			Path path2 = new Path();
			
			path2.setFillType(FillType.EVEN_ODD);
			pincel.setColor(Color.rgb(102, 51, 0));
			pincel.setStrokeWidth(10);
			pincel.setStyle(Style.FILL_AND_STROKE);			
			path2.moveTo(50, 350);
			path2.lineTo(150, 200);
			path2.lineTo(250, 350);
			path2.lineTo(450, 350);
			path2.lineTo(350, 200);
			path2.lineTo(152, 200);
			path2.close();
			canvas.drawPath(path2, pincel);
		
			//Dibujo de la puerta:
			pincel.setColor(Color.rgb(153, 76, 0));
			pincel.setStrokeWidth(10);
			pincel.setStyle(Style.FILL);
			
			canvas.drawRect(125, 470, 175, 550, pincel);
			
			//Dibujo de las ventanas:
			pincel.setColor(Color.rgb(51, 204, 255));
			pincel.setStrokeWidth(10);
			pincel.setStyle(Style.FILL);
		
			canvas.drawRect(75, 375, 125, 425, pincel);
			canvas.drawRect(175, 375, 225, 425, pincel);
			canvas.drawRect(275, 375, 325, 425, pincel);
			canvas.drawRect(375, 375, 425, 425, pincel);
			
			
			//Linea de contorno:
			Path path3 = new Path();
		
			path3.setFillType(FillType.EVEN_ODD);
			pincel.setColor(Color.BLACK);
			pincel.setStrokeWidth(10);
			pincel.setStyle(Style.STROKE);
			
			path3.moveTo(50, 550);
			path3.lineTo(450, 550);
			path3.lineTo(450, 350);
			path3.lineTo(350, 200);
			path3.lineTo(152, 200);
			path3.lineTo(50, 350);
			path3.lineTo(50, 550);
			path3.moveTo(250, 550);
			path3.lineTo(250, 350);
			path3.lineTo(450, 350);
			path3.moveTo(250, 350);
			path3.lineTo(150, 200);
			
			canvas.drawPath(path3, pincel);
		}
	}

}
