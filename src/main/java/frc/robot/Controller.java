package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class Controller {
    private XboxController xboxController;

    public Controller(int controller) {
        xboxController = new XboxController(controller);
    }

    public boolean getTrigger(int triggerNumber) {
        boolean trigger = (xboxController.getRawAxis(triggerNumber) < .25) ? false : true;
        return trigger;
    }

    public double getJoystickAxis(int axisNumber) {
        double joystick = (Math.abs(xboxController.getRawAxis(axisNumber)) < .1) ? 0 : xboxController.getRawAxis(axisNumber);
        return joystick;
    }

    public boolean getButton(int buttonNumber) {
        return xboxController.getRawButton(buttonNumber);
    }

    public int getPOV(){
        return xboxController.getPOV();
    }
}
