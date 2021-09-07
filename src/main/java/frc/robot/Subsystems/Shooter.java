package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Commands.ShooterCom;

public class Shooter extends SubsystemBase{
    private PWMSparkMax shooter;

    public Shooter(int shoot){
        shooter = new PWMSparkMax(shoot);
    }

    public void setShooterMotor(double speed){
        shooter.set(speed);
    }

    public void stop(){
        shooter.set(Constants.STOP);
    }

    @Override
    public void periodic(){
        setDefaultCommand(new ShooterCom());
    }
}
