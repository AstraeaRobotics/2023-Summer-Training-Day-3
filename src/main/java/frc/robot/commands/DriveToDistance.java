// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveBaseSubsystem;

public class DriveToDistance extends CommandBase {

  DriveBaseSubsystem m_drivebaseSubsystem;
  double distance;

  /** Creates a new DriveBaseCommand. */
  public DriveToDistance(DriveBaseSubsystem drivebase) {
    m_drivebaseSubsystem = drivebase;
    distance = m_drivebaseSubsystem.getDistance();

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivebaseSubsystem.drive(0.2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivebaseSubsystem.drive(0);
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double traveled = m_drivebaseSubsystem.getDistance() - distance;
    return (2.95 < traveled && traveled < 3.05);
  }
}
