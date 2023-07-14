// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsystem;


public class DrivetoDistance extends CommandBase {
  DriveBaseSubsystem m_dBSub;
  /** Creates a new DrivetoDistance. */
  public DrivetoDistance(DriveBaseSubsystem sub) {
    m_dBSub = sub;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(sub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_dBSub.drive(0.2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_dBSub.drive(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // if (m_dBSub.getDistance() > 2.95) {
    //   return true;
    // }
    // return false;
    return m_dBSub.getDistance() > 2.95;
  }
}
