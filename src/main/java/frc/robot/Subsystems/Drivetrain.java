package frc.robot.Subsystems;

import frc.robot.Constants;
import frc.robot.Commands.DrivetrainCom;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Drivetrain extends SubsystemBase{
    private VictorSPX motorLeft1;
    private VictorSPX motorLeft2;
    private VictorSPX motorRight1;
    private VictorSPX motorRight2;

    public Drivetrain (int mL1, int mL2, int mR1, int mR2){
        motorLeft1 = new VictorSPX(mL1);
        motorLeft2 = new VictorSPX(mL2);
        motorRight1 = new VictorSPX(mR1);
        motorRight2 = new VictorSPX(mR2);
    }

    @Override
    public void periodic(){
        setDefaultCommand(new DrivetrainCom());
    }

    public void setLeftDrivetrain(double speed){
        motorLeft1.set(ControlMode.PercentOutput, speed);
        motorLeft2.set(ControlMode.PercentOutput, speed);
    }

    public void setRightDrivetrain(double speed){
        motorRight1.set(ControlMode.PercentOutput, speed);
        motorRight2.set(ControlMode.PercentOutput, speed);
    }

    public void stop(){
        motorRight1.set(ControlMode.PercentOutput, Constants.STOP);
        motorRight2.set(ControlMode.PercentOutput, Constants.STOP);
        motorLeft1.set(ControlMode.PercentOutput, Constants.STOP);
        motorLeft2.set(ControlMode.PercentOutput, Constants.STOP);
    }
}