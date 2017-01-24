package org.usfirst.frc.team1797.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.RobotMap;

/**
 *
 */
public class DualfireCommand extends Command {
	public DualfireCommand() {
		// Use requires() here to declare subsystem dependencies
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		System.out.println("Dual fire ran!");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double x = RobotMap.joystick.getRawAxis(1);
		RobotMap.zero.set((Math.abs(x) > RobotMap.MOTOR_CUTOFF && RobotMap.joystick.getRawButton(0)) ? x : 0);
		RobotMap.one.set((Math.abs(x) > RobotMap.MOTOR_CUTOFF && RobotMap.joystick.getRawButton(0)) ? x : 0);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
