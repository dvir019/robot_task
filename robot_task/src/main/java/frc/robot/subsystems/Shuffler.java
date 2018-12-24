/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.utils.Methods;

/**
 * Add your docs here.
 */
public class Shuffler extends Subsystem {

	// Fields

	private static Shuffler instance = null;

	private Spark spark;

	// Constructor and SingleTon

	/**
	 * The constructor of the class
	 */
	private Shuffler() {
		spark = new Spark(RobotMap.SHUFFLER_SPARK);
	}

	/**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
	public static Shuffler getInstance() {
		if (instance == null)
			instance = new Shuffler();
		return instance;
	}

	// Methods

	/**
	 * Set the speed of the spark
	 * @param speed The new speed
	 */
	public void set(double speed) {
		spark.set(Methods.normalizeSpeed(speed));
	}

	@Override
	public void initDefaultCommand() {
	}
}
