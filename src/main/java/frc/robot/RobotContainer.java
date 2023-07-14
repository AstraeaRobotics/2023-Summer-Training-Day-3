// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


import frc.robot.subsystems.DriveBaseSubsystem;
import frc.robot.commands.DrivetoDistance;

public class RobotContainer {
  private final PS4Controller controller = new PS4Controller(0);
  private final JoystickButton circle = new JoystickButton(controller, 2);
  private final DriveBaseSubsystem drivebaseSubsystem = new DriveBaseSubsystem();
  

  public RobotContainer() {
    configureBindings();
    drivebaseSubsystem.setDefaultCommand(new DrivetoDistance(drivebaseSubsystem));
  }

  private void configureBindings() {
    circle.onTrue(new DrivetoDistance(drivebaseSubsystem));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
