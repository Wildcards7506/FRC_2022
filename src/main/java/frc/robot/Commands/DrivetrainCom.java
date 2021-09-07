package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class DrivetrainCom extends CommandBase{
    
    private double prev_controller1_rightStickX = 0;
    private double prev_controller1_leftStickY = 0;

    public DrivetrainCom() {
        addRequirements(Robot.drivetrain);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        //Get joystick values
        double controller1_rightStickX = Robot.controller1.getJoystickAxis(Constants.RIGHT_STICK_X);
        double controller1_leftStickY = Robot.controller1.getJoystickAxis(Constants.LEFT_STICK_Y);

        if(controller1_rightStickX != prev_controller1_rightStickX ||
           controller1_leftStickY != prev_controller1_leftStickY){
            //Calculate values to set motors
            double leftMotorSet = ((controller1_leftStickY - (Constants.LEFT_RIGHT_TRIM + (controller1_rightStickX * Constants.MAX_TURN_SPEED))) * Constants.MAX_DRIVE_SPEED);
            double rightMotorSet = ((controller1_leftStickY + (Constants.LEFT_RIGHT_TRIM + (controller1_rightStickX * Constants.MAX_TURN_SPEED))) * Constants.MAX_DRIVE_SPEED);

            //Set motors
            Robot.drivetrain.setLeftDrivetrain(leftMotorSet);
            Robot.drivetrain.setRightDrivetrain(rightMotorSet);
        }
    }

    @Override
    public void end(boolean inturrupted){
        Robot.drivetrain.stop();
    }
}
