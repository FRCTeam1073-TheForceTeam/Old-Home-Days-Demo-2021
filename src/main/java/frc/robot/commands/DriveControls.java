// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.OI;

public class DriveControls extends CommandBase {

  Drivetrain drivetrain;
  double forward, rotational, deadzone = 0.1, leftMotorOutput, rightMotorOutput;

  /** Creates a new DriveControls. */
  public DriveControls(Drivetrain drivetrain_) {
    drivetrain = drivetrain_;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.setPower(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //double left = OI.driverController.getRawAxis(1);
    //double right = OI.driverController.getRawAxis(5);
    //drivetrain.setPower(left*(-0.5), right*(-0.5));

    /* Controller Data */
		forward = -OI.driverController.getRawAxis(1);
		rotational = OI.driverController.getRawAxis(4);
		
		/* Outputs Checked Controller Data to Motors */
		arcaderDrive(limit(deadZoneCheck(forward)), limit(deadZoneCheck(rotational)));
  }

  public void arcaderDrive(double fwd, double rot) {
		double maxInput = Math.copySign(Math.max(Math.abs(fwd), Math.abs(rot)), fwd);

		if (fwd >= 0.0) {
			if (rot >= 0.0) {
				leftMotorOutput = maxInput;
				rightMotorOutput = fwd - rot;
			} else {
				leftMotorOutput = fwd + rot;
				rightMotorOutput = maxInput;
			}
		} else {
			if (rot >= 0.0) {
				leftMotorOutput = fwd + rot;
				rightMotorOutput = maxInput;
			} else {
				leftMotorOutput = maxInput;
				rightMotorOutput = fwd - rot;
			}
		}
		double multiplier = 1;
		//Robot.debugPrint(Robot.oi.driverControl.getRightTrigger());
		if (OI.driverController.getTriggerAxis(Hand.kRight) > .25) multiplier = .25 + (.75 * OI.driverController.getTriggerAxis(Hand.kRight));
		drivetrain.setPower(limit(multiplier * leftMotorOutput), (limit(multiplier * rightMotorOutput)));	
	}

  /** 
	 * @param val Input to check against dead zone
	 * @return If within dead zone return 0, Else return val
	 */
	private double deadZoneCheck(double val) {
		if (Math.abs(val) < deadzone) return 0;
		return val;
	}

	private double speedModifier(double val) {
		return Math.copySign(Math.pow(Math.abs(val), 3) * 1300, val);
	}

  /**
   * Limit motor values to the -1.0 to +1.0 range.
   */
  private double limit(double value) {
   	if (Math.abs(value) > 1.0) return Math.copySign(1, value);
   	return value;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.setPower(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
