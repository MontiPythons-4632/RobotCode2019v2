// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4632.RobotCode2019v2.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4632.RobotCode2019v2.Robot;
//import org.usfirst.frc4632.RobotCode2019v2.subsystems.Drive;
//import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc4632.RobotCode2019v2.subsystems.ClimberDrive;
import org.usfirst.frc4632.RobotCode2019v2.subsystems.ClimberLift;


public class JoystickDrive extends Command {

    // private Joystick joystick = new Joystick(0);
    
    // Constructor
    public JoystickDrive() {

  
        requires(Robot.drive);

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        
        /* drive robot */
        //System.out.println("joystick: " + Robot.oi.getForwardSpeed());
        Robot.drive.arcade(Robot.oi.getForwardSpeed(), Robot.oi.getRotation());
        if (Robot.climberLift.getBackState() == ClimberLift.RobotStates.Extended) {
            Robot.climberDrive.arcade(Robot.oi.getForwardSpeed(), Robot.oi.getRotation());
        }
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
