// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class DriveBaseSubsystem extends SubsystemBase {
  /** Creates a new DriveBaseSubsystem. */

  CANSparkMax motor1;
  CANSparkMax motor2;
  CANSparkMax motor3;
  CANSparkMax motor4;

  public DriveBaseSubsystem() {
    motor1 = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
    motor2 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    motor3 = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
    motor4 = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
