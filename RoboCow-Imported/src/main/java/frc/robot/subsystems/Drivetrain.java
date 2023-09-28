// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  WPI_TalonSRX leftLeader;
  WPI_VictorSPX leftFollower;
  WPI_VictorSPX leftFollower2;
  WPI_TalonSRX rightLeader;
  WPI_VictorSPX rightFollower;
  WPI_VictorSPX rightFollower2;
  ADXRS450_Gyro gyro;

  public Drivetrain() {
    leftLeader = new WPI_TalonSRX(12);
    leftFollower = new WPI_VictorSPX(14);
    leftFollower2 = new WPI_VictorSPX(16);

    rightLeader = new WPI_TalonSRX(13);
    rightFollower = new WPI_VictorSPX(15);
    rightFollower2 = new WPI_VictorSPX(17);

    configureDrivetrain();
  }
  
  private void configureDrivetrain() {
    leftLeader.configFactoryDefault();
    leftFollower.configFactoryDefault();
    leftFollower2.configFactoryDefault();

    rightLeader.configFactoryDefault();
    rightFollower.configFactoryDefault();
    rightFollower2.configFactoryDefault();

    leftLeader.setSafetyEnabled(false);
    leftFollower.setSafetyEnabled(false);
    leftFollower2.setSafetyEnabled(false);

    rightLeader.setSafetyEnabled(false);
    rightFollower.setSafetyEnabled(false);
    rightFollower2.setSafetyEnabled(false);

    leftLeader.setInverted(false);
    leftFollower.setInverted(false);
    leftFollower2.setInverted(false);

    rightLeader.setInverted(true);
    rightFollower.setInverted(true);
    rightFollower2.setInverted(true);

    leftFollower.follow(leftLeader);
    leftFollower2.follow(leftLeader);

    rightFollower.follow(rightLeader);
    rightFollower2.follow(rightLeader);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setPower(double left, double right) {
    leftLeader.set(ControlMode.PercentOutput, left);
    rightLeader.set(ControlMode.PercentOutput, right);
  }
}
