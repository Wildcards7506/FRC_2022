package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Commands.IntakeCom;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake extends SubsystemBase{

    private VictorSPX horizontalIntake;
    private static CANSparkMax intakeLift;
    private VictorSPX verticalIntake;
    private RelativeEncoder intakeLiftEncoder;



    public Intake (int horIntake, int vertIntake, int inLift) {
        horizontalIntake = new VictorSPX(horIntake);
        verticalIntake = new VictorSPX(vertIntake);
        intakeLift = new CANSparkMax(inLift, MotorType.kBrushless);
        intakeLiftEncoder = intakeLift.getEncoder();
    }

    public void setHorizontalIntake(double speed) {
        horizontalIntake.set(ControlMode.PercentOutput, speed);
    }

    public void setVerticalIntake(double speed) {
        verticalIntake.set(ControlMode.PercentOutput, speed);
    }

    public void setIntakeLift(double speed){
        intakeLift.set(-speed);
    }

    @Override
    public void periodic(){
        setDefaultCommand(new IntakeCom());
    }
}
