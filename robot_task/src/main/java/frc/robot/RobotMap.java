/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {

	// Chassis - PWM
	public static final int TOP_RIGHT_TALON = 0;
	public static final int TOP_LEFT_TALON = 1;
	public static final int BOTTOM_RIGHT_TALON = 2;
	public static final int BOTTOM_LEFT_TALON = 3;

// ********************************************************************************

	// ShifterSubsystem - PCM
	public static final int SHIFTER_OPEN_PORT = 0;
	public static final int SHIFTER_CLOSE_PORT = 1;

// ********************************************************************************

	// CompressorSubsystem - AI
	public static final int PRESSURE_SENSOR = 0;

// ********************************************************************************

	// GearsSubsystem - PWM
	public static final int GEARS_SPARK_PORT = 4;

	// GearsSubsystem - PCM
	public static final int GEARS_OPEN_PORT = 3;
	public static final int GEARS_CLOSE_PORT = 4;

	// GearsSubsystem - DIO
	public static final int GEARS_SWITCH_PORT = 1;

// ********************************************************************************

	// ElevatorSubsystem - PWM
	public static final int ELEVATOR_TALON_1 = 5;
	public static final int ELEVATOR_TALON_2 = 6;

	// ElevatorSubsystem - PCM
	public static final int ELEVATOR_SOL_OPEN=5;
	public static final int ELEVATOR_SOL_CLOSE = 6;

	// ElevatorSubsystem - DIO
	public static final int ELEVATOR_UPPER_SWITCH = 2;
	public static final int ELEVATOR_LOWER_SWITCH = 3;

// ********************************************************************************

	// BallsShootingSubsystem - PWM
	public static final int SHOOTER_TALON_SRX = 7;

	// BallsShootingSubsystem - DIO
	public static final int SHOOTER_ENCODER_1 = 4;
	public static final int SHOOTER_ENCODER_2 = 5;

// ********************************************************************************
	
		// Shuffler - PWM
		public static final int SHUFFLER_SPARK = 8;

// ********************************************************************************
	
		// BallsCollector - PWM
		public static final int BALLS_COLLECTOR_SPARK = 9;

		// BallsCollector - PCM
		public static final int BALLS_COLLECTOR_OPEN = 7;
		public static final int BALLS_COLLECTOR_CLOSE = 8;

// ********************************************************************************

	// OI - Driver station
	public static final int JOYSTICK = 1;
	public static final int XBOX = 2;
}
