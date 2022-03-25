package frc.robot.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ThreeBallAuto extends SequentialCommandGroup {
    
    public ThreeBallAuto(){
        AutoCommand.lowerIntake();
        AutoCommand.drive(.2, .3);
        AutoCommand.limelightShoot(.5);
        AutoCommand.rotate(180);
        AutoCommand.runIntake(0.8);
        AutoCommand.drive(.2, 1);
        AutoCommand.runIntake(0);
        AutoCommand.rotate(180);
        AutoCommand.limelightShoot(.5);
        AutoCommand.rotate(-70);
        AutoCommand.runIntake(0.8);
        AutoCommand.drive(.2, 1);
        AutoCommand.runIntake(0);
        AutoCommand.rotate(70);
        AutoCommand.limelightShoot(.5);    
    }
}