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

    // USe these constants to modify speed parameters
    public static final double slow = 0.6;
    public static final double normal = 0.85;
    public static final double fast = 1.0;

    // Store the current Sensitivity
    //private double sensitivity = OI.normal;

    Joystick driveStick = new Joystick(0);
	Button dsButton1 = new JoystickButton(driveStick, 1),
			dsButton2 = new JoystickButton(driveStick, 2),
			dsButton3 = new JoystickButton(driveStick, 3),
			dsButton4 = new JoystickButton(driveStick, 4),
			dsButton5 = new JoystickButton(driveStick, 5),
			dsButton6 = new JoystickButton(driveStick, 6),
			dsButton7 = new JoystickButton(driveStick, 7),
			dsButton8 = new JoystickButton(driveStick, 8),
			dsButton9 = new JoystickButton(driveStick, 9),
			dsButton10 = new JoystickButton(driveStick, 10),
            dsButton11 = new JoystickButton(driveStick, 11);
            
            
    Joystick elevatorStick = new Joystick(1);
	Button esButton1 = new JoystickButton(elevatorStick, 1),
			esButton2 = new JoystickButton(elevatorStick, 2),
			esButton3 = new JoystickButton(elevatorStick, 3),
			esButton4 = new JoystickButton(elevatorStick, 4),
			esButton5 = new JoystickButton(elevatorStick, 5),
            esButton6 = new JoystickButton(elevatorStick, 6),
            esButton7 = new JoystickButton(elevatorStick, 7),
            esButton8 = new JoystickButton(elevatorStick, 8),
            esButton9 = new JoystickButton(elevatorStick, 9),
            esButton10 = new JoystickButton(elevatorStick, 10),
            esButton11 = new JoystickButton(elevatorStick, 11);




    public OI() {
        // SmartDashboard Buttons
        // SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("PinchieOpen", new PinchieOpen());
        SmartDashboard.putData("PinchieClose", new PinchieClose());
        SmartDashboard.putData("PinchieOpen", new PinchieExtend());
        SmartDashboard.putData("PinchieClose", new PinchieRetract());
        // SmartDashboard.putData("Raise Robot", new RobotRaise());
        // SmartDashboard.putData("Lower Robot", new RobotLower());
        // SmartDashboard.putData("Auto CLimb", new RobotAutoClimb());
        // SmartDashboard.putData("All Wheel Drive", new RobotAllWheelDrive());


        // SmartDashboard.putData("FrontActuatorExtend", new FrontActuatorRaise());
        // SmartDashboard.putData("FrontActuatorRetract", new FrontActuatorLower());
        // SmartDashboard.putData("BackActuatorExtend", new BackActuatorRaise());
        // SmartDashboard.putData("BackActuatorRetract", new BackActuatorLower());

        // SmartDashboard.putData("Tare", new Tare());

        // SmartDashboard.putData("ClimberMove", new ClimberMove());
        // SmartDashboard.putData("ElevatorRaiseBottom", new ElevatorRaiseBottom());
        // SmartDashboard.putData("ElevatorLowerBottom", new ElevatorLowerBottom());
        // SmartDashboard.putData("ElevatorRaiseTop", new ElevatorRaiseTop());
        // SmartDashboard.putData("ElevatorLowerTop", new ElevatorLowerTop());
        SmartDashboard.putNumber("JoyStick Speed", driveStick.getY());
        SmartDashboard.putNumber("JoyStick Direction", driveStick.getX());
        SmartDashboard.putNumber("elevatorStick Speed", elevatorStick.getY());
        SmartDashboard.putNumber("elevatorStick Direction", elevatorStick.getX()); 
        SmartDashboard.putNumber("ElevatorTopPosition", Robot.elevator.getCurrentTopPosition());
        SmartDashboard.putNumber("ElevatorBottomPosition", Robot.elevator.getCurrentBottomPosition());
        SmartDashboard.putString("Claw Position", Robot.pinchie.clawPositionString());
        SmartDashboard.putString("Pinchie Position", Robot.pinchie.pinchiePositionString());
    

        // DriveStick Buttons
        // Provide a command for Button 1
        //dsButton1.whenPressed();

        // Provide a command for Button 4
        dsButton4.whenPressed(new PinchieOpen());

        // Provide a command for Button 5
        dsButton5.whenPressed(new PinchieClose());

        // Provide a command for Button 6
        dsButton6.whenPressed(new FrontActuatorLower());
		
        // Provide a command for Button 7
		dsButton7.whenPressed(new FrontActuatorRaise());

          // Provide a command for Button 8
		//  dsButton8.whenPressed(new RobotAutoClimb());

        // Provide a command for Button 9
        //  dsButton9.whenPressed(new RobotRaise());

        // Provide a command for Button 10
        // dsButton10.whenPressed(new BackActuatorRaise());

        // Provide a command for Button 11
        // dsButton11.whenPressed(new BackActuatorLower());

        //Elevator Stick Buttons

        //esButton1.whenPressed(new ());
        //esButton2.whenPressed(new ());
        //esButton3.whenPressed(new ());
        esButton4.whenPressed(new PinchieOpen());
        esButton5.whenPressed(new PinchieClose());

        esButton6.whenPressed(new PinchieExtend());
        esButton7.whenPressed(new PinchieRetract());

        // esButton9.whenPressed(new ElevatorPosition(1));
        // esButton10.whenPressed(new ElevatorPosition(2));
        // esButton11.whenPressed(new ElevatorPosition(3));

    }

    public Joystick getDriveStick() {
        return driveStick;
    }


// Logic for Drive Train Controls

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
        SmartDashboard.putNumber("Forward Speed", y);

        return y * this.getSensitivity();
    }

    public double getSensitivity() {

        double sensitivity = OI.normal;

        if ( this.dsButton2.get() ) {
            sensitivity = OI.slow;
        } else if ( this.dsButton3.get() ) {
            sensitivity = OI.fast;
        }
    
        return sensitivity;
    }

    // Logic for Elevator controls

    public double getElevatorSpeed() {

        // Joystick we are using flight sticks need to invert y
        double y = this.elevatorStick.getY() * -1.0;
        // Deadband for joystick
        if (Math.abs(y) < 0.10) {
            y = 0;
        }
        SmartDashboard.putNumber("Elevator Speed", y);
        return y;
    }

    

    public String getElevatorForAction() {

        if ( this.esButton1.get() ) {
            return "bottom";
        } else {
            return "top"; 
        }

        


    }

}

