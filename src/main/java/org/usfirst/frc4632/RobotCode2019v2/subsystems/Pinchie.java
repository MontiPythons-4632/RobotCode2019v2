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


import org.usfirst.frc4632.RobotCode2019v2.Robot;
import org.usfirst.frc4632.RobotCode2019v2.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class Pinchie extends Subsystem {

    // Used to specify the state of the claw
    public enum ClawPositions {
        Open,
        Closed
    }

    // Used to specify where the arm is
    public enum PinchiePositions {
        Extended,
        Retracted
    }

    // Claw States
    private ClawPositions clawCurrentPosition;
    private ClawPositions clawDesiredPosition;

    // Pinchie Position
    private PinchiePositions pinchieCurrentPosition;
    private PinchiePositions pinchieDesiredPosition;
    
    private DoubleSolenoid pinchie;
    private DoubleSolenoid claw;

    public Pinchie() {
   
        pinchie = new DoubleSolenoid(5, 4, 5);
        addChild("Pinchie",pinchie);
        claw = new DoubleSolenoid(5, 6, 7);
        addChild("Claw",claw);     

        this.clawCurrentPosition = ClawPositions.Open;
        this.clawDesiredPosition = ClawPositions.Open;
        this.pinchieCurrentPosition = PinchiePositions.Retracted;
        this.pinchieDesiredPosition = PinchiePositions.Retracted;

        // Retract Pinshie
        this.retractPinchie();
  
        // Open Claw
        this.openClaw();

    }

    // private void closeClaw(Value kreverse) {
    // }

    @Override
    public void initDefaultCommand() {
    
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        //if ( Robot.DEBUG ) {
            // System.out.println("Pinchie Periodic");
       // }


        // if ( this.clawDesiredPosition != this.clawCurrentPosition ) {
        //     System.out.println("Pinchie Claw: " + this.clawDesiredPosition);

  
        // }

        // if ( this.pinchieDesiredPosition != this.pinchieCurrentPosition ) {
        //     System.out.println("Pinchie Extender: " + this.pinchieDesiredPosition);

        //     switch (this.pinchieDesiredPosition) {
        //     case Extended:
        //         this.pinchie.set(Value.kReverse);
        //     case Retracted:
        //         this.pinchie.set(Value.kForward);
        //     default:
        //         System.out.println("No value for claw");
        //     }
        //     this.pinchieCurrentPosition = this.pinchieDesiredPosition;
        //     SmartDashboard.putString("Pinchie Position", this.pinchiePositionString());

        // }


    }

    
    public void openClaw() {
        System.out.println("Open");
        this.clawDesiredPosition = ClawPositions.Open;
        this.claw.set(Value.kReverse);
        this.clawCurrentPosition = this.clawDesiredPosition;
        SmartDashboard.putString("Claw Position", this.clawPositionString());
    }

    public void closeClaw() {
        System.out.println("Close");
        this.clawDesiredPosition = ClawPositions.Closed;
        this.claw.set(Value.kForward);
        this.clawCurrentPosition = this.clawDesiredPosition;
        SmartDashboard.putString("Claw Position", this.clawPositionString());
    }

    public void extendPinchie() {
        this.pinchieDesiredPosition = PinchiePositions.Extended;
        this.pinchie.set(Value.kReverse);
        this.pinchieCurrentPosition = this.pinchieDesiredPosition;
        SmartDashboard.putString("Pinchie Position", this.pinchiePositionString());
    }

    public void retractPinchie() {
        this.pinchieDesiredPosition = PinchiePositions.Retracted;
        this.pinchie.set(Value.kForward);
        this.pinchieCurrentPosition = this.pinchieDesiredPosition;
        SmartDashboard.putString("Pinchie Position", this.pinchiePositionString());
    }

    public String clawPositionString() {

            switch (this.clawCurrentPosition) {
                case Open:
                    return "Open";
                case Closed:   
                    return "Closed";
                default: 
                    return "Unknown";
            }
    }

    public String pinchiePositionString() {

        switch (this.pinchieCurrentPosition) {
            case Extended:
                return "Extended";
            case Retracted:   
                return "Retracted";
            default: 
                return "Unknown";
        }
}
}

