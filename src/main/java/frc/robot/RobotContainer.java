// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveControls;
import frc.robot.subsystems.Drivetrain;

/** Add your docs here. */
public class RobotContainer {
    Drivetrain drivetrain;
    DriveControls driveControls;

    public RobotContainer() {
        drivetrain = new Drivetrain();
        driveControls = new DriveControls(drivetrain);
    }

    public Command getAutonomousCommand() {
        return null;
    }

    public Command getTeleopCommand() {
        return driveControls;
    }

    public Command getTestCommand() {
        return null;
    }
}
