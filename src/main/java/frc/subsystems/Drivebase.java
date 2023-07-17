// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.subsystems;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class Drivebase extends SubsystemBase {

  CANSparkMax rightMotor1;
  CANSparkMax rightMotor2;

  CANSparkMax leftMotor1;
  CANSparkMax leftMotor2;

  /** Creates a new DriveBaseSubsystem. */
  public Drivebase() {
    rightMotor1 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    rightMotor2 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    leftMotor1 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    leftMotor2 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    rightMotor1.getEncoder().setPosition(0);
    rightMotor2.getEncoder().setPosition(0);
    leftMotor1.getEncoder().setPosition(0);
    leftMotor2.getEncoder().setPosition(0);
    leftMotor1.getEncoder().setInverted(true);
    leftMotor2.getEncoder().setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double speed) {
    rightMotor1.set(speed);
    rightMotor2.set(speed);
    leftMotor1.set(speed);
    leftMotor2.set(speed);
  }

  public double getDistance() {
    rightMotor1.getEncoder().setPositionConversionFactor(Units.inchesToMeters(6) * Math.PI);
    return rightMotor1.getEncoder().getPosition();
  }
}