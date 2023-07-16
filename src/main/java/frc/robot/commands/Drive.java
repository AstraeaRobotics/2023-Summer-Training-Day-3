// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivebaseSubsystem;

public class Drive extends CommandBase {


  DrivebaseSubsystem drivebaseSubsystem;
  double FL, FR, BL, BR;
  /** Creates a new Drive. */
  public Drive(DrivebaseSubsystem drivebaseSubsystem, double FL, double FR, double BL, double BR) {

    this.drivebaseSubsystem = drivebaseSubsystem;
    this.FL = FL;
    this.FR = FR;
    this.BL = BL;
    this.BR = BR;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivebaseSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {super.initialize();}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {drivebaseSubsystem.DRIVE(FL, FR, BL, BR);}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {drivebaseSubsystem.REST();}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
