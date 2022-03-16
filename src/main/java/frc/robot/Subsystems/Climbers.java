package frc.robot.Subsystems;

import java.util.HashMap;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Commands.ClimbersCom;

public class Climbers extends SubsystemBase{
    private CANSparkMax leftClimber0;
    private CANSparkMax leftClimber1;
    private CANSparkMax leftClimberRotate;
    private CANSparkMax rightClimber0;
    private CANSparkMax rightClimber1;
    private CANSparkMax rightClimberRotate;
    private RelativeEncoder climberEncoderRight;
    private RelativeEncoder rightRotateEncoder;
    private RelativeEncoder climberEncoderLeft;
    private RelativeEncoder leftRotateEncoder;


    public Climbers(int climberL0, int climberL1, int climberLR, int climberR0, int climberR1, int climberRR) {
        leftClimber0 = new CANSparkMax(climberL0, MotorType.kBrushless);
        leftClimber1 = new CANSparkMax(climberL1, MotorType.kBrushless);
        leftClimberRotate = new CANSparkMax(climberLR, MotorType.kBrushless);
        rightClimber0 = new CANSparkMax(climberR0, MotorType.kBrushless);
        rightClimber1 = new CANSparkMax(climberR1, MotorType.kBrushless);
        rightClimberRotate = new CANSparkMax(climberRR, MotorType.kBrushless);
        
        climberEncoderLeft = leftClimber0.getEncoder();
        climberEncoderRight = rightClimber0.getEncoder();
        rightRotateEncoder = rightClimberRotate.getEncoder();
        leftRotateEncoder = leftClimberRotate.getEncoder();

        // leftClimberRotate.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward,true);
        // leftClimberRotate.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse,true);
        // rightClimberRotate.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward,true);
        // rightClimberRotate.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse,true);

        // leftClimber0.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, true);
        // leftClimber1.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, true);
        // rightClimber0.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, true);
        // rightClimber1.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, true);
        // leftClimber0.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, true);
        // leftClimber1.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, true);
        // rightClimber0.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, true);
        // rightClimber1.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, true);

        // leftClimberRotate.setSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, (float) -4);
        // rightClimberRotate.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, (float) 4);

        // leftClimber0.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, 270);
        // leftClimber0.setSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, 0);
        // rightClimber0.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, 270);
        // rightClimber0.setSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, 0);
        // leftClimber1.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, 270);
        // leftClimber1.setSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, 0);
        // rightClimber1.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, 270);
        // rightClimber1.setSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, 0);
    }

    public HashMap<String, Double> getEncoderValues() {
        HashMap<String, Double> encoderMap =  new HashMap<String, Double>();
        encoderMap.put("leftClimberEncoder", climberEncoderLeft.getPosition());
        encoderMap.put("rightClimberEncoder", climberEncoderRight.getPosition());
        encoderMap.put("leftRotationEncoder", leftRotateEncoder.getPosition());
        encoderMap.put("rightRotationEncoder", rightRotateEncoder.getPosition());
        return encoderMap;
    }

    public void setLeftClimber(double speed){
        leftClimber0.set(-speed);
        leftClimber1.set(-speed);
    }

    public void setRightClimber(double speed){
        rightClimber0.set(-speed);
        rightClimber1.set(-speed);
    }

    public void setClimberRotation(double speed)
    {
        leftClimberRotate.set(-speed);
        rightClimberRotate.set(speed);
    }

    public void updateDashboard()
    {
        SmartDashboard.putNumber("Right Climber Position ", climberEncoderRight.getPosition());
        SmartDashboard.putNumber("Left Climber Position ", climberEncoderLeft.getPosition());
        SmartDashboard.putNumber("Left Rotator Position ", leftRotateEncoder.getPosition());
        SmartDashboard.putNumber("Right Rotator Position ", rightRotateEncoder.getPosition());
        SmartDashboard.putNumber("Left Rotator Current ", leftClimberRotate.getOutputCurrent());
        SmartDashboard.putNumber("Right Rotator Current ", rightClimberRotate.getOutputCurrent());

    }

    public void encoderMatch(double speed, int direction){
        double encoderDifference = climberEncoderRight.getPosition() - climberEncoderLeft.getPosition();
        this.setLeftClimber(direction + ((encoderDifference * speed) > 1 ? (encoderDifference * speed) : 1));
        this.setRightClimber(direction - ((encoderDifference * speed) > 1 ? (encoderDifference * speed) : 1));
    }

    @Override
    public void periodic(){
        setDefaultCommand(new ClimbersCom());
    }
}
