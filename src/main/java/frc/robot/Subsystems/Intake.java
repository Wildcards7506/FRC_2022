package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Commands.IntakeCom;

public class Intake extends SubsystemBase{

    private VictorSPX horizontalIntake;
    private VictorSPX intakeLift;
    private VictorSPX verticalIntake;

    public Intake (int horIntake, int vertIntake, int inLift) {
        horizontalIntake = new VictorSPX(horIntake);
        verticalIntake = new VictorSPX(vertIntake);
        intakeLift = new VictorSPX(inLift);
    }

    public void setHorizontalIntake(double speed) {
        horizontalIntake.set(ControlMode.PercentOutput, speed);
    }

    public void setVerticalIntake(double speed) {
        verticalIntake.set(ControlMode.PercentOutput, speed);
    }

    public void setIntakeLift(double speed){
        intakeLift.set(ControlMode.PercentOutput, speed);
    }

    public void stop(){
        horizontalIntake.set(ControlMode.PercentOutput, Constants.STOP);
        verticalIntake.set(ControlMode.PercentOutput, Constants.STOP);
        intakeLift.set(ControlMode.PercentOutput, Constants.STOP);
    }

    @Override
    public void periodic(){
        setDefaultCommand(new IntakeCom());
    }
}
