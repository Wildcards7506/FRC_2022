package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Commands.IntakeCom;

public class Intake extends SubsystemBase{

    private VictorSPX horizontalIntake;
    private VictorSPX intakeLift;
    private VictorSPX verticalIntake;
    private VictorSPX intakeWheelR;
    private VictorSPX intakeWheelL;

    public Intake (int horIntake, int vertIntake, int inLift, int wheelR, int wheelL) {
        horizontalIntake = new VictorSPX(horIntake);
        verticalIntake = new VictorSPX(vertIntake);
        intakeLift = new VictorSPX(inLift);
        intakeWheelL = new VictorSPX(wheelR);
        intakeWheelR = new VictorSPX(wheelL);
    }

    public void setHorizontalIntake(double speed) {
        horizontalIntake.set(ControlMode.PercentOutput, speed);
    }

    public void setVerticalIntake(double speed) {
        verticalIntake.set(ControlMode.PercentOutput, speed);
    }

    public void setIntakeLift(double speed){
        intakeLift.set(ControlMode.PercentOutput, -speed);
    }

    public void setIntakeWheels(double speed){
        intakeWheelL.set(ControlMode.PercentOutput, speed);
        intakeWheelR.set(ControlMode.PercentOutput, speed);
    }

    @Override
    public void periodic(){
        setDefaultCommand(new IntakeCom());
    }
}
