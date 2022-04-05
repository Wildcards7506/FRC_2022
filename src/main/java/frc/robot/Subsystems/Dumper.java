package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Commands.DumperCom;

public class Dumper extends SubsystemBase{

    private VictorSPX intake;
    private CANSparkMax leftLift;
    private CANSparkMax rightLift;
    private RelativeEncoder leftLiftEncoder;
    private RelativeEncoder rightLiftEncoder;

    private double setpoint;

    public Dumper(int intakeNum, int leftLiftNum, int rightLiftNum) {
        intake = new VictorSPX(intakeNum);
        leftLift = new CANSparkMax(leftLiftNum, MotorType.kBrushless);
        rightLift = new CANSparkMax(rightLiftNum, MotorType.kBrushless);

        leftLiftEncoder = leftLift.getEncoder();
        rightLiftEncoder = rightLift.getEncoder();
    }

    public void setIntake(double speed) {
        intake.set(ControlMode.PercentOutput, speed);
    }

    public void setLift(double speed) {
        if(speed == 0 && leftLift.get() != 0){
            setpoint = leftLiftEncoder.getPosition();
            leftLift.set(0);
            rightLift.set(0);
        } else if(speed != 0) {
            leftLift.set(speed);
            rightLift.set(-speed);
        } else {
            double proportionalGain = .2;
            double output = proportionalGain * (setpoint - leftLiftEncoder.getPosition());
            output = output < .2 ? output : .2;
            leftLift.set(output);
            rightLift.set(-output);
        }
    }

    public void encoderMatchDumper(double speed, int direction){
        double encoderDifference = rightLiftEncoder.getPosition() - leftLiftEncoder.getPosition();
        this.setLift(direction + ((encoderDifference * speed) > 1 ? (encoderDifference * speed) : 1));
        // this.setRightLift(direction - ((encoderDifference * speed) > 1 ? (encoderDifference * speed) : 1));
    }

    // public double getRightDumperEncoder(){
    //     return rightDumperLiftEncoder.getPosition();
    // }
    
    @Override
    public void periodic() {
        setDefaultCommand(new DumperCom());
    }
}
