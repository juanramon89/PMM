package com.example.ejemplosensores;

import java.util.List;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class EjemploSensor extends Activity implements  SensorEventListener{
	
	private TextView salida;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//Campo de texto para mostrar la salida
		salida = (TextView)findViewById(R.id.textView1);
		//Obejeto SensorManager que nos permitirá ver la lista de sensores del dispositivo
		SensorManager miSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
		List<Sensor> listaSensores = miSensorManager.getSensorList(Sensor.TYPE_ALL);
		//Vamos mostrando los sensores uno a uno
		for(Sensor sensor:listaSensores){
			mostrar(sensor.getName());
		}
		//OJO: SI ALGUNO DE ESTOS SENSORES NO VAN INCORPORADOS EN EL MOVIL LA APLICACION MUESTRA UN ERROR!
		//Registramos los sensores para tener acceso a ellos.
		//Debemos registrar cada tipo de sensor por separado para poder obtener informacion de el.
		//En primer lugar registramos el sensor de orientacioçon:
		listaSensores = miSensorManager.getSensorList(Sensor.TYPE_ORIENTATION);
		Sensor sensorOrientacion = listaSensores.get(0);
		miSensorManager.registerListener(this, sensorOrientacion, SensorManager.SENSOR_DELAY_UI);
		//Despues registramos el acelerómetro:*/
		listaSensores = miSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
		Sensor sensorAcelerometro = listaSensores.get(0);
		miSensorManager.registerListener(this, sensorAcelerometro, SensorManager.SENSOR_DELAY_UI);
		//Despues registramos la brújula:
		listaSensores = miSensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
		Sensor sensorBrujula = listaSensores.get(0);
		miSensorManager.registerListener(this, sensorBrujula, SensorManager.SENSOR_DELAY_UI);
		//Por último registramos el sensor de temperatura:
		listaSensores = miSensorManager.getSensorList(Sensor.TYPE_TEMPERATURE);
		Sensor sensorTemperatura = listaSensores.get(0);
		miSensorManager.registerListener(this, sensorTemperatura, SensorManager.SENSOR_DELAY_UI);
		
	}
	
	private void mostrar(String cadena){
		salida.append(cadena += "\n");
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		//Cada sensor puede provocar que un hilo pase por aquí
		//así que sincronizamos el acceso.
		synchronized (this){
			switch (event.sensor.getType()){
			case Sensor.TYPE_ORIENTATION:
				for(int i = 0;i<3;i++){
					mostrar("Orientación "+ i +": "+ event.values[i]);
				}
				break;
			case Sensor.TYPE_ACCELEROMETER:
				for(int i = 0;i<3;i++){
					mostrar("Acelerómetro "+ i +": "+ event.values[i]);
				}
				break;
			case Sensor.TYPE_MAGNETIC_FIELD:
				for(int i = 0;i<3;i++){
					mostrar("Brújula "+ i +": "+ event.values[i]);
				}
				break;
			case Sensor.TYPE_TEMPERATURE:
				for(int i = 0;i<3;i++){
					mostrar("Temperatura "+ i +": "+ event.values[i]);
				}
				break;
			}
		}
		
	}

}
