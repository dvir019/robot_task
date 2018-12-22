/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;
import frc.robot.classes.Methods;

/**
 * Add your docs here.
 */
public class Shooter extends PIDSubsystem {

	// Fields

	private static Shooter instance = null;

	private static final double Kp = 1;
	private static final double Ki = 1;
	private static final double Kd = 10;
	private static final double TARGET_SPEED = 1;

	private Spark spark;
	private Encoder encoder;

	// Constructor and SingleTon

	/**
	 * The constructor of the class
	 */
	public Shooter() {
		// Intert a subsystem name and PID values here
		super("BallsShootingSubsystem", Kp, Ki, Kd);
		
		spark = new Spark(RobotMap.SHOOTER_SPARK);
		encoder = new Encoder(RobotMap.SHOOTER_ENCODER_1, RobotMap.SHOOTER_ENCODER_2);

		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.

		setSetpoint(TARGET_SPEED);
		setAbsoluteTolerance(0.05);
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

	public void start(){
		enable();
	}

	public void stop(){
		disable();
		spark.set(0.0);
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	@Override
	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;

		return (double)encoder.get();
	}

	@Override
	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);

		spark.set(Methods.normalizeSpeed(output));
	}
}
