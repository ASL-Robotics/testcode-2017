package org.usfirst.frc.team1797.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.RobotMap;

/**
 *
 */
public class CrossfireCommand extends Command {
	public CrossfireCommand() {
		// Use requires() here to declare subsystem dependencies
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		System.out.println("Cross fire ran!");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		RobotMap.zero.set(RobotMap.joystick.getRawAxis(1));
		RobotMap.one.set(-RobotMap.joystick.getRawAxis(1));
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
