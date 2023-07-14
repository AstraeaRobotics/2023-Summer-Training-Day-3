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

  private final Drivetrain m_drivetrain = new Drivetrain();
  private final PS4Controller m_operator = new PS4Controller(0);

  // PS4 Buttons: https://www.reddit.com/r/Unity3D/comments/1syswe/ps4_controller_map_for_unity/
  private final JoystickButton r1 = new JoystickButton(m_operator, 5);
  private final JoystickButton circle = new JoystickButton(m_operator, 2);

  public RobotContainer() {
    m_drivetrain.setDefaultCommand(new Stop(m_drivetrain));
    configureBindings();
  }

  private void configureBindings() {
    r1.whileTrue(new DriveForward(m_drivetrain));
    circle.onTrue(new DriveToDistance(m_drivetrain));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
