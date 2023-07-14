// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;


public class DriveBaseSubsystem extends SubsystemBase {

  CANSparkMax rightM1;
  CANSparkMax rightM2;
  CANSparkMax leftM1;
  CANSparkMax leftM2;
  /** Creates a new DriveBaseSubsystem. */
  public DriveBaseSubsystem() {
    rightM1 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    rightM2 = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
    leftM1 = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
    leftM2 = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);

    rightM1.getEncoder().setPosition(0);
    rightM2.getEncoder().setPosition(0);
    leftM1.getEncoder().setPosition(0);
    leftM2.getEncoder().setPosition(0);

    leftM1.getEncoder().setInverted(true);
    leftM2.getEncoder().setInverted(true);

  }

  public void drive(double speed) {
    rightM1.set(speed);
    rightM2.set(speed);
    leftM1.set(speed);
    leftM2.set(speed);

  }

  public double getDistance() {
    rightM1.getEncoder().setPositionConversionFactor(Units.InchestoMeters(6) * Math.PI);
    return rightM1.getEncoder().getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
