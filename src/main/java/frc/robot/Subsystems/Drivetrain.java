package frc.robot.Subsystems;

import frc.robot.Commands.DrivetrainCom;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends SubsystemBase{
    private CANSparkMax motorLeft0;
    private CANSparkMax motorLeft1;
    private CANSparkMax motorRight0;
    private CANSparkMax motorRight1;

    public Drivetrain (int mL0, int mL1, int mR0, int mR1){
        motorLeft0 = new CANSparkMax(mL0, MotorType.kBrushless);
        motorLeft1 = new CANSparkMax(mL1, MotorType.kBrushless);
        motorRight0 = new CANSparkMax(mR0, MotorType.kBrushless);
        motorRight1 = new CANSparkMax(mR1, MotorType.kBrushless);
    }

    @Override
    public void periodic(){
        setDefaultCommand(new DrivetrainCom());
    }

    public void setLeftDrivetrain(double speed){
        motorLeft0.set(speed);
        motorLeft1.set(speed);
    }

    public void setRightDrivetrain(double speed){
        motorRight0.set(-speed);
        motorRight1.set(-speed);
    }
}