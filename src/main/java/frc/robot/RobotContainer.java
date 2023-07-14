// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  private final Drive m_drive = new Drive();
  private static final PS4Controller controller = new PS4Controller(0);
  private static final JoystickButton R1 = new JoystickButton(controller, 5);
  private static final JoystickButton CIRCLE = new JoystickButton(controller, 2);
  

  public RobotContainer() {
    configureBindings();
    m_drive.setDefaultCommand(new Stop(m_drive));
  }

  private void configureBindings() {
    DriveCommand driveCommand = new DriveCommand(m_drive);
    DriveToDistance driveToDistance = new DriveToDistance(m_drive);
    R1.whileTrue(driveCommand);
    CIRCLE.onTrue(driveToDistance);
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
