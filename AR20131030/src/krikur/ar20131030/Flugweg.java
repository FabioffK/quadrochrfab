package krikur.ar20131030;

import java.util.Stack;

import android.util.Log;

/**
 * *Klasse, die das Speichern des Flugweges übernimmt
 * 
 * @author xce35d6
 * 
 */
public class Flugweg {
	private static Stack<Flugbefehl> flugwegObjekte = new Stack<Flugbefehl>();
	private static Flugbefehl flugbefehl;
	private static final String TAG = "krikur_Flugweg";

	/**
	 * Schnittstelle um Flugbefehl dem FLugweg hinzuzufügen
	 * 
	 * @param flugbefehl
	 *            ist der Flugbefehl, der gespeichert wird und auf den Stack mit
	 *            den vorangegangenen Flugbefehlen gespeichert wird
	 */
	public void addFlugbefehl(Flugbefehl flugbefehl) {
		flugwegObjekte.push(flugbefehl);
	}

	/**
	 * 
	 * @return gibt den obersten Flugbefehl vom Flugweg-Stack zurück
	 */
	public Flugbefehl getEinzelnenFlugbefehl() {
		try {
			return flugwegObjekte.pop();
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 
	 * @return wieviele Flugbefehle im Stack "Flugweg" gespeichert sind
	 */
	public Integer nochFlugbefehle() {
		// Log.i(TAG, "Es gibt noch " + flugwegObjekte.size()
		// + " Flugbefehle bis home");
		return flugwegObjekte.size();
	}

	/**
	 * löscht alle Flugbefehle aus dem Stack
	 */
	public void leereFlugbefehl() {
		flugwegObjekte.clear();
		Log.i(TAG, "Flugweg wurde gelöscht!");

	}

}
