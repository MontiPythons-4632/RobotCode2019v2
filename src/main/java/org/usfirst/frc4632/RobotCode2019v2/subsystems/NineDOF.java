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


import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
    //import edu.wpi.first.wpilibj.AnalogGyro;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */

public class NineDOF extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
  
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private PigeonIMU pigeon;

    // Variables for Sensor
    double curX;
    double curY;
    double curZ;
    double curCompass;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public NineDOF() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    
        pigeon = new PigeonIMU(0);
    
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand()); 
        
        pigeon.configFactoryDefault();

    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

        double[] xyz_dps = new double[3];
        double[] ypr_deg = new double[3];

        this.pigeon.getRawGyro(xyz_dps);
        this.pigeon.getYawPitchRoll(ypr_deg);
        SmartDashboard.putNumber("Compass",this.pigeon.getAbsoluteCompassHeading());
        this.curX = ypr_deg[0] % 360;
        this.curY = ypr_deg[1] % 360;
        this.curZ = ypr_deg[2] % 360;

        SmartDashboard.putNumber("xDirection", Math.round(this.curX*100)/100);
        SmartDashboard.putNumber("yDirection", Math.round(this.curY*100)/100);
        SmartDashboard.putNumber("zDirection", Math.round(this.curZ*100)/100);
    
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public double getXDirection() {

        return this.curX;
    }

    public double getYDirection() {

        return this.curY;
    }
    
    public double getZDirection() {

        return this.curZ;
    }
    
    
}

