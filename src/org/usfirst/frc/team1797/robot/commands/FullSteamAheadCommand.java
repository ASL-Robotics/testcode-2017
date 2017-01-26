package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.RobotMap;
import org.usfirst.frc.team1797.robot.util.Util;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FullSteamAheadCommand extends Command {

    public FullSteamAheadCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Full steam ahead!");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double x = RobotMap.joystick.getRawAxis(1);
		RobotMap.zero.set(Util.getMotorOutput(x));
		RobotMap.one.set(Util.getMotorOutput(x));
		RobotMap.two.set(Util.getMotorOutput(x));
		RobotMap.three.set(Util.getMotorOutput(x));
		RobotMap.four.set(Util.getMotorOutput(x));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
