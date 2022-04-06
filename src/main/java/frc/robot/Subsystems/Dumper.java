package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Commands.DumperCom;

public class Dumper extends SubsystemBase{

    private VictorSPX intake;
    private CANSparkMax leftLift;
    private CANSparkMax rightLift;
    private RelativeEncoder leftDumperLiftEncoder;
    private RelativeEncoder rightDumperLiftEncoder;

    public Dumper(int intakeNum, int leftLiftNum, int rightLiftNum) {
        intake = new VictorSPX(intakeNum);
        leftLift = new CANSparkMax(leftLiftNum, MotorType.kBrushless);
        rightLift = new CANSparkMax(rightLiftNum, MotorType.kBrushless);

        leftDumperLiftEncoder = leftLift.getEncoder();
        rightDumperLiftEncoder = rightLift.getEncoder();

        leftLift.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, true);
        leftLift.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, true);
        rightLift.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, true);
        rightLift.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, true);

        leftLift.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, 3);
        leftLift.setSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, -20);
        rightLift.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, 20);
        rightLift.setSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, -3);
    }

    public void updateDashboard()
    {
        SmartDashboard.putNumber("Left Dumper Position", leftDumperLiftEncoder.getPosition());
        SmartDashboard.putNumber("Right Dumper Position", rightDumperLiftEncoder.getPosition());
    }

    public void setIntake(double speed) {
        intake.set(ControlMode.PercentOutput, speed);
    }

    public void setLift(double speed) {
        leftLift.set(speed);
        rightLift.set(-speed);
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
