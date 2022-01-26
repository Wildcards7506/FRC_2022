package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Commands.ClimbersCom;

public class Climbers extends SubsystemBase{
    private CANSparkMax leftClimber0;
    private CANSparkMax leftClimber1;
    private CANSparkMax leftClimberRotate;
    private CANSparkMax rightClimber0;
    private CANSparkMax rightClimber1;
    private CANSparkMax rightClimberRotate;
    private PWM arduino;

    public Climbers(int climberL0, int climberL1, int climberLR, int climberR0, int climberR1, int climberRR) {
        leftClimber0 = new CANSparkMax(climberL0, MotorType.kBrushless);
        leftClimber1 = new CANSparkMax(climberL1, MotorType.kBrushless);
        leftClimberRotate = new CANSparkMax(climberLR, MotorType.kBrushless);
        rightClimber0 = new CANSparkMax(climberR0, MotorType.kBrushless);
        rightClimber1 = new CANSparkMax(climberR1, MotorType.kBrushless);
        rightClimberRotate = new CANSparkMax(climberRR, MotorType.kBrushless);
        arduino = new PWM(0);
    }

    public void setLeftClimber(double speed){
        leftClimber0.set(-speed);
        leftClimber1.set(-speed);
        if(arduino.getRaw() != 100){
            arduino.setRaw(100);
        }
    }

    public void setRightClimber(double speed){
        rightClimber0.set(-speed);
        rightClimber1.set(-speed);
        if(arduino.getRaw() == 100){
            arduino.setRaw(100);
        }
    }

    public void setClimberRotation(double speed)
    {
        leftClimberRotate.set(speed);
        rightClimberRotate.set(speed);
    }

    @Override
    public void periodic(){
        setDefaultCommand(new ClimbersCom());
    }
}
