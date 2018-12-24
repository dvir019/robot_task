/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Shooter extends PIDSubsystem {

	// Fields

	private static Shooter instance = null;

	private static final double Kp = 1;
	private static final double Ki = 1;
	private static final double Kd = 1;
	private static final double TOLERANCE = 0.05;

	public static final double TARGET_SPEED = 10;
	public static final double STOP_SPEED = 0;

	private WPI_TalonSRX talon;

	// Constructor and SingleTon

	/**
	 * The constructor of the class
	 */
	public Shooter() {
		// Intert a subsystem name and PID values here
		super("BallsShootingSubsystem", Kp, Ki, Kd);

		talon = new WPI_TalonSRX(RobotMap.SHOOTER_TALON_SRX);
		talon.setSafetyEnabled(true);
		talon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.

		setSetpoint(STOP_SPEED);
		setAbsoluteTolerance(TOLERANCE);
		enable();
	}

	/**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
	public static Shooter getInstance() {
		if (instance == null)
			instance = new Shooter();
		return instance;
	}

	// Methods

	@Override
	public void initDefaultCommand() {
	}

	@Override
	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;

		return (double) talon.getSelectedSensorPosition(0);
	}

	@Override
	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);

		talon.set(output);
	}
}
