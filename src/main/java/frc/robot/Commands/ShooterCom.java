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

            if(controller1_buttonA == true){
                Robot.shooter.setShooterMotor(.6);
            }else if(controller1_buttonB == true){
                Robot.shooter.setShooterMotor(.5);
            }else if(controller1_buttonX == true){
                Robot.shooter.setShooterMotor(.32);
            }else if(controller1_buttonY == true){
                Robot.shooter.setShooterMotor(.25);
            }else{
                Robot.shooter.setShooterMotor(0);
            }
        }
        Robot.shooter.updateDashboard();
    }
}
