// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Drive extends SubsystemBase {

  CANSparkMax leftMotor1 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax leftMotor2 = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightMotor1 = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightMotor2 = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);
  MotorControllerGroup leftMotor = new MotorControllerGroup(leftMotor1, leftMotor2);
  MotorControllerGroup rightMotor = new MotorControllerGroup(rightMotor1, rightMotor2);


  public void drive(double speed){
    
  }
  public Drive() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
