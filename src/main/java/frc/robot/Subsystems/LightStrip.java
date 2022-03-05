package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Commands.LightStripCom;
import edu.wpi.first.wpilibj.Timer;

public class LightStrip extends SubsystemBase {
  // Creates a new LightStrip.
  private AddressableLED led;
  private AddressableLEDBuffer ledBuffer;

  public LightStrip(int port, int bufferSize) {
    led = new AddressableLED(port);
    ledBuffer = new AddressableLEDBuffer(bufferSize);
    led.setLength(ledBuffer.getLength());
    led.setData(ledBuffer);
    led.start();
  }

  public void preMatch(){
    boolean set = false;
    for (int i = 1; i <= ledBuffer.getLength(); i++){
        if (i == 1){
          ledBuffer.setHSV(0, 100, 100, 100);
        } else if (ledBuffer.getLED(i - 1).red != 0 && !set){
          ledBuffer.setHSV(i - 1, 100, 100, 100);
          set = true;
        } else {
          ledBuffer.setHSV(i - 1, 0, 0, 0);
        }
    }
    Timer.delay(.1);
    led.setData(ledBuffer);
  }

  @Override
  public void periodic() {
    setDefaultCommand(new LightStripCom());
  }
}
