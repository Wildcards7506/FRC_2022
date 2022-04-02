package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Commands.DumperCom;

public class Dumper extends SubsystemBase{

    private VictorSPX intake;
    private CANSparkMax leftLift;
    private CANSparkMax rightLift;

    public Dumper(int intakeNum, int leftLiftNum, int rightLiftNum) {
        intake = new VictorSPX(intakeNum);
        leftLift = new CANSparkMax(leftLiftNum, MotorType.kBrushless);
        rightLift = new CANSparkMax(rightLiftNum, MotorType.kBrushless);
    }

    public void setIntake(double speed) {
        intake.set(ControlMode.PercentOutput, speed);
    }

    public void setLift(double speed) {
        leftLift.set(-speed);
        rightLift.set(speed);
    }

    @Override
    public void periodic() {
        setDefaultCommand(new DumperCom());
    }
}
