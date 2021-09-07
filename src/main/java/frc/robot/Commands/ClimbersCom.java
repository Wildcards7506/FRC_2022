package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ClimbersCom extends CommandBase{

    private double prev_controller2_leftJoystickY = 0;
    private double prev_controller2_rightJoystickY = 0;

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
        
        double controller2_leftJoystickY = Robot.controller2.getJoystickAxis(Constants.LEFT_STICK_Y);
        double controller2_rightJoystickY = Robot.controller2.getJoystickAxis(Constants.RIGHT_STICK_Y);

        if(controller2_leftJoystickY != prev_controller2_leftJoystickY || 
           controller2_rightJoystickY != prev_controller2_rightJoystickY){
                
            prev_controller2_leftJoystickY = controller2_leftJoystickY;
            prev_controller2_rightJoystickY = controller2_rightJoystickY;
            
            leftSpeed = controller2_leftJoystickY;
            rightSpeed = controller2_rightJoystickY;

            Robot.climbers.setLeftClimber(leftSpeed);
            Robot.climbers.setRightClimber(rightSpeed);
        }
    }

    @Override
    public void end(boolean interrupted){

    }
}
