package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class DrivetrainCom extends CommandBase{
    
    private double prev_controller0_rightStickX = 0;
    private double prev_controller0_leftStickY = 0;

    public DrivetrainCom() {
        addRequirements(Robot.drivetrain);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        //Get joystick values
        double controller0_rightStickX = Robot.controller0.getJoystickAxis(Constants.RIGHT_STICK_X);
        double controller0_leftStickY = Robot.controller0.getJoystickAxis(Constants.LEFT_STICK_Y);
        boolean controller0_leftBumper = Robot.controller0.getButton(Constants.LEFT_BUMPER);
        boolean controller0_leftTrigger = Robot.controller0.getButton(Constants.LEFT_TRIGGER);

        if(controller0_rightStickX != prev_controller0_rightStickX ||
           controller0_leftStickY != prev_controller0_leftStickY){
               
            prev_controller0_rightStickX = controller0_rightStickX;
            prev_controller0_leftStickY = controller0_leftStickY;

            //Calculate values to set motors
            double leftMotorSet = ((controller0_leftStickY - (Constants.LEFT_RIGHT_TRIM + (controller0_rightStickX * Constants.MAX_TURN_SPEED))) * (controller0_leftTrigger ? Constants.FULL_SPEED : (controller0_leftBumper ? Constants.SLOW_SPEED : Constants.MAX_DRIVE_SPEED)));
            double rightMotorSet = ((controller0_leftStickY + (Constants.LEFT_RIGHT_TRIM + (controller0_rightStickX * Constants.MAX_TURN_SPEED))) * (controller0_leftTrigger ? Constants.FULL_SPEED : (controller0_leftBumper ? Constants.SLOW_SPEED : Constants.MAX_DRIVE_SPEED)));

            //Set motors
            Robot.drivetrain.setLeftDrivetrain(leftMotorSet);
            Robot.drivetrain.setRightDrivetrain(rightMotorSet);
        }
    }

    @Override
    public void end(boolean inturrupted){
    }
}
