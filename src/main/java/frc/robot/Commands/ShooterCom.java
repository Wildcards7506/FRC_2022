package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ShooterCom extends CommandBase{

    private boolean prev_controller1_buttonA = false;
    private boolean prev_controller1_buttonB = false;
    private boolean prev_controller1_buttonX = false;
    private boolean prev_controller1_buttonY = false;

    public ShooterCom(){
        addRequirements(Robot.shooter);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        boolean controller1_buttonA = Robot.controller1.getButton(Constants.BUTTON_A);
        boolean controller1_buttonB = Robot.controller1.getButton(Constants.BUTTON_B);
        boolean controller1_buttonX = Robot.controller1.getButton(Constants.BUTTON_X);
        boolean controller1_buttonY = Robot.controller1.getButton(Constants.BUTTON_Y);
        
        if(
            controller1_buttonA != prev_controller1_buttonA ||
            controller1_buttonB != prev_controller1_buttonB ||
            controller1_buttonX != prev_controller1_buttonX ||
            controller1_buttonY != prev_controller1_buttonY
        ){

            prev_controller1_buttonA = controller1_buttonA;
            prev_controller1_buttonB = controller1_buttonB;
            prev_controller1_buttonX = controller1_buttonX;
            prev_controller1_buttonY = controller1_buttonY;

            double speed;
            if(controller1_buttonA == true){
                speed = 1;
            }else if(controller1_buttonB == true){
                speed = .8;
            }else if(controller1_buttonX == true){
                speed = .6;
            }else if(controller1_buttonY == true){
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
