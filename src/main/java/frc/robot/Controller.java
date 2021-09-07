package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class Controller {
    private static XboxController controller;

    public Controller(int controllerNumber) {
        controller = new XboxController(controllerNumber);
    }

    public boolean getTrigger(int triggerNumber) {
        double trigger = controller.getRawAxis(triggerNumber);
        if(trigger > -.25)
            return false;
        return true;
    }

    public double getJoystickAxis(int axisNumber) {
        double joystick = controller.getRawAxis(axisNumber);
        if(Math.abs(joystick) < .1){
            return 0;
        }
        return joystick;
    }

    public boolean getButton(int buttonNumber) {
        return controller.getRawButton(buttonNumber);
    }

    public int getPOV(){
        return controller.getPOV();
    }
}
