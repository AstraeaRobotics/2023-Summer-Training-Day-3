// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;


public class DrivebaseSubsystem extends SubsystemBase {
  /** Creates a new DrivebaseSubsystem. */
  CANSparkMax frontLeft;
  CANSparkMax frontRight;
  CANSparkMax backLeft;
  CANSparkMax backRight;

  final double TICKS_PER_REVOLUTION;
  final double WHEEL_DIAMETER_INCHES;
  final double WHEEL_CIRCUMFERENCE_INCHES;
  final double TICKS_PER_INCH;
  final double TICKS_PER_CENTIMETER;

  
  public DrivebaseSubsystem() {
    frontLeft = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    backLeft = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
    frontRight = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
    backRight = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);

    TICKS_PER_REVOLUTION = frontLeft.getEncoder().getCountsPerRevolution();
    WHEEL_DIAMETER_INCHES = 6;
    WHEEL_CIRCUMFERENCE_INCHES = WHEEL_DIAMETER_INCHES*Math.PI;
    TICKS_PER_INCH = TICKS_PER_REVOLUTION/WHEEL_CIRCUMFERENCE_INCHES;
    TICKS_PER_CENTIMETER = TICKS_PER_INCH*Units.inchesToMeters(1)*100;
    EncoderReset();
  }


  public void DRIVE(double FL, double FR, double BL, double BR) {
    frontLeft.set(FL);
    frontRight.set(FR);
    backLeft.set(BL);
    backRight.set(BR);
  }

  public void REST() {
    frontLeft.set(0);
    frontRight.set(0);
    backLeft.set(0);
    backRight.set(0);
  }

  public void EncoderReset() {
    frontLeft.getEncoder().setPosition(0);
    frontRight.getEncoder().setPosition(0);
    backLeft.getEncoder().setPosition(0);
    backRight.getEncoder().setPosition(0);
  }

  public void DriveToDistance(double Distance_In_Centimeters) {
    frontLeft.getEncoder().setPosition(Distance_In_Centimeters * TICKS_PER_CENTIMETER);
    frontLeft.getEncoder().setPosition(Distance_In_Centimeters * TICKS_PER_CENTIMETER);
    frontLeft.getEncoder().setPosition(Distance_In_Centimeters * TICKS_PER_CENTIMETER);
    frontLeft.getEncoder().setPosition(Distance_In_Centimeters * TICKS_PER_CENTIMETER);
  }
  
  public double getFLEncoder() {
    return frontLeft.getEncoder().getPosition();
  }
  public double getFREncoder() {
    return frontRight.getEncoder().getPosition();
  }
  public double getBLEncoder() {
    return backLeft.getEncoder().getPosition();
  }
  public double getBREncoder() {
    return backRight.getEncoder().getPosition();
  }

  
  public double getAvgEncoderValue() {
    return (getFLEncoder() + getFREncoder() + getBLEncoder() + getBREncoder())/4;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
