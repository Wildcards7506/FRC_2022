package frc.robot.Autonomous;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;

import java.util.Arrays;

import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;

public class AutoCommand {

    public static Command trajectoryCommand(double linearMotion, double angle){
        TrajectoryConfig config = new TrajectoryConfig(2, Units.feetToMeters(2));
        config.setKinematics(Robot.drivetrain.getKinematics());

        Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
            Arrays.asList(new Pose2d(0.0,0.0,new Rotation2d(0)), new Pose2d(0.0,linearMotion, new Rotation2d(angle))), 
            config
        );

        RamseteCommand command = new RamseteCommand(
            trajectory, 
            Robot.drivetrain::getPose, 
            new RamseteController(2.0, 0.7), 
            Robot.drivetrain.getFeedforward(), 
            Robot.drivetrain.getKinematics(), 
            Robot.drivetrain::getSpeeds, 
            Robot.drivetrain.getLeftPIDController(), 
            Robot.drivetrain.getRightPIDController(), 
            Robot.drivetrain::trajSetOutput, 
            Robot.drivetrain
        );

        return command;
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

    public static void runIntake(double speed){
        Robot.intake.setHorizontalIntake(speed);
    }

    public static void limelightShoot(double power)
    {
        double degOff = Robot.limelight.getTX();
        while(Math.abs(degOff) > 1 && Robot.limelight.getTV() != 0)
        {
            double speed = .15 * degOff/(Math.abs(degOff));
            Robot.drivetrain.setLeftDrivetrain(-speed);
            Robot.drivetrain.setRightDrivetrain(speed);
            degOff = Robot.limelight.getTX();
        }
        Robot.drivetrain.setLeftDrivetrain(0);
        Robot.drivetrain.setRightDrivetrain(0);
        Robot.shooter.setShooterMotor(power);
        Timer.delay(2);
        Robot.intake.setVerticalIntake(-1);
        Timer.delay(.5);
        Robot.intake.setVerticalIntake(0);
        Robot.shooter.setShooterMotor(0);
    }
}
