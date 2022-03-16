package frc.robot.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoSequence extends SequentialCommandGroup {
    
    public AutoSequence(){
        AutoCommand.limelightShoot();
        AutoCommand.trajectoryCommand(0, Math.PI);
        AutoCommand.runIntake(1.0);
        AutoCommand.trajectoryCommand(3.0, 0);
        AutoCommand.runIntake(0.0);
        AutoCommand.trajectoryCommand(0, 0);
        AutoCommand.limelightShoot();
    }
}
