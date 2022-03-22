package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Commands.ShooterCom;

public class Shooter extends SubsystemBase{
    private static CANSparkMax shooter;
    private static RelativeEncoder shooterEncoder;
    private static double avgCurrent = 10;

    public Shooter(int shoot){
        shooter = new CANSparkMax(shoot, MotorType.kBrushless);
        shooterEncoder = shooter.getEncoder();
    }

    public void setShooterMotor(double speed){
        shooter.set(-speed * (avgCurrent/10));
        if(avgCurrent == 10){
            avgCurrent = shooter.getOutputCurrent();
        }else{
            avgCurrent = (avgCurrent + shooter.getOutputCurrent())/2;
        }
    }

    public void updateDashboard(){
        SmartDashboard.putNumber("Shooter Speed ", shooterEncoder.getVelocity());
        SmartDashboard.putNumber("Shooter Current", shooter.getOutputCurrent());
    } 

    @Override
    public void periodic(){
        setDefaultCommand(new ShooterCom());
    }
}
