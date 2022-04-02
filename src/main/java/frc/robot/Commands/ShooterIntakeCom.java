package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ShooterIntakeCom extends CommandBase{

    // private boolean prev_controller0_leftBumper = false;
    // private boolean prev_controller0_leftTrigger = false;
    // private boolean prev_controller1_rightBumper = false;
    // private boolean prev_controller1_rightTrigger = false;
    // private int prev_controller1_dpad = -1;

    public ShooterIntakeCom(){
        // addRequirements(Robot.shooterIntake);
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

        // if(
        //     controller0_dpad != prev_controller1_dpad ||
        //     controller0_rightBumper != prev_controller0_leftBumper ||
        //     controller0_rightTrigger != prev_controller0_leftTrigger ||
        //     controller1_rightBumper != prev_controller1_rightBumper ||
        //     controller1_rightTrigger != prev_controller1_rightTrigger
        // ){
        //     prev_controller1_dpad = controller0_dpad;
        //     prev_controller0_leftBumper = controller0_rightBumper;
        //     prev_controller0_leftTrigger = controller0_rightTrigger;
        //     prev_controller1_rightBumper = controller1_rightBumper;
        //     prev_controller1_rightTrigger = controller1_rightTrigger;

            // Robot.shooterIntake.setVerticalIntake(controller0_rightBumper ? Constants.VERTICAL_INTAKE_SPEED : (controller0_rightTrigger ? -Constants.VERTICAL_INTAKE_SPEED : 0));
            // Robot.shooterIntake.setHorizontalIntake(controller1_rightTrigger ? Constants.HORIZONTAL_INTAKE_SPEED : (controller1_rightBumper ? -Constants.HORIZONTAL_INTAKE_SPEED : 0));
            // Robot.shooterIntake.setIntakeLift(controller0_leftBumper ? Constants.INTAKE_LIFT_SPEED : (controller0_leftTrigger ? -Constants.INTAKE_LIFT_SPEED : 0));
        }
    }
