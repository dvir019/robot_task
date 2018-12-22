/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ElevatorSubsystem extends DoubleSolSubsystem {

	// Fields

	private static ElevatorSubsystem instance = null;

	private WPI_TalonSRX talon;
	private DigitalInput upperSwitch;
	private DigitalInput lowerSwitch;
	private Encoder encoder;

	// Constructor and SingleTon

	/**
	 * The constructor of the class
	 */
	private ElevatorSubsystem() {
		super(RobotMap.ELEVATOR_SOL_OPEN, RobotMap.ELEVATOR_SOL_CLOSE);

		talon = new WPI_TalonSRX(RobotMap.ELEVATOR_TALON);
		talon.setSafetyEnabled(true);

		upperSwitch = new DigitalInput(RobotMap.ELEVATOR_UPPER_SWITCH);
		lowerSwitch = new DigitalInput(RobotMap.ELEVATOR_LOWER_SWITCH);

		encoder = new Encoder(RobotMap.ELEVATOR_ENCODER_1, RobotMap.ELEVATOR_ENCODER_2);
	}

	/**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
	public static ElevatorSubsystem getInstance() {
		if (instance == null)
			instance = new ElevatorSubsystem();
		return instance;
	}

	// Methods

	/**
	 * Get the state of the upper switch.
	 * In addition, put it in the SmartDashboard.
	 * 
	 * @return true if it closed, else false
	 */
	public boolean getUpperSwitch() {
		boolean state = upperSwitch.get();
		SmartDashboard.putBoolean("Upper elevator switch", state);
		return state;
	}

	/**
	 * Get the state of the lower switch.
	 * In addition, put it in the SmartDashboard.
	 * 
	 * @return true if it closed, else false
	 */
	public boolean getLowerSwitch() {
		boolean state = lowerSwitch.get();
		SmartDashboard.putBoolean("Lower elevator switch", state);
		return state;
	}

	/**
	 * Set the speed of the talon
	 * @param speed The new speed
	 */
	public void set(double speed) {
		talon.set(speed);
	}

	/**
	 * Reset The encoder
	 */
	public void resetEncoder(){
		encoder.reset();
	}

	@Override
	public void initDefaultCommand() {

	}
}
