// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cow;
import frc.robot.subsystems.OI;

public class CowControls extends CommandBase {

  Cow cow;

  /** Creates a new CowControls. */
  public CowControls(Cow cow_) {
    cow = cow_;
    addRequirements(cow);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    cow.init();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (OI.driverController.getXButtonPressed()){
      System.out.println("Moo");
      cow.moo(false);
    } else {
      cow.moo(true);
    }

    //We either need a random timer here or in the Raspberry Pi
    // Probably the Pi due to the WPILib periodic model
    if (OI.driverController.getYButtonPressed()){
      System.out.println("Poop");
      cow.poop(false);
    } else {
      cow.poop(true);
    }

    if (OI.driverController.getPOV() == 180){
      System.out.println("Poop on command");
      cow.poopOnCommand(false);
    }
    else{
      cow.poopOnCommand(true);
    }
  }



  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    cow.init();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
