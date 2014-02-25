package krikur.ar20131030;

import java.util.List;

import com.codeminders.ardrone.NavData;
import com.codeminders.ardrone.NavDataListener;
import com.codeminders.ardrone.data.navdata.ControlAlgorithm;
import com.codeminders.ardrone.data.navdata.CtrlState;
import com.codeminders.ardrone.data.navdata.FlyingState;
import com.codeminders.ardrone.data.navdata.Mode;
import com.codeminders.ardrone.data.navdata.vision.VisionTag;

public class DroneInfo implements NavData {

	@Override
	public float getAltitude() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBattery() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ControlAlgorithm getControlAlgorithm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CtrlState getControlState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getLongitude() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Mode getMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getPitch() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getRoll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSequence() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getVx() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getVz() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getYaw() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAcquisitionThreadOn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isADCWatchdogDelayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAltitudeControlActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAngelsOutOufRange() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isATCodedThreadOn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBatteryTooHigh() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBatteryTooLow() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCommunicationProblemOccurred() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isControlReceived() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isControlWatchdogDelayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCutoutSystemDetected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmergency() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFlying() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGyrometersDown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMotorsDown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNavDataBootstrap() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNavDataDemoOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNavDataThreadOn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNotEnoughPower() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPICVersionNumberOK() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTimerElapsed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTooMuchWind() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTrimReceived() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTrimRunning() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTrimSucceeded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUltrasonicSensorDeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserFeedbackOn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVideoEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVideoThreadOn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisionEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FlyingState getFlyingState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VisionTag> getVisionTags() {
		// TODO Auto-generated method stub
		return null;
	}

}
