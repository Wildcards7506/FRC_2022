package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Commands.ClimbersCom;

public class Climbers extends SubsystemBase{
    private VictorSPX leftClimber;
    private VictorSPX rightClimber;
    private PWM arduino;

    public Climbers(int climberL, int climberR) {
        leftClimber = new VictorSPX(climberL);
        rightClimber = new VictorSPX(climberR);
        arduino = new PWM(0);
    }

    public void setLeftClimber(double speed){
        leftClimber.set(ControlMode.PercentOutput, -speed);
        if(arduino.getRaw() != 100){
            arduino.setRaw(100);
        }
    }

    public void setRightClimber(double speed){
        rightClimber.set(ControlMode.PercentOutput, -speed);
        if(arduino.getRaw() == 100){
            arduino.setRaw(100);
        }
    }

    public void stop(){
        rightClimber.set(ControlMode.PercentOutput, Constants.STOP);
        leftClimber.set(ControlMode.PercentOutput, Constants.STOP);
    }

    @Override
    public void periodic(){
        setDefaultCommand(new ClimbersCom());
    }
}
