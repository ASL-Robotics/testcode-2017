
package org.usfirst.frc.team1797.robot;

import org.usfirst.frc.team1797.robot.commands.CrossfireCommand;
import org.usfirst.frc.team1797.robot.commands.DualfireCommand;
import org.usfirst.frc.team1797.robot.commands.FullSteamAheadCommand;
import org.usfirst.frc.team1797.robot.commands.TankDriveCommand;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	Command command;
	SendableChooser<Command> chooser = new SendableChooser<>();
	CameraServer cameraServer;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		// Setup the SendableChooser
		chooser.addDefault("Crossfire", new CrossfireCommand());
		chooser.addObject("Dualfire", new DualfireCommand());
		chooser.addObject("Tank Drive", new TankDriveCommand());
		chooser.addObject("Full Steam Ahead", new FullSteamAheadCommand());
		SmartDashboard.putData("Auto mode", chooser);
		
		// Initialize the RobotMap
		RobotMap.init();
		
		// Setup the two cameras
		cameraServer = CameraServer.getInstance();
		cameraServer.startAutomaticCapture("Front Camera", 0);
		cameraServer.startAutomaticCapture("Back Camera", 1);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		if (command != null)
				command.cancel();
	}

	@Override
	public void disabledPeriodic() {
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		if (command != null)
			command.cancel();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		command = chooser.getSelected();
		command.start();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		
	}
}
