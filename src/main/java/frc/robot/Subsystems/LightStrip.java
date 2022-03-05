// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LightStrip extends SubsystemBase {
  /** Creates a new LightStrip. */
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
    SmartDashboard.putString("LightMode", "RED");
    for (var i = 0; i < ledBuffer.getLength(); i++){
      ledBuffer.setHSV(i, 0, 255, 255);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
