package frc.robot;

public class Constants {
    //Drivetrain
    public static final int LEFT_DRIVE_TRAIN_0 = 19;
    public static final int LEFT_DRIVE_TRAIN_1 = 20;
    public static final int RIGHT_DRIVE_TRAIN_0 = 1;
    public static final int RIGHT_DRIVE_TRAIN_1 = 2;

    //Climbers
    public static final int LEFT_CLIMBER_0 = 9;
    public static final int LEFT_CLIMBER_1 = 12;
    public static final int LEFT_CLIMBER_ROTATE = 18;
    public static final int RIGHT_CLIMBER_0 = 10;
    public static final int RIGHT_CLIMBER_1 = 11;
    public static final int RIGHT_CLIMBER_ROTATE = 3;

    //Shooter
    public static final int SHOOTER = 15;

    //Intake
    public static final int VERTICAL_INTAKE = 6;
    public static final int HORIZONTAL_INTAKE = 17;
    public static final int INTAKE_LIFT = 5;

    //Dumper
    public static final int DUMPER_INTAKE = 17;
    public static final int LEFT_DUMPER_LIFT = 5;
    public static final int RIGHT_DUMPER_LIFT = 15;

    //Lights
    public static final int NUM_LIGHTS = 57;

    //Controller Assignments
    public static final int DRIVER_CONTROLLER_0 = 0;
    public static final int DRIVER_CONTROLLER_1 = 1;
    
    //Control Axis
    public static final int LEFT_STICK_X = 0;
    public static final int LEFT_STICK_Y = 1;
    public static final int LEFT_TRIGGER = 2;
    public static final int RIGHT_TRIGGER = 3;
    public static final int RIGHT_STICK_X = 4;
    public static final int RIGHT_STICK_Y = 5;

    //Control D-Pad
    public static final int DPAD_X = 2;
    public static final int DPAD_Y = 3;

    //Control Buttons
    public static final int BUTTON_A = 1;
    public static final int BUTTON_B = 2;
    public static final int BUTTON_X = 3;
    public static final int BUTTON_Y = 4;
    public static final int LEFT_BUMPER = 5;
    public static final int RIGHT_BUMPER = 6;
    public static final int BUTTON_BACK = 7;
    public static final int BUTTON_START = 8;
    public static final int LEFT_JOYSTICK_BUTTON = 9;
    public static final int RIGHT_JOYSTICK_BUTTON = 10;

    //Speed Variables
    public static final double MAX_DRIVE_SPEED = .5; // Min = 0, Max = 1
    public static final double FULL_SPEED = 1;
    public static final double SLOW_SPEED = .4;
    public static final double CLIMBER_ROTATION_SPEED = .25;
    public static final double CLIMBER_ROTATION_STATIC = -.02;
    public static final double MAX_TURN_SPEED = 1; // Min = 0, Max = 1;
    public static final double LEFT_RIGHT_TRIM = -.1; // Min = -1, Max = 1;+
    public static final double INTAKE_LIFT_SPEED = .20;
    public static final double HORIZONTAL_INTAKE_SPEED = -.8;
    public static final double VERTICAL_INTAKE_SPEED = 1;
    public static final double DUMPER_INTAKE_SPEED = 1;
    public static final double DUMPER_OUTPUT_SPEED = -1;
    public static final double DUMPER_LIFT_SPEED = .3;
    public static final double DUMPER_LOWER_SPEED = -.1;
    public static final double kV = 0.34464;
    public static final double kS = 0.63969;
    public static final double kP = 3.9966;
}