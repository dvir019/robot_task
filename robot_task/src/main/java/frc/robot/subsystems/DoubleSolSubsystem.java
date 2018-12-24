/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.utils.DoubleSol;

/**
 * Add your docs here.
 */
public abstract class DoubleSolSubsystem extends Subsystem {

	// Fields

	private DoubleSol doubleSol;

	// Constructor

	/**
	 * The constructor of the class
	 */
	protected DoubleSolSubsystem(int openPort, int closePort) {
		doubleSol = new DoubleSol(openPort, closePort);
	}


	// Methods

	/**
	 * Swap the doubleSol's state
	 */
	public void swap(){
		doubleSol.swap();
	}

	/**
	 * Get if the sol is open or not
	 * @return True if it's open, else false
	 */
	public boolean isOpen(){
		return doubleSol.isOpen();
	}

	@Override
	public void initDefaultCommand() {
	}
}
