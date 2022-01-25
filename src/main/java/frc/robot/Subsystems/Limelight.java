package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Commands.LimelightCom;
/* LimeLight specific Imports*/
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight extends SubsystemBase {

    public static final double kDistancePerRevolution = 18.84; // guestimate from your code
    public static final double kPulsesPerRevolution = 1024; // for an AS5145B Magnetic Encoder
    public static final double kDistancePerPulse = kDistancePerRevolution / kPulsesPerRevolution;

    // Creates a new LimeLight.
    private NetworkTable table;
    private NetworkTableEntry tx;
    // private NetworkTableEntry ty;
    private NetworkTableEntry ta;
    private NetworkTableEntry tv;
    // private NetworkTableEntry ledMode;

    public void updateData() {
        // update table, then update from updated table
        table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
        ta = table.getEntry("ta");
        tv = table.getEntry("tv");
    }

    public double getTX() {
        return tx.getDouble(0.0);
    }

    public double getTA() {
        return ta.getDouble(0.0);
    }

    public double getTV() {
        return tv.getDouble(0.0);
    }

    public void switchCameraMode(){
        table.getEntry("camMode").setNumber(table.getEntry("camMode").getDouble(0.0) == 0 ? 1 : 0);
        // table.getEntry("camMode").setNumber(1);
    }

    @Override
    public void periodic() {
        setDefaultCommand(new LimelightCom());
        // This method will be called once per scheduler run
    }
}