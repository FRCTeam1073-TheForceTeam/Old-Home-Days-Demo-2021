// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.DriveControls;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.OI;
import frc.robot.commands.CowControls;
import frc.robot.subsystems.Cow;

/** Add your docs here. */
public class RobotContainer {
    Drivetrain drivetrain;
    DriveControls driveControls;
    Cow cow;
    CowControls cowControls;
    OI oi;

    public RobotContainer() {
        drivetrain = new Drivetrain();
        oi = new OI();
        driveControls = new DriveControls(drivetrain, oi);
        
        cow = new Cow();
        cowControls= new CowControls(cow);
        
    }

    public Command getAutonomousCommand() {
        return null;
    }

    public Command getCowCommand() {
        return cowControls;
    }

    public Command getTeleopCommand() {
        return driveControls;
    }
    public Command getTestCommand() {
        return null;
    }

    // public void configureBindings(){
    //     Trigger cruiseControlButton = new Trigger(oi.driverController :: get)
    // }
}
