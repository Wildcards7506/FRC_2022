package frc.robot.Autonomous;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;

public class AutoCommand {

    public AutoCommand() {
    }

    public static void shoot()
    {
        Robot.shooter.setShooterMotor(1);
        Timer.delay(2);
        Robot.intake.setVerticalIntake(1);
        Timer.delay(.5);
        Robot.intake.setVerticalIntake(0);
        Robot.shooter.setShooterMotor(0);
    }

    public static void limelightShoot()
    {
        double degOff = Robot.limelight.getTX();
        while(degOff > 1 || degOff < -1)
        {
            double speed = .05 * degOff;
            Robot.drivetrain.setLeftDrivetrain(speed < .1 ? .1 : -speed);
            Robot.drivetrain.setRightDrivetrain(speed < .1 ? -.1 : speed);
            degOff = Robot.limelight.getTX();
        }
        Robot.shooter.setShooterMotor(1);
        Timer.delay(2);
        Robot.intake.setVerticalIntake(1);
        Timer.delay(.5);
        Robot.intake.setVerticalIntake(0);
        Robot.shooter.setShooterMotor(0);
    }

    public static void drive(double power, double time)
    {
        
    }

    public static void turn(double power, double angle)
    {

    }
}
