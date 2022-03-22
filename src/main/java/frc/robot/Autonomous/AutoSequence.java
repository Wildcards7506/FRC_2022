package frc.robot.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoSequence extends SequentialCommandGroup {
    
    public AutoSequence(){
        AutoCommand.lowerIntake();
        AutoCommand.drive(.2, .3);
        AutoCommand.limelightShoot(.5);
        AutoCommand.drive(.2, 1);
        // AutoCommand.tr
        // Autocommand.trajectoryCommand(0, Math.PI);
        // AutoCommand.runIntake(1.0);
        // AutoCommand.trajectoryCommand(3.0, 0);
        // AutoCommand.runIntake(0.0);
        // AutoCommand.trajectoryCommand(0, Math.PI);
        // AutoCommand.limelightShoot();
    }
}
