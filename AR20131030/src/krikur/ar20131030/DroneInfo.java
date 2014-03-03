package krikur.ar20131030;

import java.util.List;

import android.util.Log;

import com.codeminders.ardrone.NavData;
import com.codeminders.ardrone.NavDataListener;
import com.codeminders.ardrone.data.navdata.ControlAlgorithm;
import com.codeminders.ardrone.data.navdata.CtrlState;
import com.codeminders.ardrone.data.navdata.FlyingState;
import com.codeminders.ardrone.data.navdata.Mode;
import com.codeminders.ardrone.data.navdata.vision.VisionTag;

public class DroneInfo implements NavDataListener {
	private static final String TAGlog = "logINFO";
	private NavData nd = null;
	private Schnittstelle schnittstelle;

	public DroneInfo(Schnittstelle schnittstelle) {
		this.schnittstelle = schnittstelle;
	}

	public void gibInfo() {

		if (nd != null) {
			Log.i(TAGlog, "BatterieStatus: " + nd.getBattery());
			Log.i(TAGlog, "Batterie zu leer: " + nd.isBatteryTooLow());

			Log.i(TAGlog, "Altitude in Meter: " + nd.getAltitude());

			Log.i(TAGlog, "Longitude: " + nd.getLongitude());
			Log.i(TAGlog, "Pitch in Grad: " + nd.getPitch());
			Log.i(TAGlog, "Roll in Grad: " + nd.getRoll());
			Log.i(TAGlog, "Yaw in Grad: " + nd.getYaw());
			Log.i(TAGlog, "Sequence: " + nd.getSequence());
			Log.i(TAGlog, "Vx: " + nd.getVx());
			// wieso gibts kein y?
			Log.i(TAGlog, "Vz: " + nd.getVz());
			Log.i(TAGlog, "AngelsOutOufRange: " + nd.isAngelsOutOufRange());
			Log.i(TAGlog,
					"CommunicationProblem: "
							+ nd.isCommunicationProblemOccurred());
			Log.i(TAGlog, "WatchdogDelay: " + nd.isControlWatchdogDelayed());
			Log.i(TAGlog, "ControlReceived: " + nd.isControlReceived());
			Log.i(TAGlog, "fliegt: " + nd.isFlying());
			Log.i(TAGlog, "zu viel Wind: " + nd.isTooMuchWind());

		}
	}

	@Override
	public void navDataReceived(NavData nd) {
		this.nd = nd;
		/* könnte Aufrufe bei Start und landen ersetzen */
		// schnittstelle.setFliegt(nd.isFlying());
	}
}
