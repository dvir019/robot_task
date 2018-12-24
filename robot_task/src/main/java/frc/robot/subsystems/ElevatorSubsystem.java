/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ElevatorSubsystem extends DoubleSolSubsystem {

	// Fields

	private static ElevatorSubsystem instance = null;

	private WPI_TalonSRX talon1;
	private WPI_TalonSRX talon2;
	private DigitalInput upperSwitch;
	private DigitalInput lowerSwitch;

	// Constructor and SingleTon

	/**
	 * The constructor of the class
	 */
	private ElevatorSubsystem() {
		super(RobotMap.ELEVATOR_SOL_OPEN, RobotMap.ELEVATOR_SOL_CLOSE);

		talon1 = new WPI_TalonSRX(RobotMap.ELEVATOR_TALON_1);
		talon1.setSafetyEnabled(true);
		talon1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);

		talon2 = new WPI_TalonSRX(RobotMap.ELEVATOR_TALON_2);
		talon2.setSafetyEnabled(true);

		upperSwitch = new DigitalInput(RobotMap.ELEVATOR_UPPER_SWITCH);
		lowerSwitch = new DigitalInput(RobotMap.ELEVATOR_LOWER_SWITCH);

		// SmartDashboard
		SmartDashboard.putBoolean("Upper elevator switch", upperSwitch.get());
		SmartDashboard.putBoolean("Lower elevator switch", lowerSwitch.get());
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
	 * 
	 * @param speed The new speed
	 */
	public void set(double speed) {
		talon1.set(speed);
		talon2.set(speed);
	}

	/**
	 * Reset The encoder
	 */
	public void resetEncoder(){
		talon1.setSelectedSensorPosition(0, 0, 0);
	}

	@Override
	public void initDefaultCommand() {

	}
}
