package frc.robot.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;

public class AutoSequence extends SequentialCommandGroup {
    public AutoSequence() {
        AutoCommand.limelightShoot();
        while(true){
            Robot.limelight.updateData();
        }
        //AutoCommand.linearDrive();
    }
}
