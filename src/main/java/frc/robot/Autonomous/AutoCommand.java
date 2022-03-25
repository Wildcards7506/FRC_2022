package frc.robot.Autonomous;

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

    public static void lowerIntake(){
        Robot.intake.setIntakeLift(-Constants.INTAKE_LIFT_SPEED);
        Timer.delay(1);
        Robot.intake.setIntakeLift(0);
    }
    
    public static void drive(double power, double time) {
        Robot.drivetrain.setRightDrivetrain(power);
        Robot.drivetrain.setLeftDrivetrain(power);
        Timer.delay(time);
        Robot.drivetrain.setRightDrivetrain(0);
        Robot.drivetrain.setLeftDrivetrain(0);
    }

    public static void rotate(double angle){
        double degOff = Math.abs(angle) - Math.abs(Robot.drivetrain.getAngle());
        while(Math.abs(degOff) > 1)
        {
            double speed = .15 * degOff/(Math.abs(degOff));
            Robot.drivetrain.setLeftDrivetrain(-speed);
            Robot.drivetrain.setRightDrivetrain(speed);
            degOff = Math.abs(angle) - Math.abs(Robot.drivetrain.getAngle());
        }
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
        Timer.delay(4);
        Robot.intake.setVerticalIntake(-1);
        Timer.delay(.5);
        Robot.intake.setVerticalIntake(0);
        Robot.shooter.setShooterMotor(0);
    }
}
