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

import org.usfirst.frc4632.RobotCode2019v2.Robot;
import org.usfirst.frc4632.RobotCode2019v2.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
    //import edu.wpi.first.wpilibj.AnalogGyro;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */

public class NineDOF extends Subsystem {

    private PigeonIMU pigeon;

    // Variables for Sensor
    double curX;
    double curY;
    double curZ;
    double curCompass;

    public NineDOF() {

        double initialAngle = 0.0;
        int timeout = 0;
        pigeon = new PigeonIMU(0);
        
        pigeon.configFactoryDefault();

        pigeon.setYaw(initialAngle);
        pigeon.setFusedHeading(initialAngle, timeout);

    }

    @Override
    public void initDefaultCommand() {

    }

    @Override
    public void periodic() {
        if ( Robot.DEBUG ) {
            System.out.println("Starting NineDOF");
        }

        // Put code here to be run every loop

        double[] xyz_dps = new double[3];
        double[] ypr_deg = new double[3];

        this.pigeon.getRawGyro(xyz_dps);
        this.pigeon.getYawPitchRoll(ypr_deg);
        SmartDashboard.putNumber("Compass",this.pigeon.getAbsoluteCompassHeading());
        this.curX = ypr_deg[0] % 360;
        this.curY = ypr_deg[1];
        this.curZ = ypr_deg[2];

        SmartDashboard.putNumber("Direction", this.curX);
        SmartDashboard.putNumber("Pitch", this.curY);
        SmartDashboard.putNumber("Yaw", this.curZ);
    
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public String getStatus() {

        PigeonIMU.GeneralStatus genStatus = new PigeonIMU.GeneralStatus();
        this.pigeon.getGeneralStatus(genStatus);
        PigeonIMU.PigeonState state = this.pigeon.getState();
    
        SmartDashboard.putString("Pigeon Status", state.toString());
    
        return state.toString();
    }

    public double getXDirection() {

        return this.curX;
    }

    public double getYDirection() {

        return this.curY;
    }
    
    public double getZDirection() {

        return this.curZ;
    }
    
    public void tare() {
        this.pigeon.setYaw(0.0);
        this.pigeon.setFusedHeading(0.0);

        
    }
}

