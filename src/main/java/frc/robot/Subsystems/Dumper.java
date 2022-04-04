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
    private RelativeEncoder leftDumperLiftEncoder;
    private RelativeEncoder rightDumperLiftEncoder;

    private double recordedEncoder;

    public Dumper(int intakeNum, int leftLiftNum, int rightLiftNum) {
        intake = new VictorSPX(intakeNum);
        leftLift = new CANSparkMax(leftLiftNum, MotorType.kBrushless);
        rightLift = new CANSparkMax(rightLiftNum, MotorType.kBrushless);

        leftDumperLiftEncoder = leftLift.getEncoder();
        rightDumperLiftEncoder = rightLift.getEncoder();
    }

    public void setIntake(double speed) {
        intake.set(ControlMode.PercentOutput, speed);
    }

    public void setLift(double speed) {
        if(speed == 0 && leftLift.get() != 0){
            recordedEncoder = leftDumperLiftEncoder.getPosition();
            leftLift.set(0);
            rightLift.set(0);
        } else if (speed == 0) {
            if(leftDumperLiftEncoder.getPosition() > 5 + recordedEncoder || leftDumperLiftEncoder.getPosition() < recordedEncoder - 5 )
            {
                double diffSpeed = (recordedEncoder - leftDumperLiftEncoder.getPosition()) * -.05;
                diffSpeed = diffSpeed > .2 ? .2 : diffSpeed;
                leftLift.set(diffSpeed);
                rightLift.set(-diffSpeed);
            } else {
                leftLift.set(0);
                rightLift.set(0);
            }
        } else {
            leftLift.set(speed);
            rightLift.set(-speed);
        }
    }

    public void encoderMatchDumper(double speed, int direction){
        double encoderDifference = rightDumperLiftEncoder.getPosition() - leftDumperLiftEncoder.getPosition();
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
