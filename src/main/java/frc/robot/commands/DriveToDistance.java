// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drivebase;

public class DriveToDistance extends CommandBase {
  Drivebase m_drivebase = new Drivebase();
  double speed = 0.2;
  double distance = 3;

  /** Creates a new DriveToDistance. */
  public DriveToDistance(Drivebase drivebase) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivebase = drivebase;
    addRequirements(drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivebase.drive(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivebase.drive(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Read encoder values and calculate using wheel diameter to stop at desired distance
    if (m_drivebase.getDistance() >= distance) {
      return true;
    }
    return false;
  }
}
