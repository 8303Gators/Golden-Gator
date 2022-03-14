// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  // motor 0 l1 positive input makes it go forward
  // motor 1 l2 positive input makes it go forward
  // motor 2 r1 positive input makes it go forward
  // motor 3 r2 positive input makes it go forward


  private WPI_TalonSRX l1 = new WPI_TalonSRX(0);
  private WPI_TalonSRX l2 = new WPI_TalonSRX(1);
  private WPI_TalonSRX r1 = new WPI_TalonSRX(2);
  private WPI_TalonSRX r2 = new WPI_TalonSRX(3);

  private MotorControllerGroup left = new MotorControllerGroup(l1, l2);
  private MotorControllerGroup right = new MotorControllerGroup(r1, r2);

  private DifferentialDrive differentialDrive = new DifferentialDrive(left, right);

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    l1.setInverted(false);
    l2.setInverted(false);
    r1.setInverted(true);
    r2.setInverted(false);

    l1.setSafetyEnabled(false);
    l2.setSafetyEnabled(false);
    r1.setSafetyEnabled(false);
    r2.setSafetyEnabled(false);

    differentialDrive.setDeadband(0.2);
  }

  public void arcadeDrive(double forward, double rotation) {
    forward = Math.copySign(forward * forward, forward);
    rotation = Math.copySign(rotation * rotation, rotation);
    differentialDrive.arcadeDrive(forward, rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
