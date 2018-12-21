/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;

/**
 * Subsystem for the shifter's switching
 */
public class ShifterSubsystem extends DoubleSolSubsystem {

	// Fields

	private static ShifterSubsystem instance = null;

	// Constructor and SingleTon

	/**
	 * The constructor of the class
	 */
	private ShifterSubsystem() {
		super(RobotMap.SHIFTER_OPEN_PORT, RobotMap.SHIFTER_CLOSE_PORT);
	}

	/**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
	public static ShifterSubsystem getInstance() {
		if (instance == null)
			instance = new ShifterSubsystem();
		return instance;
	}

	// Methods

	@Override
	public void initDefaultCommand() {

	}
}
