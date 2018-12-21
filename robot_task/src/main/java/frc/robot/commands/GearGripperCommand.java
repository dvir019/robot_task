/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.GearsSubsystem;

public class GearGripperCommand extends Command {

	// Fields
	private GearsSubsystem gearsSubsystem;
	private boolean enterGear;

	/**
	 * The constructor of the class
	 * 
	 * @param enterGear Indicate if the gear should get in (true) or out (false)
	 */
	public GearGripperCommand(boolean enterGear) {
		gearsSubsystem = GearsSubsystem.getInstance();
		requires(gearsSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		gearsSubsystem.setSpark(enterGear ? 1.0 : -1.0);
	}

	/**
	 * Checks if the micro-switch is closed or not, and if enterGear is true. If
	 * they both are, it's return true, else false.
	 * 
	 * @return True if the micro-switch is closed and enterGear is true, else false
	 */
	@Override
	protected boolean isFinished() {
		return gearsSubsystem.getSwitch() && enterGear;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		gearsSubsystem.setSpark(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
