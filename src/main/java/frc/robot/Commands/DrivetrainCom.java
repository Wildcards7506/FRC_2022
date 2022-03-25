package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class DrivetrainCom extends CommandBase{

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

            double leftMotorSet = 0;
            double rightMotorSet = 0;

            // Calculate values to set motors
            if(controller0_leftStickY != 0 || controller0_rightStickX != 0)
            {
                leftMotorSet = ((controller0_leftStickY - (Constants.LEFT_RIGHT_TRIM + (controller0_rightStickX * Constants.MAX_TURN_SPEED))) * Constants.MAX_DRIVE_SPEED);
                rightMotorSet = ((controller0_leftStickY + (Constants.LEFT_RIGHT_TRIM + (controller0_rightStickX * Constants.MAX_TURN_SPEED))) * Constants.MAX_DRIVE_SPEED);
            }

            //Set motors
            Robot.drivetrain.setLeftDrivetrain(leftMotorSet);
            Robot.drivetrain.setRightDrivetrain(rightMotorSet);
            Robot.drivetrain.updateDashboard();
        }
    

    @Override
    public void end(boolean inturrupted){
    }
}
