package frc.robot.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class OneBallAuto extends SequentialCommandGroup {
    
    public OneBallAuto(){
        AutoCommand.lowerIntake();
        AutoCommand.drive(.2, .3);
        AutoCommand.limelightShoot(.5);
        AutoCommand.drive(.2, 1);
    }
}