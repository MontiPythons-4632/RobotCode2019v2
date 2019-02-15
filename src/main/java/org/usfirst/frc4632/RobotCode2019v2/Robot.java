// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4632.RobotCode2019v2;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4632.RobotCode2019v2.commands.*;
import org.usfirst.frc4632.RobotCode2019v2.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static boolean DEBUG = true;
    public static OI oi;
    public static Drive drive;
    //public static GyroScope gyroScope;
    // public static NineDOF nineDOF;

 
    public static ClimberLift climberLift;
    /*
    public static ClimberDrive climberDrive;
    */
    public static Elevator elevator;
    public static Pinchie pinchie;

    Command joystickDrive;

    enum RobotType {
        Competition,
        Test
    }

    public RobotType myType = RobotType.Test;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {

        drive = new Drive();
        //gyroScope = new GyroScope();
        // nineDOF = new NineDOF();

        climberLift = new ClimberLift();
        /*
        climberDrive = new ClimberDrive();
        */
        elevator = new Elevator();
        pinchie = new Pinchie();

     

        joystickDrive = new JoystickDrive();

        /*
        climberLift.lowerRobot();
    */

        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

        SmartDashboard.putData("Auto mode", chooser);
        SmartDashboard.putData(elevator);
        SmartDashboard.putData(climberLift);

    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();

        
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
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }

        if ( Robot.DEBUG ) {
            System.out.println("Starting teleopInit");
        }


        // if ( joystickDrive != null ) {
        //     System.out.println("Starting joystickDrive");
        //     joystickDrive.start();
        // }
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        
        
        if ( Robot.DEBUG ) {
            System.out.println("periodic teleop");
        }

        Scheduler.getInstance().run();
    }
}
