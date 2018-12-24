/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorCommand extends Command {

	// Fields

	private ElevatorSubsystem elevatorSubsystem;

	public ElevatorCommand() {
		elevatorSubsystem = ElevatorSubsystem.getInstance();
		requires(elevatorSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double speed = handleSwitches();
		handleSol(speed);
		elevatorSubsystem.set(speed);
	}

	/**
	 * Determine the new speed for the elevator, based on the state of the switches
	 * 
	 * @return The new speed
	 */
	private double handleSwitches() {
		boolean lowerSwitch = elevatorSubsystem.getLowerSwitch();
		boolean upperSwitch = elevatorSubsystem.getUpperSwitch();
		double speed = Robot.oi.getXboxRightJoystickY();

		if (!lowerSwitch && !upperSwitch) // They both open
			return speed;
		if (upperSwitch) // Upper switch closed
			return speed > 0.0 ? 0.0 : speed;
		// Lower switch closed
		elevatorSubsystem.resetEncoder();
		return speed < 0 ? 0.0 : speed;
	}

	/**
	 * Open or close the piston, according to the new speed
	 * 
	 * @param speed The new speed
	 */
	private void handleSol(double speed) {
		boolean open = elevatorSubsystem.isOpen();
		if ((open && speed == 0.0) || (!open && speed != 0.0))
			elevatorSubsystem.swap();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		handleSol(0.0);
		elevatorSubsystem.set(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
