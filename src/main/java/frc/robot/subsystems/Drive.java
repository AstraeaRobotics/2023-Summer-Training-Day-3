// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.RelativeEncoder;

public class Drive extends SubsystemBase {

  CANSparkMax leftMotor1 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax leftMotor2 = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightMotor1 = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightMotor2 = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);
  MotorControllerGroup leftMotor = new MotorControllerGroup(leftMotor1, leftMotor2);
  MotorControllerGroup rightMotor = new MotorControllerGroup(rightMotor1, rightMotor2);




  public void drive(double speed){
    leftMotor.set(-speed);
    rightMotor.set(speed);
  }
  
  public double getDistance(){
    return leftMotor1.getEncoder().getPosition();

  }
  public Drive() {
    leftMotor1.getEncoder().setPosition(0);
    leftMotor2.getEncoder().setPosition(0);
    rightMotor1.getEncoder().setPosition(0);
    rightMotor2.getEncoder().setPosition(0);

    leftMotor1.getEncoder().setPositionConversionFactor(Units.inchesToMeters(6) * Math.PI);
    leftMotor2.getEncoder().setPositionConversionFactor(Units.inchesToMeters(6) * Math.PI);
    rightMotor1.getEncoder().setPositionConversionFactor(Units.inchesToMeters(6) * Math.PI);
    rightMotor2.getEncoder().setPositionConversionFactor(Units.inchesToMeters(6) * Math.PI);

    leftMotor1.getEncoder().setInverted(true);
    leftMotor2.getEncoder().setInverted(true);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
