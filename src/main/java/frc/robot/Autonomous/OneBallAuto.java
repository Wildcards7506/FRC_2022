package frc.robot.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class OneBallAuto extends SequentialCommandGroup {
    
    public OneBallAuto(){
        AutoCommand.lowerIntake();
        AutoCommand.drive(.2, .4);
        AutoCommand.limelightShoot(.60);
        AutoCommand.drive(.2, 1);
    }
}