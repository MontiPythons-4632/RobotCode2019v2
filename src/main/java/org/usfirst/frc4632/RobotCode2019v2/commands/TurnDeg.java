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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4632.RobotCode2019v2.Robot;

/**
 *
 */
public class TurnDeg extends Command {

    // Store states for turning
    // For Gyro Driving
    double currX;
    double currY;
    double currZ;

    double initX;
    double destX;
    boolean isTurning;

    public TurnDeg() {
        requires(Robot.drive);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
   
    void initialize(double degX) {
        
        // Set the initial heading
        // initX = Robot.nineDOF.getZDirection();
        destX = initX + degX;
    
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

        SmartDashboard.putBoolean("Turning", this.isTurning);
        SmartDashboard.putNumber("initX", this.initX);
        SmartDashboard.putNumber("destX", this.destX);

        if(this.initX > this.destX) {
            Robot.drive.arcade(0.0, -1.0 * Robot.oi.getSensitivity());
        } 
        if(this.initX < this.destX) {
            Robot.drive.arcade(0.0,Robot.oi.getSensitivity() );
        } 
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {

        if( java.lang.Math.abs(this.destX - this.currX) > .5 ) {
            return true;
        }
        
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
