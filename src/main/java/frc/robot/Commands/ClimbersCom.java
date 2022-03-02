package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ClimbersCom extends CommandBase{

    // private double prev_controller1_leftJoystickY = 0;
    // private double prev_controller1_rightJoystickY = 0;
    

    public ClimbersCom(){
        addRequirements(Robot.climbers);
    }

    @Override
    public void execute(){        
        double controller1_leftJoystickY = Robot.controller1.getJoystickAxis(Constants.LEFT_STICK_Y);
        double controller1_rightJoystickY = Robot.controller1.getJoystickAxis(Constants.RIGHT_STICK_Y);

        // if(controller1_leftJoystickY != prev_controller1_leftJoystickY || 
        //    controller1_rightJoystickY != prev_controller1_rightJoystickY){
                
            // prev_controller1_leftJoystickY = controller1_leftJoystickY;
            // prev_controller1_rightJoystickY = controller1_rightJoystickY;

            Robot.climbers.setLeftClimber(controller1_leftJoystickY);
            Robot.climbers.setRightClimber(controller1_rightJoystickY);
            Robot.climbers.setClimberRotation(Robot.controller1.getTrigger(Constants.LEFT_TRIGGER) ? Constants.CLIMBER_ROTATION_SPEED : (Robot.controller1.getButton(Constants.LEFT_BUMPER) ? -Constants.CLIMBER_ROTATION_SPEED : Constants.CLIMBER_ROTATION_STATIC));
            Robot.climbers.updateDashboard();
        // }
    }
}
