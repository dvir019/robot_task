package frc.robot.utils;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * A class for one doubleSolenoid.
 */
public class DoubleSol {

	// Fields
	private DoubleSolenoid shifter;

	// Constructors
	public DoubleSol(int openPort, int closePort) {
		shifter = new DoubleSolenoid(openPort, closePort);
	}

	// Methods

	/**
	 * Switches the solenoid to a forward state
	 */
	private void forward() {
		shifter.set(Value.kForward);
	}

	/**
	 * Switches the solenoid to a forward state
	 */
	private void reverse() {
		shifter.set(Value.kReverse);
	}

	/**
	 * Get the state of the solenoid
	 * 
	 * @return The state of the solenoid
	 */
	private Value getState() {
		return shifter.get();
	}

	/**
	 * Swaps between the states of the solenoid
	 */
	public void swap() {
		if (getState() == Value.kForward)
			reverse();
		else
			forward();
	}

	/**
	 * Get if the sol is open or not
	 * @return True if it's open, else false
	 */
	public boolean isOpen(){
		return getState() == Value.kForward;
	}
}
