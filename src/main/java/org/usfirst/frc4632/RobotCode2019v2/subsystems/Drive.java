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
import com.ctre.phoenix.motorcontrol.Faults;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.ctre.phoenix.sensors.PigeonIMU;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */

public class Drive extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
  

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonSRX leftFront;
    private WPI_VictorSPX leftBack;
    private SpeedControllerGroup left;
    private WPI_TalonSRX rightFront;
    private WPI_VictorSPX rightBack;
    private SpeedControllerGroup right;
    private DifferentialDrive differentialDrive1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

   // private PigeonIMU pigeon;
    private Faults faults_L = new Faults();
    private Faults faults_R = new Faults();
    private String work = "";

    

    public Drive() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        leftFront = new WPI_TalonSRX(1);
        leftBack = new WPI_VictorSPX(2);
        left = new SpeedControllerGroup(leftFront, leftBack  );
        addChild("Left",left);
        
        rightFront = new WPI_TalonSRX(3);
        rightBack = new WPI_VictorSPX(4);
        right = new SpeedControllerGroup(rightFront, rightBack  );
        addChild("Right",right);
        
        
        differentialDrive1 = new DifferentialDrive(left, right);
        addChild("Differential Drive 1",differentialDrive1);
        differentialDrive1.setSafetyEnabled(true);
        differentialDrive1.setExpiration(0.1);
        differentialDrive1.setMaxOutput(1.0);

        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    
      //  pigeon = new PigeonIMU(leftFront);

        /* factory default values */
        rightFront.configFactoryDefault();
        rightBack.configFactoryDefault();
        leftFront.configFactoryDefault();
        leftBack.configFactoryDefault();

        /*
        * [4] adjust sensor phase so sensor moves positive when Talon LEDs are green
        */
        rightFront.setSensorPhase(true);
        leftFront.setSensorPhase(true);
        rightBack.setSensorPhase(true);
        leftBack.setSensorPhase(true);
        

    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        setDefaultCommand(new JoystickDrive());
        
        // Initialize Turning
        // this.isTurning = false;
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        // this.updateGyro();
        
        // if(this.isTurning) {
        //     if( java.lang.Math.abs(this.destX - this.currX) > .5 ) {
        //         if(this.initX > this.destX) {
        //             this.arcade(0.0, -1*this.normal);
        //         } 
        //         if(this.initX < this.destX) {
        //             this.arcade(0.0, this.normal);
        //         } 
        //     } else {
        //         this.isTurning = false;
        //     }
        // }

  

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void arcade(double speed, double direction) {

        /* Takes parameters and sets direction */
        this.differentialDrive1.arcadeDrive(-1*speed, direction);


        /* get sensor values */
        // double leftPos = _leftFront.GetSelectedSensorPosition(0);
        // double rghtPos = _rghtFront.GetSelectedSensorPosition(0);
        double leftVelUnitsPer100ms = leftFront.getSelectedSensorVelocity(0);
        double rghtVelUnitsPer100ms = rightFront.getSelectedSensorVelocity(0);

        work += " L:" + leftVelUnitsPer100ms + " R:" + rghtVelUnitsPer100ms;

        /*
         * drive motor at least 25%, Talons will auto-detect if sensor is out of phase
         */
        leftFront.getFaults(faults_L);
        rightFront.getFaults(faults_R);

        if (faults_L.SensorOutOfPhase) {
            work += " L sensor is out of phase";
        }
        if (faults_R.SensorOutOfPhase) {
            work += " R sensor is out of phase";
        }
    }
    
    // public void turnDeg( double degX ) {
    //     this.initX = Robot.nineDOF.getXDirection();
    //     this.destX = this.initX + degX;
    //     this.isTurning = true;
    // }


    // public void stopTurn() {
    //         this.isTurning = false;
    // }

    // public boolean isTurning() {
    //     return this.isTurning;
    // }
}

