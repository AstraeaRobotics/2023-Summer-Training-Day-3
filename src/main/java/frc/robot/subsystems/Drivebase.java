// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import edu.wpi.first.math.util.Units;
import com.revrobotics.RelativeEncoder;

public class Drivebase extends SubsystemBase {
  /** Creates a new Drivebase. */
  CANSparkMax l1, l2, r1, r2;
  MotorControllerGroup lMotor, rMotor;
  final double wheelDiam = 6;
  public Drivebase() {
    l1 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    l2 = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
    r1 = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
    r2 = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);

    lMotor = new MotorControllerGroup(l1, l2);
    rMotor = new MotorControllerGroup(r1, r2);

    lMotor.setInverted(true);
  }

  public void drive(double speed) {
    lMotor.set(speed);
    rMotor.set(speed);
  }

  public double getDistance() {
    l1.getEncoder().setPositionConversionFactor(Units.inchesToMeters(wheelDiam) * Math.PI);
    return l1.getEncoder().getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
