package frc.robot.utils;

public class Methods {
	private static final double MAX_SPEED = 1.0;
	private static final double MIN_SPEED = -1.0;

	public static double normalizeSpeed(double speed) {
		if (speed > MAX_SPEED)
			speed = MAX_SPEED;
		else if (speed < MIN_SPEED)
			speed = MIN_SPEED;
		return speed;
	}
}