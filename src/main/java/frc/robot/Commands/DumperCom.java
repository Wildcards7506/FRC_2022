package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class DumperCom extends CommandBase{
    
    public DumperCom() {
        addRequirements(Robot.dumper);
    }

    @Override
    public void execute() {
        boolean controller0_leftTrigger = Robot.controller0.getTrigger(Constants.LEFT_TRIGGER);
        boolean controller0_rightTrigger = Robot.controller0.getTrigger(Constants.RIGHT_TRIGGER);
        boolean controller0_leftBumper = Robot.controller0.getButton(Constants.LEFT_BUMPER);
        boolean controller0_rightBumper = Robot.controller0.getButton(Constants.RIGHT_BUMPER);

        Robot.dumper.setIntake(controller0_rightTrigger ? Constants.DUMPER_INTAKE_SPEED : (controller0_rightBumper ? Constants.DUMPER_OUTPUT_SPEED : 0));
        Robot.dumper.setLift(controller0_leftBumper ? Constants.DUMPER_LIFT_SPEED : (controller0_leftTrigger ? Constants.DUMPER_LOWER_SPEED : 0));

        // if(Robot.climbers.getRightDumperEncoder() > 4){
        //     if(Robot.climbers.getRightExtension() < 213){
        //         Robot.climbers.encoderMatch(Constants.FULL_SPEED);
        //     }
        // }
    }


}