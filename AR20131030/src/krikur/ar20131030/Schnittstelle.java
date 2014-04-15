package krikur.ar20131030;

import java.io.IOException;

import com.codeminders.ardrone.ARDrone;

import android.util.Log;
import android.webkit.WebView.FindListener;
import android.widget.Switch;
import android.widget.Toast;

public class Schnittstelle extends Thread {
	private static final String TAG = "Schnittstelle";

	private MainActivity mainActivity = null;
	private Flugweg flugweg = new Flugweg();
	private ARDrone drone = null;

	private boolean fliegt;
	private long wartezeit = 35;

	private boolean fliegheim = false;

	@Override
	public void run() {

		
		
		// �NDERUNGFlugbefehl keinFlugbefehl = new Flugbefehl(0, 0, 0, 0);
		while (true) {
			// Log.i(TAG, "ich m�chte warten");
			try {
				sleep(wartezeit);
				// Log.i(TAG, "ich habe gewartet");
			} catch (InterruptedException e) {
				Log.e(TAG, e.toString());
			}

			if (fliegt) {
				// Log.i(TAG, "Sammeln der Flugbefehle");
				if (fliegheim) {
					fliegHeim();
				} else {
					float h�he = 0.0f;
					float front_back = mainActivity.getVorw�rts();
					float left_right = mainActivity.getSeitw�rts();
					float drehwinkel = mainActivity.getDrehst�rke();

					// nicht beachten den Schwebefluges.... (l�ngerer Heimflug,
					// daf�r genauer)
					if (front_back == 0.0f && drehwinkel == 0.0f
							&& left_right == 0.0f && h�he == 0.0f) {
						if (mainActivity.schwebeflugSpeichern()) {
							Log.i(TAG,
									"Flugbefehl ohne Bewegung --> nicht beachtet");
						} else {
							Flugbefehl flugbefehl = new Flugbefehl(left_right,
									front_back, h�he, drehwinkel);
							flugweg.addFlugbefehl(flugbefehl);
							flieg(flugbefehl);
						}
					}
				}

			}

		}

	}

	public void home() {
		fliegheim = true;
	}

	private void fliegHeim() {
		// Log.i(TAG, "Bin aufem Heimweg");
		/*
		 * wenn keine Elemente mehr im Stack sind d�rfen auch keine angefordert
		 * werden!
		 */
		if (flugweg.nochFlugbefehle().equals(0)) {
			fliegheim = false;
			// �NDERUNG flugbefehl = keinFlugbefehl;
			Log.i(TAG, "Alle Fluginformationen wurden zur�ckgeflogen");
		} else {
			try {
				Flugbefehl alterFlugbefehl = flugweg.getEinzelnenFlugbefehl();
				Flugbefehl neuerFlugbefehl = new Flugbefehl(
						alterFlugbefehl.getLeft_right_tilt() * -1,
						alterFlugbefehl.getFront_back_tilt() * -1,
						alterFlugbefehl.getVertical_speed() * -1,
						alterFlugbefehl.getAngular_speed() * -1);
				flieg(neuerFlugbefehl);

			} catch (NullPointerException e) {

				// �NDERUNG flugbefehl = keinFlugbefehl;
				Log.e(TAG, "Heimflug abgebrochen: " + e);
				fliegheim = false;

			}
		}
	}

	public void setMain(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}

	public void setFliegt(boolean fliegt) {
		this.fliegt = fliegt;
	}

	public void flieg(Flugbefehl flugbefehl) {
		try {
			drone.move(flugbefehl.getLeft_right_tilt(),
					flugbefehl.getFront_back_tilt(),
					flugbefehl.getVertical_speed(),
					flugbefehl.getAngular_speed());
			Log.i(TAG,
					"Ich fliege: re: " + flugbefehl.getLeft_right_tilt()
							+ " vor:" + flugbefehl.getFront_back_tilt()
							+ " h�he: " + flugbefehl.getVertical_speed()
							+ " dreh: " + flugbefehl.getAngular_speed());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.e(TAG, "Flugbefehl konnte nicht gesendet werden: " + e);
		}
	}

	public void setDrone(ARDrone drone) {

		this.drone = drone;
		Log.i(TAG, "Ich habe das Drohnenobjekt erhalten");
	}

	public void stackleeren() {
		flugweg.leereFlugbefehl();
		Toast.makeText(mainActivity.getContext(),
				"bisheriger Flugweg aus Speicher entfernt", Toast.LENGTH_SHORT);
	}
}
