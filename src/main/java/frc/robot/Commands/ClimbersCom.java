package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ClimbersCom extends CommandBase{

    private double prev_controller1_leftJoystickY = 0;
    private double prev_controller1_rightJoystickY = 0;

    public ClimbersCom(){
        addRequirements(Robot.climbers);
    }
    
    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        double leftSpeed = 0;
        double rightSpeed = 0;
        
        double controller1_leftJoystickY = Robot.controller1.getJoystickAxis(Constants.LEFT_STICK_Y);
        double controller1_rightJoystickY = Robot.controller1.getJoystickAxis(Constants.RIGHT_STICK_Y);

        if(controller1_leftJoystickY != prev_controller1_leftJoystickY || 
           controller1_rightJoystickY != prev_controller1_rightJoystickY){
                
            prev_controller1_leftJoystickY = controller1_leftJoystickY;
            prev_controller1_rightJoystickY = controller1_rightJoystickY;
            
            leftSpeed = controller1_leftJoystickY;
            rightSpeed = controller1_rightJoystickY;

            Robot.climbers.setLeftClimber(leftSpeed);
            Robot.climbers.setRightClimber(rightSpeed);
        }
    }

    @Override
    public void end(boolean interrupted){

    }
}
