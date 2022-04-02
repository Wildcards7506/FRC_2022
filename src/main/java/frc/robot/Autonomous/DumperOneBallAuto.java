package frc.robot.Autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;

public class DumperOneBallAuto extends SequentialCommandGroup{

    public DumperOneBallAuto() {
        AutoCommand.runDumperIntake(-Constants.DUMPER_INTAKE_SPEED);
        Timer.delay(1);
        AutoCommand.runDumperIntake(0);
        AutoCommand.drive(-.25, 1);
    }
    
}
