package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ClimbersCom extends CommandBase{    

    public ClimbersCom(){
        addRequirements(Robot.climbers);
    }

    @Override
    public void execute(){    
        double controller1_leftJoystickY = Robot.controller1.getJoystickAxis(Constants.LEFT_STICK_Y);
        double controller1_rightJoystickY = Robot.controller1.getJoystickAxis(Constants.RIGHT_STICK_Y);

        boolean controller1_leftTrigger = Robot.controller1.getTrigger(Constants.LEFT_TRIGGER);
        boolean controller1_leftBumper = Robot.controller1.getButton(Constants.LEFT_BUMPER);

        double controller1_dpad = Robot.controller1.getPOV();
                
        // prev_controller1_leftJoystickY = controller1_leftJoystickY;
        // prev_controller1_rightJoystickY = controller1_rightJoystickY;
        // if(Robot.climbers.getRightEncoder() > 4){
        //     if(Robot.climbers.getRightExtension() < 213){
        //         Robot.climbers.encoderMatch(Constants.FULL_SPEED);
        //     }
        // }

        if(controller1_leftTrigger){
            Robot.climbers.setLeftClimber(-1);
            Robot.climbers.setRightClimber(-1);
            //Robot.climbers.encoderMatch(.2, -1);
        } else if (controller1_leftBumper) {
            //Robot.climbers.encoderMatch(.2, 1);
            Robot.climbers.setLeftClimber(1);
            Robot.climbers.setRightClimber(1);
        } else {
            Robot.climbers.setLeftClimber(controller1_leftJoystickY);
            Robot.climbers.setRightClimber(controller1_rightJoystickY);
        }

        Robot.climbers.setClimberRotation(controller1_dpad == 180 ? Constants.CLIMBER_ROTATION_SPEED : (controller1_dpad == 0 ? -Constants.CLIMBER_ROTATION_SPEED : Constants.CLIMBER_ROTATION_STATIC));
        Robot.climbers.updateDashboard();
        //if Robot.climbers.
    }
}
