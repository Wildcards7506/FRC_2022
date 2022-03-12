// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LightStripCom extends CommandBase {
  /** Creates a new LightStrip. */
  public LightStripCom() {
    addRequirements(Robot.lightstrip);
    SmartDashboard.putString("LightMode", "success");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Shooting methods
    // int c = 0;
    //Robot.lightstrip.idle(c);
    Robot.lightstrip.preMatch();
    // Robot.lightstrip.aiming();
    // Robot.lightstrip.targetLocked();

    // Climbing methods
    // Robot.lightstrip.armsAreVertical();

    // Arms are rotating
    // if(Robot.controller1.getButton(Constants.RIGHT_CLIMBER_ROTATE) == true){
    //   Robot.lightstrip.armsAreRotating();
    // }

    // Arms are extending
    // if(Robot.controller1.getJoystickAxis(Constants.LEFT_STICK_Y) > 0.0 || Robot.controller1.getJoystickAxis(Constants.RIGHT_STICK_Y) > 0.0){
    //   Robot.lightstrip.armsAreExtending();
    // }
    // Robot.lightstrip.fullyExtendedOrRetracted();
  }
}
