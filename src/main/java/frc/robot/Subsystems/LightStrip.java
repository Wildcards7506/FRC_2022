package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Commands.LightStripCom;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LightStrip extends SubsystemBase {
  // Creates a new LightStrip.
  private AddressableLED led;
  public AddressableLEDBuffer ledBuffer;

  public LightStrip(int port, int bufferSize) {
    led = new AddressableLED(port);
    ledBuffer = new AddressableLEDBuffer(bufferSize);
    led.setLength(ledBuffer.getLength());
    led.setData(ledBuffer);
    led.start();
  }

  public void preMatch(){
    for (var i = 0; i < ledBuffer.getLength(); i++){
      ledBuffer.setHSV(i, 100, 100, 100);
      SmartDashboard.putString("LightMode", "RED");
    }

    led.setData(ledBuffer);
  }

  @Override
  public void periodic() {
    setDefaultCommand(new LightStripCom());
  }
}
