package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class IntakeCom extends CommandBase{

    private boolean prev_controller1_leftBumper = false;
    private boolean prev_controller1_leftTrigger = false;
    private boolean prev_controller2_leftBumper = false;
    private boolean prev_controller2_leftTrigger = false;
    private boolean prev_controller2_rightBumper = false;
    private boolean prev_controller2_rightTrigger = false;

    public IntakeCom(){
        addRequirements(Robot.intake);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        boolean controller1_leftBumper = Robot.controller1.getButton(Constants.LEFT_BUMPER);
        boolean controller1_leftTrigger = Robot.controller1.getTrigger(Constants.LEFT_TRIGGER);

        boolean controller2_leftBumper = Robot.controller2.getButton(Constants.LEFT_BUMPER);
        boolean controller2_rightBumper = Robot.controller2.getButton(Constants.RIGHT_BUMPER);
        boolean controller2_leftTrigger = Robot.controller2.getTrigger(Constants.LEFT_TRIGGER);
        boolean controller2_rightTrigger = Robot.controller2.getTrigger(Constants.RIGHT_TRIGGER);

        if(
            controller1_leftBumper != prev_controller1_leftBumper ||
            controller1_leftTrigger != prev_controller1_leftTrigger ||
            controller2_leftBumper != prev_controller2_leftBumper ||
            controller2_leftTrigger != prev_controller2_leftTrigger ||
            controller2_rightBumper != prev_controller2_rightBumper ||
            controller2_rightTrigger != prev_controller2_rightTrigger
        ){
            double horizontalSpeed;
            double verticalSpeed;
            double liftSpeed;
            
            if(controller1_leftBumper == true){
                liftSpeed = Constants.INTAKE_LIFT_SPEED;
            } else if(controller1_leftTrigger == true){
                liftSpeed = -Constants.INTAKE_LIFT_SPEED;
            } else {
                liftSpeed = Constants.STOP;
            }

            if(controller2_rightTrigger){
                horizontalSpeed = Constants.HORIZONTAL_INTAKE_SPEED;
            } else if(controller2_rightBumper == true){
                horizontalSpeed = -Constants.HORIZONTAL_INTAKE_SPEED;
            } else {
                horizontalSpeed = Constants.STOP;
            }

            if(controller2_leftTrigger){
                verticalSpeed = -Constants.VERTICAL_INTAKE_SPEED;
            } else if(controller2_leftBumper == true){
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