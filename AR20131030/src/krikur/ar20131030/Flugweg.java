package krikur.ar20131030;

import java.io.IOException;
import java.util.Stack;

import com.codeminders.ardrone.ARDrone;

public class Flugweg {
	private static Stack<Flugbefehl> flugwegObjekte = new Stack<Flugbefehl>();
	private static Flugbefehl flugbefehl;


	public Flugweg() {

	}

	public void addFlugbefehl(Flugbefehl flugbefehl) {
		flugwegObjekte.push(flugbefehl);
	}

	public static void home(ARDrone drone) {
		while (!flugwegObjekte.empty()) {
			flugbefehl = flugwegObjekte.pop();
			try {
				drone.move(flugbefehl.getLeft_right_tilt(),
						flugbefehl.getFront_back_tilt(),
						flugbefehl.getVertical_speed(),
						flugbefehl.getAngular_speed());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
