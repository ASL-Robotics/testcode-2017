package org.usfirst.frc.team1797.robot.util;

import org.usfirst.frc.team1797.robot.RobotMap;

public class Util {
	/**
	 * Returns the motor output with the appropriate cutoff for the input value and taking into account the dead man's switch
	 * @param input The input value for the motor
	 * @return The output value, but only if above the cutoff and the A button on the xbox controller is pressed
	 */
	public static double getMotorOutput(double input) {
		return (Math.abs(input) > RobotMap.MOTOR_CUTOFF && RobotMap.joystick.getRawButton(0)) ? input : 0;
	}
}
