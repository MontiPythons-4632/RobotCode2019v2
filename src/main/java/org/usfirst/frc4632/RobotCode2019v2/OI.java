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

import org.usfirst.frc4632.RobotCode2019v2.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc4632.RobotCode2019v2.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // USe these constants to modify speed parameters
    public static final double slow = 0.5;
    public static final double normal = 0.7;
    public static final double fast = 0.8;

    // Store the current Sensitivity
    //private double sensitivity = OI.normal;

    Joystick driveStick = new Joystick(0);
	Button button1 = new JoystickButton(driveStick, 1),
			button2 = new JoystickButton(driveStick, 2),
			button3 = new JoystickButton(driveStick, 3),
			button4 = new JoystickButton(driveStick, 4),
			button5 = new JoystickButton(driveStick, 5),
			button6 = new JoystickButton(driveStick, 6),
			button7 = new JoystickButton(driveStick, 7),
			button8 = new JoystickButton(driveStick, 8),
			button9 = new JoystickButton(driveStick, 9),
			button10 = new JoystickButton(driveStick, 10),
			button11 = new JoystickButton(driveStick, 11);

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("PinchieOpen", new PinchieOpen());
        SmartDashboard.putData("PinchieClose", new PinchieClose());
        SmartDashboard.putData("PinchieOpen", new PinchieExtend());
        SmartDashboard.putData("PinchieClose", new PinchieRetract());
        SmartDashboard.putData("Raise Robot", new RaiseRobot());
        SmartDashboard.putData("Lower Robot", new LowerRobot());
        SmartDashboard.putData("Hold Robot", new HoldRobot());

        SmartDashboard.putData("ClimberRaiseFront", new ClimberRaiseFront());
        SmartDashboard.putData("ClimberLowerFront", new ClimberLowerFront());
        SmartDashboard.putData("ClimberRaiseBack", new ClimberRaiseBack());
        SmartDashboard.putData("ClimberLowerBack", new ClimberLowerBack());

        SmartDashboard.putData("ClimberMove", new ClimberMove());
        // SmartDashboard.putData("ElevatorRaiseBottom", new ElevatorRaiseBottom());
        // SmartDashboard.putData("ElevatorLowerBottom", new ElevatorLowerBottom());
        // SmartDashboard.putData("ElevatorRaiseTop", new ElevatorRaiseTop());
        // SmartDashboard.putData("ElevatorLowerTop", new ElevatorLowerTop());
        SmartDashboard.putNumber("JoyStick Speed", driveStick.getY());
        SmartDashboard.putNumber("JoyStick Direction", driveStick.getX());
 
        // Provide a command for Button 1
        //button1.whenPressed();

        // Provide a command for Button 4
        // button4.whenPressed();

        // Provide a command for Button 5
        // button5.whenPressed();

        // Provide a command for Button 6
        button6.whenPressed(new RaiseRobot());
		
        // Provide a command for Button 7
		button7.whenPressed(new LowerRobot());

          // Provide a command for Button 8
		// button8.whenPressed(;

        // Provide a command for Button 9
        // button9.whenPressed();

        // Provide a command for Button 10
        button10.whenPressed(new ClimberLowerBack());

        // Provide a command for Button 11
        button11.whenPressed(new ClimberLowerFront());


    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriveStick() {
        return driveStick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

    // Provide the current X value
    public double getRotation() {

        double x = this.driveStick.getX();

        // Deadband for joystick
        if (Math.abs(x) < 0.10) {
            x = 0;
        }

        return x * this.getSensitivity();
    }

    public double getForwardSpeed() {

        double y = this.driveStick.getY();

        // Deadband for joystick
        if (Math.abs(y) < 0.10) {
            y = 0;
        }
        return y * this.getForwardSpeed() * -1;
    }

    public double getSensitivity() {

        double sensitivity = OI.normal;

        if ( this.button2.get() ) {
            sensitivity = OI.slow;
        } else if ( this.button3.get() ) {
            sensitivity = OI.fast;
        }
    
        return sensitivity;
    }
}

