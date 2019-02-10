// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4632.RobotCode2019v2.subsystems;

import org.usfirst.frc4632.RobotCode2019v2.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.DoubleSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class ClimberLift extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private DoubleSolenoid front;
    private DoubleSolenoid back;
    private DoubleSolenoid dummy1;
    private DoubleSolenoid dummy2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public enum RobotStates {
        Up,
        Down,
        Moving
    }
    private RobotStates frontCurrentState;
    private RobotStates frontDesiredState;
    private RobotStates backCurrentState;
    private RobotStates backDesiredState;

    public ClimberLift() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        front = new DoubleSolenoid(5, 0, 1);
        addChild("Front",front);
        
        back = new DoubleSolenoid(5, 2, 3);
        addChild("Back",back);
        
        dummy1 = new DoubleSolenoid(5, 4, 5);
        addChild("dummy1",dummy1);

        dummy2 = new DoubleSolenoid(5, 6, 7);
        addChild("dummy2",dummy2);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        this.holdAll();
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

        // Check to see if there is a change in state for the Back piston
        if ( this.backDesiredState != this.backCurrentState ) {
            switch (this.backDesiredState) {
            case Up:
                this.back.set(Value.kForward);
            case Down:
                this.back.set(Value.kReverse);
            default:
                System.out.println("No value for back");
            }
            this.backCurrentState = this.backDesiredState;

        }

        // Check id there is a change in state for the FrontPiston
        if ( this.frontDesiredState != this.frontCurrentState ) {
            switch (this.frontDesiredState) {
            case Up:
                this.front.set(Value.kForward);
            case Down:
                this.front.set(Value.kReverse);
            default:
                System.out.println("No value for front");
            }
            this.backCurrentState = this.frontDesiredState;
        }   

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void raiseRobot() {

        this.raiseFront();
        this.raiseBack();
    }

    public void lowerRobot() {
        this.lowerFront();
        this.lowerBack();
    }

    public void raiseFront() {
         this.frontDesiredState = RobotStates.Up;
    }
    public void raiseBack() {
        this.backDesiredState = RobotStates.Up;
    }

    public void lowerFront() {
        this.frontDesiredState = RobotStates.Down;
    }
    public void lowerBack() {
        this.backDesiredState = RobotStates.Down;
    }

    public void holdAll() {
        this.lowerFront();
        this.lowerBack();
        this.dummy1.set(Value.kReverse);
        this.dummy2.set(Value.kReverse);
    }

    public RobotStates frontState() {
        return this.frontCurrentState;
    }
 
    public RobotStates backState() {
        return this.backCurrentState;
    }
}

