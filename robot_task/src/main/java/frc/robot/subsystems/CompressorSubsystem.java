/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.Compresse;

/**
 * Add your docs here.
 */
public class CompressorSubsystem extends Subsystem {

	// Fields

	private static CompressorSubsystem instance = null;
	private static final int Vcc = 5;

	private Compressor compressor;
	private AnalogInput pressureSensor;

	// Constructor and SingleTon

	/**
	 * The constructor of the class
	 */
	private CompressorSubsystem() {
		compressor = new Compressor();
		compressor.setClosedLoopControl(false);

		pressureSensor = new AnalogInput(RobotMap.PRESSURE_SENSOR);
	}

	/**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
	public static CompressorSubsystem getInstance() {
		if (instance == null)
			instance = new CompressorSubsystem();
		return instance;
	}

	// Methods

	/**
	 * Get the pressure in the compressor
	 * 
	 * @return The pressure in the compressor
	 */
	public double getPressure() {
		return 250 * (((double) pressureSensor.getValue()) / Vcc) - 25;
	}

	/**
	 * Start the compressor
	 */
	public void start() {
		compressor.start();

		// SmartDashboard
		SmartDashboard.putBoolean("Compressor", true);
	}

	/**
	 * Stop the compressor
	 */
	public void stop() {
		compressor.stop();

		// SmartDashboard
		SmartDashboard.putBoolean("Compressor", false);
	}

	/**
	 * Get the state of the compressor
	 * 
	 * @return true if it's working, else false
	 */
	public boolean isWorking() {
		return compressor.enabled();
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new Compresse());
	}
}
