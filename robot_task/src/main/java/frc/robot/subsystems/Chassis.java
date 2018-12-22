/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.TeleDrive;

/**
 * Add your docs here.
 */
public class Chassis extends Subsystem {

	// Fields

	private static Chassis instance = null;

	private WPI_TalonSRX topLeftTalon;
	private WPI_TalonSRX topRightTalon;
	private WPI_TalonSRX bottomLeftTalon;
	private WPI_TalonSRX bottomRightTalon;
	private SpeedControllerGroup leftTalons;
	private SpeedControllerGroup rightTalons;
	private DifferentialDrive differentialDrive;

	// Constructor and SingleTon

	/**
	 * The constructor of the class
	 */
	private Chassis() {
		topLeftTalon = new WPI_TalonSRX(RobotMap.TOP_LEFT_TALON);
		topLeftTalon.setSafetyEnabled(true);
		topLeftTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		topRightTalon = new WPI_TalonSRX(RobotMap.TOP_RIGHT_TALON);
		topRightTalon.setSafetyEnabled(true);
		topRightTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		bottomLeftTalon = new WPI_TalonSRX(RobotMap.BOTTOM_LEFT_TALON);
		bottomLeftTalon.setSafetyEnabled(true);
		bottomLeftTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		bottomRightTalon = new WPI_TalonSRX(RobotMap.BOTTOM_RIGHT_TALON);
		bottomRightTalon.setSafetyEnabled(true);
		bottomRightTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

		leftTalons = new SpeedControllerGroup(topLeftTalon, topRightTalon);
		rightTalons = new SpeedControllerGroup(bottomLeftTalon, bottomRightTalon);

		differentialDrive = new DifferentialDrive(leftTalons, rightTalons);
		
		smartDashboard();
	}

	/**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
	public static Chassis getInstance() {
		if (instance == null)
			instance = new Chassis();
		return instance;
	}

	// Methods

	/**
	 * Set the speed and the rotation to the arcadeDrive
	 * @param spped The new speed
	 * @param rotation The new rotation
	 */
	public void set(double spped, double rotation) {
		differentialDrive.arcadeDrive(spped, rotation);
		smartDashboard();
	}

	/**
	 * Update the encoders in the smartDashboard
	 */
	private void smartDashboard(){
		SmartDashboard.putNumber("Top Left Encoder", (double) topLeftTalon.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Top Right Encoder", (double) topRightTalon.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Bottom Left Encoder", (double) bottomLeftTalon.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Bottom Right Encoder", (double) bottomRightTalon.getSelectedSensorPosition(0));
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new TeleDrive());
	}

}
