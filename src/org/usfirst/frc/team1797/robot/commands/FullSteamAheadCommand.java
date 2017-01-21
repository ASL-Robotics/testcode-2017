package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.RobotMap;

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
		RobotMap.zero.set((Math.abs(x) > RobotMap.MOTOR_CUTOFF) ? x : 0);
		RobotMap.one.set((Math.abs(x) > RobotMap.MOTOR_CUTOFF) ? x : 0);
		RobotMap.two.set((Math.abs(x) > RobotMap.MOTOR_CUTOFF) ? x : 0);
		RobotMap.three.set((Math.abs(x) > RobotMap.MOTOR_CUTOFF) ? x : 0);
		RobotMap.four.set((Math.abs(x) > RobotMap.MOTOR_CUTOFF) ? x : 0);
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
