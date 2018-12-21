/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class GearsSubsystem extends DoubleSolSubsystem {

	// Fields

	private static GearsSubsystem instance = null;
	private static final double MAX_SPEED = 1.0;
	private static final double MIN_SPEED = -1.0;

	private DigitalInput microSwitch;
	private Spark spark;

	// Constructor and SingleTon

	/**
	 * The constructor of the class
	 */
	private GearsSubsystem() {
		super(RobotMap.GEARS_OPEN_PORT, RobotMap.GEARS_CLOSE_PORT);

		microSwitch = new DigitalInput(RobotMap.GEARS_SWITCH_PORT);
		spark = new Spark(RobotMap.GEARS_SPARK_PORT);
		spark.setSafetyEnabled(true);
	}

	/**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
	public static GearsSubsystem getInstance() {
		if (instance == null)
			instance = new GearsSubsystem();
		return instance;
	}

	// Methods

	/**
	 * Get the state of the micro-switch.
	 * In addition, put it in the SmartDashboard.
	 * 
	 * @return The state of the micro-switch
	 */
	public boolean getSwitch() {
		boolean state = microSwitch.get();
		SmartDashboard.putBoolean("Gear's switch", state);
		return state;
	}

	/**
	 * Set the speed of the spark
	 * 
	 * @param speed The new speed
	 */
	public void setSpark(double speed) {
		if (speed > MAX_SPEED)
			speed = MAX_SPEED;
		else if (speed < MIN_SPEED)
			speed = MIN_SPEED;
		spark.set(speed);
	}

	@Override
	public void initDefaultCommand() {
	}
}
