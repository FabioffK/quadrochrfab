package krikur.ar20131030;

// Test
/**
 * 
 * @author xce35d6
 * 
 */
public class Flugbefehl {
	private float left_right_tilt;
	private float front_back_tilt;
	private float vertical_speed;
	private float angular_speed;

	/**
	 * @param left_right_tilt
	 *            The left-right tilt (aka. "drone roll" or phi angle) argument
	 *            is a percentage of the maximum inclination as configured here.
	 *            A negative value makes the drone tilt to its left, thus flying
	 *            leftward. A positive value makes the drone tilt to its right,
	 *            thus flying rightward.
	 * @param front_back_tilt
	 *            The front-back tilt (aka. "drone pitch" or theta angle)
	 *            argument is a percentage of the maximum inclination as
	 *            configured here. A negative value makes the drone lower its
	 *            nose, thus flying frontward. A positive value makes the drone
	 *            raise its nose, thus flying backward. The drone translation
	 *            speed in the horizontal plane depends on the environment and
	 *            cannot be determined. With roll or pitch values set to 0, the
	 *            drone will stay horizontal but continue sliding in the air
	 *            because of its inertia. Only the air resistance will then make
	 *            it stop.
	 * @param vertical_speed
	 *            The vertical speed (aka. "gaz") argument is a percentage of
	 *            the maximum vertical speed as defined here. A positive value
	 *            makes the drone rise in the air. A negative value makes it go
	 *            down.
	 * @param angular_speed
	 *            The angular speed argument is a percentage of the maximum
	 *            angular speed as defined here. A positive value makes the
	 *            drone spin right; a negative value makes it spin left.
	 */
	public Flugbefehl(float left_right_tilt, float front_back_tilt,
			float vertical_speed, float angular_speed) {
		this.angular_speed = angular_speed * -1;
		this.front_back_tilt = front_back_tilt * -1;
		this.left_right_tilt = left_right_tilt * -1;
		this.vertical_speed = vertical_speed * -1;
	}

	public float getLeft_right_tilt() {
		return left_right_tilt;
	}

	public float getFront_back_tilt() {
		return front_back_tilt;
	}

	public float getVertical_speed() {
		return vertical_speed;
	}

	public float getAngular_speed() {
		return angular_speed;
	}
}
