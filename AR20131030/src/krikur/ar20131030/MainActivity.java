package krikur.ar20131030;

import java.net.InetAddress;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.codeminders.ardrone.ARDrone;

public class MainActivity extends Activity implements SensorEventListener {

	private static ARDrone drone;
	private static final long CONNECTION_TIMEOUT = 10000;
	private static final String TAG = "AR.Drone";

	// Das er die Bewegung des Handy erkennt
	private Sensor sensor;
	private SensorManager sManager;
	private float seitwärts, vorwärts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		java.lang.System.setProperty("java.net.preferIPv4Stack", "true");
		java.lang.System.setProperty("java.net.preferIPv6Addresses", "false");

		final Button btnConnect = (Button) findViewById(R.id.verbinden);
		btnConnect.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startARDroneConnection(btnConnect);
			}
		});

		(findViewById(R.id.abheben)).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					drone.clearEmergencySignal();
					drone.trim(); 
					drone.takeOff();
				} catch (Throwable e) {
					Log.e(TAG, "Faliled to execute take off command", e);
				}
			}
		});
//		(findViewById(R.id.rechts)).setOnClickListener(new OnClickListener() {
//
		
		// Hallo
		
		
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				try {
//					drone.move(0, 0, 0, 0.15f);
//				} catch (Throwable e) {
//					Log.e(TAG, "Faliled to execute rechts command", e);
//				}
//			}
//		});
		(findViewById(R.id.landen)).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					drone.land();
				} catch (Throwable e) {
					Log.e(TAG, "Faliled to execute land command", e);
				}
			}
		});

		sManager = (SensorManager) findViewById(R.id.bewegen).getContext()
				.getSystemService(Context.SENSOR_SERVICE);
		sensor = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		// /////////////Geschwindigkeit der Aktualisierung evtl. noch anpassen
		sManager.registerListener(this, sensor,
				SensorManager.SENSOR_DELAY_NORMAL);

		// (findViewById(R.id.bewegen)).setOnClickListener(new OnClickListener()
		// {
		// //
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		//
		// Toast.makeText(v.getContext(), "Du hast geklickt",
		// Toast.LENGTH_SHORT).show();
		// }
		//
		// });

		((SeekBar) findViewById(R.id.seekBar1))
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						seekBar.setProgress(10000);
						drehen(0);

					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						// TODO Auto-generated method stub
						float stärke = 0.0001f * progress - 1;
						drehen(stärke);
					}

				});

	}

	/**
	 * A positive value makes the drone spin right; a negative value makes it
	 * spin left.
	 **/
	private void drehen(float stärke) {
		// TODO Auto-generated method stub

		String richtung = "keine";
		if (stärke > 0) {
			richtung = "rechts rum -->";
		} else {
			if (stärke < 0) {
				richtung = "<-- links rum";
			} else {
				richtung = "keine";
			}
		}
		((TextView) findViewById(R.id.dreh)).setText("Richtung: " + richtung
				+ ", Stärke: " + stärke);

		try {
			drone.move(0, 0, 0, stärke);
		} catch (Throwable e) {
			Log.e(TAG, "Faliled to execute rechts command", e);
		}
	}

	private void startARDroneConnection(final Button btnConnect) {
		WifiManager connManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

		if (connManager.isWifiEnabled()) {
			// state.setTextColor(Color.RED);
			// state.setText("Connecting..." +
			// connManager.getConnectionInfo().getSSID());
			btnConnect.setEnabled(false);
			(new DroneStarter()).execute(MainActivity.drone);
		}
		// else {
		// turnOnWiFiDialog.show();
		// }
	}

	// fürSensorManager
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	// fürSensorManager
	@Override
	public void onSensorChanged(SensorEvent event) {

		TextView seite = (TextView) findViewById(R.id.seite);
		TextView vor = (TextView) findViewById(R.id.vorhinter);

		String seitwärtsRichtung, vorwärtsRichtung;

		if ((findViewById(R.id.bewegen)).isPressed()) {
			seitwärts = event.values[0] * (-1);
			vorwärts = event.values[1];
			if (seitwärts > 0) {
				seitwärtsRichtung = " --> RECHTS ";
			} else {
				seitwärtsRichtung = " LINKS <-- ";
			}
			if (vorwärts > 0) {
				vorwärtsRichtung = " V Zurück V ";
			} else {
				vorwärtsRichtung = " A Vor A ";
			}

			seite.setText(seitwärtsRichtung + "(" + seitwärts + ")");
			vor.setText(vorwärtsRichtung + "(" + vorwärts + ")");

			try {
				drone.move(seitwärts, vorwärts, 0, 0);
			} catch (Throwable e) {
				Log.e(TAG, "Faliled to execute rechts command", e);
			}

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class DroneStarter extends AsyncTask<ARDrone, Integer, Boolean> {

		@Override
		protected Boolean doInBackground(ARDrone... drones) {
			ARDrone drone = drones[0];
			try {
				drone = new ARDrone(
						InetAddress.getByAddress(ARDrone.DEFAULT_DRONE_IP),
						10000, 60000);
				MainActivity.drone = drone;
				drone.connect();
				drone.clearEmergencySignal();
				drone.trim();
				drone.waitForReady(CONNECTION_TIMEOUT);
				drone.playLED(1, 10, 4);
				drone.selectVideoChannel(ARDrone.VideoChannel.HORIZONTAL_ONLY);
				drone.setCombinedYawMode(true);
				return true;
			} catch (Exception e) {
				Log.e(TAG, "Failed to connect to drone", e);
				try {
					drone.clearEmergencySignal();
					drone.clearImageListeners();
					drone.clearNavDataListeners();
					drone.clearStatusChangeListeners();
					drone.disconnect();
				} catch (Exception ex) {
					Log.e(TAG, "Failed to clear drone state", ex);
				}

			}
			return false;
		}

		// protected void onPostExecute(Boolean success) {
		// if (success.booleanValue()) {
		// droneOnConnected();
		// } else {
		// // state.setTextColor(Color.RED);
		// // state.setText("Error");
		// connectButton.setEnabled(true);
		// }
		// }
	}

}
