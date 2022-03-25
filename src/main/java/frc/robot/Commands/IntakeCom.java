package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class IntakeCom extends CommandBase{

    public IntakeCom(){
        addRequirements(Robot.intake);
    }

    @Override
    public void execute(){
        //lift
        boolean controller0_leftBumper = Robot.controller0.getButton(Constants.LEFT_BUMPER);
        boolean controller0_leftTrigger = Robot.controller0.getTrigger(Constants.LEFT_TRIGGER);

        // //vertical
        boolean controller0_rightBumper = Robot.controller0.getButton(Constants.RIGHT_BUMPER);
        boolean controller0_rightTrigger = Robot.controller0.getTrigger(Constants.RIGHT_TRIGGER);
        
        // //horizontal
        boolean controller1_rightBumper = Robot.controller1.getButton(Constants.RIGHT_BUMPER);
        boolean controller1_rightTrigger = Robot.controller1.getTrigger(Constants.RIGHT_TRIGGER);

            Robot.intake.setVerticalIntake(controller0_rightBumper ? Constants.VERTICAL_INTAKE_SPEED : (controller0_rightTrigger ? -Constants.VERTICAL_INTAKE_SPEED : 0));
            Robot.intake.setHorizontalIntake(controller1_rightTrigger ? Constants.HORIZONTAL_INTAKE_SPEED : (controller1_rightBumper ? -Constants.HORIZONTAL_INTAKE_SPEED : 0));
            Robot.intake.setIntakeLift(controller0_leftBumper ? Constants.INTAKE_LIFT_SPEED : (controller0_leftTrigger ? -Constants.INTAKE_LIFT_SPEED : 0));
        }
    }
