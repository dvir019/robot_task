/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;
import frc.robot.classes.Methods;

/**
 * Add your docs here.
 */
public class BallsCollector extends DoubleSolSubsystem {

	// Fields

	private static BallsCollector instance = null;

	private Spark spark;

	// Constructor and SingleTon

	/**
	 * The constructor of the class
	 */
	private BallsCollector() {
		super(RobotMap.BALLS_COLLECTOR_OPEN, RobotMap.BALLS_COLLECTOR_CLOSE);

		spark = new Spark(RobotMap.BALLS_COLLECTOR_SPARK);
	}

	/**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
	public static BallsCollector getInstance() {
		if (instance == null)
			instance = new BallsCollector();
		return instance;
	}

	// Methods

	/**
	 * Set the speed of the spark
	 * @param speed The new speed
	 */
	public void setSpark(double speed) {
		spark.set(Methods.normalizeSpeed(speed));
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
