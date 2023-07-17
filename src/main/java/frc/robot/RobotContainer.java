// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class RobotContainer {
  private final PS4Controller controller = new PS4Controller(0);
  private final JoystickButton r2 = new JoystickButton(controller, 7);
  private final Drivebase drivesub = new Drivebase();

  public RobotContainer() {
    configureBindings();
    drivesub.setDefaultCommand(new DriveToDistance(drivesub));
  }

  private void configureBindings() {
    r2.onTrue(new DriveToDistance(drivesub));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
