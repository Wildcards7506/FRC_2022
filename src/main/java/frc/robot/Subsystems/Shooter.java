package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Commands.ShooterCom;

public class Shooter extends SubsystemBase{
    private static CANSparkMax shooter;

    public Shooter(int shoot){
        shooter = new CANSparkMax(shoot, MotorType.kBrushless);
    }

    public void setShooterMotor(double speed){
        shooter.set(speed);
    }

    @Override
    public void periodic(){
        setDefaultCommand(new ShooterCom());
    }
}
