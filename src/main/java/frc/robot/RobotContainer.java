// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.*;
import frc.robot.commands.*;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  private final Drivebase m_drivebase = new Drivebase();
  private final PS4Controller operator = new PS4Controller(0);
  private final JoystickButton r2 = new JoystickButton(operator, 0);
  private final JoystickButton m_triangle = new JoystickButton(operator, PS4Controller.Button.kTriangle.value);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    r2.whileTrue(new Drive(m_drivebase));
    m_triangle.onTrue(new DriveToDistance(m_drivebase));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
