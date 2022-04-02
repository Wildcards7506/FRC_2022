package frc.robot.Autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;

public class DumperThreeBallAuto extends SequentialCommandGroup{

    public DumperThreeBallAuto() {
        AutoCommand.runDumperIntake(-Constants.DUMPER_INTAKE_SPEED);
        Timer.delay(1);
        AutoCommand.runDumperIntake(0);
        AutoCommand.drive(.2, .25);
        AutoCommand.rotate(180);
        AutoCommand.runDumperIntake(0);
        AutoCommand.runDumperIntake(Constants.DUMPER_INTAKE_SPEED);
        AutoCommand.drive(.2, 1);
        
    }
    
}
