package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ShooterCom extends CommandBase{

    private boolean prev_controller2_buttonA = false;
    private boolean prev_controller2_buttonB = false;
    private boolean prev_controller2_buttonX = false;
    private boolean prev_controller2_buttonY = false;

    public ShooterCom(){
        addRequirements(Robot.shooter);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        boolean controller2_buttonA = Robot.controller2.getButton(Constants.BUTTON_A);
        boolean controller2_buttonB = Robot.controller2.getButton(Constants.BUTTON_B);
        boolean controller2_buttonX = Robot.controller2.getButton(Constants.BUTTON_C);
        boolean controller2_buttonY = Robot.controller2.getButton(Constants.BUTTON_Y);
        
        if(
            controller2_buttonA != prev_controller2_buttonA ||
            controller2_buttonB != prev_controller2_buttonB ||
            controller2_buttonX != prev_controller2_buttonX ||
            controller2_buttonY != prev_controller2_buttonY
        ){
            double speed;
            if(controller2_buttonA == true){
                speed = 1;
            }else if(controller2_buttonB == true){
                speed = .8;
            }else if(controller2_buttonX == true){
                speed = .6;
            }else if(controller2_buttonY == true){
                speed = .5;
            }else{
                speed = Constants.STOP;
            }

            Robot.shooter.setShooterMotor(speed);
        }
    }

    @Override
    public void end(boolean interrupted){
        Robot.shooter.stop();
    }
}
