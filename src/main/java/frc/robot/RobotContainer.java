// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class RobotContainer {

  PS4Controller driverGamepad = new PS4Controller(0);
  DrivebaseSubsystem drivebaseSubsystem = new DrivebaseSubsystem();
  JoystickButton button1 = new JoystickButton(driverGamepad, PS4Controller.Button.kCross.value);

  public RobotContainer() {
    configureBindings();

  }

  private void configureBindings() {
    new Drive(drivebaseSubsystem, driverGamepad.getLeftY(), driverGamepad.getRightY(), driverGamepad.getLeftY(), driverGamepad.getRightY());
    button1.onTrue(new DriveToDistance(drivebaseSubsystem));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
