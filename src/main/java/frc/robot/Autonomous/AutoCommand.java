package frc.robot.Autonomous;

import java.util.HashMap;

// import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.RamseteCommand;

// import java.util.Arrays;

// import edu.wpi.first.math.controller.RamseteController;
// import edu.wpi.first.math.geometry.Pose2d;
// import edu.wpi.first.math.geometry.Rotation2d;
// import edu.wpi.first.math.trajectory.Trajectory;
// import edu.wpi.first.math.trajectory.TrajectoryConfig;
// import edu.wpi.first.math.trajectory.TrajectoryGenerator;
// import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;
import frc.robot.Robot;

public class AutoCommand {

    private static HashMap<String, Double> drivetrainEncoderValues;

    // public static void shoot()
    // {
    //     Robot.shooter.setShooterMotor(1);
    //     Timer.delay(2);
    //     Robot.shooterIntake.setVerticalIntake(1);
    //     Timer.delay(.5);
    //     Robot.shooterIntake.setVerticalIntake(0);
    //     Robot.shooter.setShooterMotor(0);
    // }

    // public static void runIntake(double speed){
    //     Robot.shooterIntake.setHorizontalIntake(speed);
    // }

    // public static void lowerIntake(){
    //     Robot.shooterIntake.setIntakeLift(-Constants.INTAKE_LIFT_SPEED);
    //     Timer.delay(1);
    //     Robot.shooterIntake.setIntakeLift(0);
    // }
    
    public static void drive(double power, double time) {
        Robot.drivetrain.setRightDrivetrain(power);
        Robot.drivetrain.setLeftDrivetrain(power);
        Timer.delay(time);
        Robot.drivetrain.setRightDrivetrain(0);
        Robot.drivetrain.setLeftDrivetrain(0);
    }

    public static void drive(double distanceInInches){
        updateEncoderValues();
        //6:1, 4 inch radius
        double current = 0;
        double target = (distanceInInches / (2 * Math.PI * 4) * 6) + drivetrainEncoderValues.get("leftDrivetrain");
        while(current < target){
            updateEncoderValues();
            current = drivetrainEncoderValues.get("leftDrivetrain");
            double speed = target / current * .1;
            speed = speed < .15 ? .15 : speed;
            Robot.drivetrain.setLeftDrivetrain(speed);
            Robot.drivetrain.setRightDrivetrain(speed);
        }
        Robot.drivetrain.setRightDrivetrain(0);
        Robot.drivetrain.setLeftDrivetrain(0);
    }

    public static void rotate(double angle){
        Robot.drivetrain.resetGyro();
        double degOff = Math.abs(angle) - Math.abs(Robot.drivetrain.getAngle());
        while(Math.abs(degOff) > 1)
        {
            double speed = .3 * degOff/(Math.abs(degOff));
            Robot.drivetrain.setLeftDrivetrain(speed);
            Robot.drivetrain.setRightDrivetrain(-speed);
            degOff = Math.abs(angle) - Math.abs(Robot.drivetrain.getAngle());
            Robot.drivetrain.updateDashboard();
        }
    }   

    // public static void limelightShoot(double power)
    // {
    //     double degOff = Robot.limelight.getTX();
    //     while(Math.abs(degOff) > 1 && Robot.limelight.getTV() != 0)
    //     {
    //         double speed = .15 * degOff/(Math.abs(degOff));
    //         Robot.drivetrain.setLeftDrivetrain(-speed);
    //         Robot.drivetrain.setRightDrivetrain(speed);
    //         degOff = Robot.limelight.getTX();
    //     }
    //     Robot.drivetrain.setLeftDrivetrain(0);
    //     Robot.drivetrain.setRightDrivetrain(0);
    //     Robot.shooter.setShooterMotor(power);
    //     Timer.delay(4);
    //     Robot.shooterIntake.setVerticalIntake(-1);
    //     Timer.delay(.5);
    //     Robot.shooterIntake.setVerticalIntake(0);
    //     Robot.shooter.setShooterMotor(0);
    // }

    public static void holdDumperLift() {
        Robot.dumper.setLift(Constants.DUMPER_LIFT_SPEED);
        Timer.delay(2);
    }

    public static void runDumperLift() {
        Robot.dumper.setLift(.2);
        Timer.delay(.5);
        Robot.dumper.setLift(Constants.DUMPER_LOWER_SPEED);
        Timer.delay(2);
        Robot.dumper.setLift(0);
    }

    public static void runDumperIntake(double speed) {
        Robot.dumper.setIntake(speed);
        Timer.delay(2);
    }

    public static void updateEncoderValues() {
        drivetrainEncoderValues = Robot.drivetrain.getEncoderValues();
    }
}