/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc4632.RobotCode2019v2.commands;
import org.usfirst.frc4632.RobotCode2019v2.subsystems.Drive;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4632.RobotCode2019v2.Robot;


public class RobotDrive extends Command {

  double speed;
  double direction;
  double duration;

  public RobotDrive(double speed, double direction, double duration) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drive);
    this.speed = speed;
    this.direction = direction;
    this.duration = duration;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setTimeout(this.duration);
    
  }

  //@Override
  //protected void initialize(double speed, double time) {
    
  //}

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drive.arcade(this.speed, this.direction);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
