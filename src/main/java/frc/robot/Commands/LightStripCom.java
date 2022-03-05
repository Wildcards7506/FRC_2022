// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LightStripCom extends CommandBase {
  /** Creates a new LightStrip. */
  public LightStripCom() {
    addRequirements(Robot.lightstrip);
    SmartDashboard.putString("LightMode", "REQ");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.lightstrip.preMatch();
  }
}
