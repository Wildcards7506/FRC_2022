package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/* LimeLight specific Imports*/
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight extends SubsystemBase {

    public static final double kDistancePerRevolution = 18.84; // guestimate from your code
    public static final double kPulsesPerRevolution = 1024; // for an AS5145B Magnetic Encoder
    public static final double kDistancePerPulse = kDistancePerRevolution / kPulsesPerRevolution;

    // Creates a new LimeLight.
    NetworkTable table;
    NetworkTableEntry tx;
    NetworkTableEntry ty;
    NetworkTableEntry ta;
    NetworkTableEntry tv;
    double txDouble;
    NetworkTableEntry ledMode;

    public void updateData() {
        // update table, then update from updated table
        table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        tv = table.getEntry("tv");
        txDouble = tx.getDouble(0.0);
        ledMode = table.getEntry("ledMode");

        // read values periodically
        double limeV = tv.getDouble(0.0);
        double limeX = tx.getDouble(0.0);
        double limeY = ty.getDouble(0.0);
        double limeArea = ta.getDouble(0.0);

        SmartDashboard.putNumber("Detection", limeV);
        SmartDashboard.putNumber("LimelightX", limeX);
        SmartDashboard.putNumber("LimelightY", limeY);
        SmartDashboard.putNumber("LimelightArea", limeArea);
    }

    public double getTX() {
        return txDouble;
    }

    public double getTA() {
        return ta.getDouble(0.0);
    }

    public double getTV() {
        return tv.getDouble(0.0);
    }

    @Override
    public void periodic() {
        updateData();
        // This method will be called once per scheduler run
    }
}