package krikur.ar20131030;

import java.io.IOException;
import java.util.Stack;

import android.support.v4.util.LogWriter;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.codeminders.ardrone.ARDrone;
import com.codeminders.ardrone.NavData;
import com.codeminders.ardrone.NavDataListener;

public class Flugweg {
	private static Stack<Flugbefehl> flugwegObjekte = new Stack<Flugbefehl>();
	private static Flugbefehl flugbefehl;
	private static final String TAG = "krikur_Flugweg";

	public void addFlugbefehl(Flugbefehl flugbefehl) {
		flugwegObjekte.push(flugbefehl);
	}

	public Flugbefehl getEinzelnenFlugbefehl() {
		try {
			return flugwegObjekte.pop();
		} catch (Exception e) {
			return null;
		}

	}

	public Integer nochFlugbefehle() {
		// Log.i(TAG, "Es gibt noch " + flugwegObjekte.size()
		// + " Flugbefehle bis home");
		return flugwegObjekte.size();
	}

	public void leereFlugbefehl() {
		flugwegObjekte.clear();
		Log.i(TAG, "Flugweg wurde gelöscht!");
		
	}

}
