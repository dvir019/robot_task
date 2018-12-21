/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.DoubleSolCommand;
import frc.robot.commands.GearGripperCommand;
import frc.robot.subsystems.GearsSubsystem;
import frc.robot.subsystems.ShifterSubsystem;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	// Fields

	private static OI instance = null;

	private XboxController xbox;
	private Joystick joystick;

	private JoystickButton shifterButton;
	private JoystickButton gearIn;
	private JoystickButton gearOut;
	private JoystickButton gearPush;

	// Constructor and SingleTon

	/**
	 * The constructor of the class
	 */
	private OI() {
		joystick = new Joystick(RobotMap.JOYSTICK);
		xbox = new XboxController(RobotMap.XBOX);

		shifterButton = new JoystickButton(joystick, 1);
		shifterButton.whenPressed(new DoubleSolCommand(ShifterSubsystem.getInstance()));

		gearIn = new JoystickButton(xbox, 1);  // A
		gearIn.whileHeld(new GearGripperCommand(true));

		gearOut = new JoystickButton(xbox, 2);  // B
		gearOut.whileHeld(new GearGripperCommand(false));

		gearPush = new JoystickButton(xbox, 3);  // X
		gearPush.whenPressed(new DoubleSolCommand(GearsSubsystem.getInstance()));
	}

	/**
	 * SingleTon for the class
	 * 
	 * @return An instance of the class
	 */
	public static OI getInstance() {
		if (instance == null)
			instance = new OI();
		return instance;
	}

	// Methods

	/**
	 * Get the X axis of the joystick
	 * 
	 * @return The X axis of the joystick
	 */
	public double getJoystickX() {
		return -joystick.getX();
	}

	/**
	 * Get the Z axis of the joystick
	 * 
	 * @return The Z axis of the joystick
	 */
	public double getJoystickZ() {
		return joystick.getZ();
	}
}
