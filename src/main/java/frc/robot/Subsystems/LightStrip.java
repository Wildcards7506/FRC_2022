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

  // Shooter lights
  public void preMatch(){
    int greenHue = 60;
    int yellowHue = 20;
    int sat = 255;
    double time = .005;
    for(int i = 1; i < ledBuffer.getLength(); i++){
      for(int j = 0; j < ledBuffer.getLength(); j++){
        ledBuffer.setHSV(j, greenHue, sat, 255);
        Timer.delay(time);
      }
      led.setData(ledBuffer);
      
      for(int k = 0; k < ledBuffer.getLength(); k++){
        ledBuffer.setHSV(k, yellowHue, sat, 255);
        Timer.delay(time);
      }
      led.setData(ledBuffer);

      for(int k = 0; k < ledBuffer.getLength(); k++){
        ledBuffer.setHSV(k, 250, sat, 255);
        Timer.delay(time);
      }
      led.setData(ledBuffer);
    }
  }

  public void idle(int color){
    if(color == 0){
      for(int k = 0; k < ledBuffer.getLength(); k++){
        ledBuffer.setHSV(k, 0, 255, 255);
        led.setData(ledBuffer);
      }  
    } else if (color == 1){
      for(int k = 0; k < ledBuffer.getLength(); k++){
        ledBuffer.setHSV(k, 110, 255, 255);
        led.setData(ledBuffer);
      }  
    }  
  }

  public void aiming(){
    for(int k = 0; k < ledBuffer.getLength(); k++){
      ledBuffer.setHSV(k, 20, 255, 255);
      led.setData(ledBuffer);
    }
  }

  public void targetLocked(){
    for(int j = 0; j < ledBuffer.getLength(); j++){
      ledBuffer.setHSV(j, 60, 255, 255);
      led.setData(ledBuffer);
    }
  }

  // Climber lights
  public void armsAreVertical(){
    for(int j = 0; j < ledBuffer.getLength(); j++){
      ledBuffer.setHSV(j, 0, 0, 255);
      led.setData(ledBuffer);
    }
  }

  public void armsAreRotating(){
    for(int j = 0; j < ledBuffer.getLength(); j++){
      ledBuffer.setHSV(j, 20, 255, 255);
      led.setData(ledBuffer);
    }
  }

  public void armsAreExtending(){
    int greenHue = 60;
    int yellowHue = 20;
    int sat = 255;
    double time = .005;
    for(int i = 1; i < ledBuffer.getLength(); i++){
      for(int j = 0; j < ledBuffer.getLength(); j++){
        ledBuffer.setHSV(j, greenHue, sat, 255);
        Timer.delay(time);
        led.setData(ledBuffer);
      }
      
      for(int k = 0; k < ledBuffer.getLength(); k++){
        ledBuffer.setHSV(k, yellowHue, sat, 255);
        Timer.delay(time);
        led.setData(ledBuffer);
      }

      for(int k = 0; k < ledBuffer.getLength(); k++){
        ledBuffer.setHSV(k, 250, sat, 255);
        Timer.delay(time);
        led.setData(ledBuffer);
      }
    }
  }

  public void fullyExtendedOrRetracted(){
    for(int j = 0; j < ledBuffer.getLength(); j++){
      ledBuffer.setHSV(j, 60, 255, 255);
      led.setData(ledBuffer);
    }
  }

  @Override
  public void periodic() {
    setDefaultCommand(new LightStripCom());
  }
}
