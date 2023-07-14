// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  CANSparkMax leftFront = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax leftBack = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightFront = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightBack = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);

  MotorControllerGroup leftMotors = new MotorControllerGroup(leftFront, leftBack);
  MotorControllerGroup rightMotors = new MotorControllerGroup(rightFront, rightBack);

  public Drivetrain() {
    leftFront.getEncoder().setPosition(0);
    leftBack.getEncoder().setPosition(0);
    rightFront.getEncoder().setPosition(0);
    rightBack.getEncoder().setPosition(0);

    leftFront.getEncoder().setPositionConversionFactor(Units.inchesToMeters(6)*Math.PI);
    rightFront.getEncoder().setPositionConversionFactor(Units.inchesToMeters(6)*Math.PI);
    leftBack.getEncoder().setPositionConversionFactor(Units.inchesToMeters(6)*Math.PI);
    rightBack.getEncoder().setPositionConversionFactor(Units.inchesToMeters(6)*Math.PI);

    leftFront.getEncoder().setInverted(true);
    leftBack.getEncoder().setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double speed){
    leftMotors.set(-speed); // Inverted motor group
    rightMotors.set(speed);
  }

  public double getDistance(){
    return leftFront.getEncoder().getPosition();
  }
}

