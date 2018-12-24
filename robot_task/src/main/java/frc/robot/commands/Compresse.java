/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.CompressorSubsystem;

public class Compresse extends Command {

	// Fields

	private static final double MIN_PRESSURE = 40.0;
	private static final double MAX_PRESSURE = 120.0;

	private CompressorSubsystem compressorSubsystem;

	public Compresse() {
		compressorSubsystem = CompressorSubsystem.getInstance();
		requires(compressorSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	/**
	 * Turn on and off the compressor: Turn on if pressure below/equal MIN_PRESSURE
	 * and the compressor is closed Turn off if pressure under/equal MAX_PRESSURE
	 * and the compressor is open
	 */
	@Override
	protected void execute() {
		double pressure = compressorSubsystem.getPressure();
		boolean working = compressorSubsystem.isWorking();
		if (pressure >= MAX_PRESSURE && working)
			compressorSubsystem.stop();
		else if (pressure <= MIN_PRESSURE && !working)
			compressorSubsystem.start();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		compressorSubsystem.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
