package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ShooterCom extends CommandBase{

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
        double currentDraw = 0.0;

        if(controller1_buttonA == true){
            Robot.shooter.setShooterMotor(.6);
            currentDraw = Robot.shooter.getCurrent(currentDraw);
        }else if(controller1_buttonB == true){
            Robot.shooter.setShooterMotor(.5);
            currentDraw = Robot.shooter.getCurrent(currentDraw);
        }else if(controller1_buttonX == true){
            Robot.shooter.setShooterMotor(.32);
            currentDraw = Robot.shooter.getCurrent(currentDraw);
        }else if(controller1_buttonY == true){
            Robot.shooter.limelightShoot(0.6);
            currentDraw = Robot.shooter.getCurrent(currentDraw);
        }else{
            currentDraw = 0;
            Robot.shooter.setShooterMotor(0);
        }

        Robot.shooter.updateDashboard();
    }
}
