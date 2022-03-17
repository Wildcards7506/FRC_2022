package frc.robot.Subsystems;

import frc.robot.Constants;
import frc.robot.Commands.DrivetrainCom;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;

import java.util.HashMap;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends SubsystemBase{
    private CANSparkMax motorLeft0;
    private CANSparkMax motorLeft1;
    private CANSparkMax motorRight0;
    private CANSparkMax motorRight1;

    private RelativeEncoder rightDrivetrain;
    private RelativeEncoder leftDrivetrain;

    private AHRS gyro = new AHRS(SPI.Port.kMXP);

    private DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Constants.kTRACK_WIDTH_IN_METERS);
    private Pose2d pose;
    private DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(getHeading(), pose);
    private SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(Constants.kS, Constants.kV);
    
    PIDController leftPIDController = new PIDController(Constants.kP,0,0);
    PIDController rightPIDController = new PIDController(Constants.kP,0,0);

    public Drivetrain (int mL0, int mL1, int mR0, int mR1){
        motorLeft0 = new CANSparkMax(mL0, MotorType.kBrushless);
        motorLeft1 = new CANSparkMax(mL1, MotorType.kBrushless);
        motorRight0 = new CANSparkMax(mR0, MotorType.kBrushless);
        motorRight1 = new CANSparkMax(mR1, MotorType.kBrushless);

        rightDrivetrain = motorLeft0.getEncoder();
        leftDrivetrain = motorRight0.getEncoder();
    }

    @Override
    public void periodic(){
        odometry.update( 
            gyro.getRotation2d(), 
            leftDrivetrain.getPosition() / 6 * 2 * Math.PI * Units.inchesToMeters(4), //get distance
            rightDrivetrain.getPosition() / 6 * 2 * Math.PI * Units.inchesToMeters(4) //get distance
        );
        setDefaultCommand(new DrivetrainCom());
    }

    public HashMap<String, Double> getEncoderValues()
    {
        HashMap<String, Double> encoderMap = new HashMap<String, Double>();
        encoderMap.put("rightDrivetrain", rightDrivetrain.getPosition());
        encoderMap.put("leftDrivetrain", leftDrivetrain.getPosition());
        return encoderMap;
    }

    public void setLeftDrivetrain(double speed){
        motorLeft0.set(speed);
        motorLeft1.set(speed);
    }

    public void setRightDrivetrain(double speed){
        motorRight0.set(-speed);
        motorRight1.set(-speed);
    }

    public void tankDriveVolts(double leftVolts, double rightVolts) {
        motorLeft0.setVoltage(leftVolts);
        motorLeft1.setVoltage(leftVolts);
        motorRight0.setVoltage(rightVolts);
        motorRight1.setVoltage(rightVolts);
    }

    public DifferentialDriveWheelSpeeds getSpeeds(){
        return new DifferentialDriveWheelSpeeds(
            leftDrivetrain.getVelocity() / 6 * 2 * Math.PI * Units.inchesToMeters(4) / 60, 
            rightDrivetrain.getVelocity() / 6 * 2 * Math.PI * Units.inchesToMeters(4) / 60
        ); 
    }

    public Rotation2d getHeading(){
        return gyro.getRotation2d();
    }

    public void trajSetOutput(double leftVolts, double rightVolts){
        setLeftDrivetrain(leftVolts/12);
        setRightDrivetrain(rightVolts/12);
    }

    public SimpleMotorFeedforward getFeedforward(){
        return feedforward;
    }

    public PIDController getLeftPIDController(){
        return leftPIDController;
    }

    public PIDController getRightPIDController(){
        return rightPIDController;
    }

    public DifferentialDriveKinematics getKinematics(){
        return kinematics;
    }

    public Pose2d getPose(){
        return odometry.getPoseMeters();
    }
}