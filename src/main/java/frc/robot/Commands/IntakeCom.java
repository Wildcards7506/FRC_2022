package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class IntakeCom extends CommandBase{

    private boolean prev_controller0_leftBumper = false;
    private boolean prev_controller0_leftTrigger = false;
    private boolean prev_controller1_leftBumper = false;
    private boolean prev_controller1_leftTrigger = false;
    private boolean prev_controller1_rightBumper = false;
    private boolean prev_controller1_rightTrigger = false;

    public IntakeCom(){
        addRequirements(Robot.intake);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        //lift
        boolean controller0_leftBumper = Robot.controller0.getButton(Constants.LEFT_BUMPER);
        boolean controller0_leftTrigger = Robot.controller0.getTrigger(Constants.LEFT_TRIGGER);

        // //vertical
        boolean controller1_leftBumper = Robot.controller1.getButton(Constants.LEFT_BUMPER);
        boolean controller1_leftTrigger = Robot.controller1.getTrigger(Constants.LEFT_TRIGGER);
        
        // //horizontal
        boolean controller1_rightBumper = Robot.controller1.getButton(Constants.RIGHT_BUMPER);
        boolean controller1_rightTrigger = Robot.controller1.getTrigger(Constants.RIGHT_TRIGGER);

        if(
            controller0_leftBumper != prev_controller0_leftBumper ||
            controller0_leftTrigger != prev_controller0_leftTrigger ||
            controller1_leftBumper != prev_controller1_leftBumper ||
            controller1_leftTrigger != prev_controller1_leftTrigger ||
            controller1_rightBumper != prev_controller1_rightBumper ||
            controller1_rightTrigger != prev_controller1_rightTrigger
        ){
            double horizontalSpeed;
            double verticalSpeed;
            double liftSpeed;

            prev_controller0_leftBumper = controller0_leftBumper;
            prev_controller0_leftTrigger = controller0_leftTrigger;
            prev_controller1_leftBumper = controller1_leftBumper;
            prev_controller1_leftTrigger = controller1_leftTrigger;
            prev_controller1_rightBumper = controller1_rightBumper;
            prev_controller1_rightTrigger = controller1_rightTrigger;
            
            if(controller0_leftBumper == true){
                liftSpeed = Constants.INTAKE_LIFT_SPEED;
            } else if(controller0_leftTrigger == true){
                liftSpeed = -Constants.INTAKE_LIFT_SPEED;
            } else {
                liftSpeed = Constants.STOP;
            }

            if(controller1_rightTrigger){
                horizontalSpeed = Constants.HORIZONTAL_INTAKE_SPEED;
            } else if(controller1_rightBumper == true){
                horizontalSpeed = -Constants.HORIZONTAL_INTAKE_SPEED;
            } else {
                horizontalSpeed = Constants.STOP;
            }

            if(controller1_leftTrigger){
                verticalSpeed = -Constants.VERTICAL_INTAKE_SPEED;
            } else if(controller1_leftBumper == true){
                verticalSpeed = Constants.VERTICAL_INTAKE_SPEED;
            } else {
                verticalSpeed = Constants.STOP;
            }
            Robot.intake.setVerticalIntake(verticalSpeed);
            Robot.intake.setHorizontalIntake(horizontalSpeed);
            Robot.intake.setIntakeLift(liftSpeed);
        }
    }

    @Override
    public void end(boolean interrupted){
        Robot.intake.stop();
    }
}