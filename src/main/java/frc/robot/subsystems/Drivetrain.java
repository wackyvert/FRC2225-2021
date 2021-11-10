/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private static final TalonSRX fl = new TalonSRX(Constants.FRONT_LEFT_ID);
  private static final TalonSRX bl = new TalonSRX(Constants.BACK_LEFT_ID);
  private static final TalonSRX fr = new TalonSRX(Constants.FRONT_RIGHT_ID);
  private static final TalonSRX br = new TalonSRX(Constants.BACK_RIGHT_ID);
  private static final ADXRS450_Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
  public static boolean switcher;

  /**
   * Creates a new Drivetrain constructor
   */
  public Drivetrain() {

  }

  // Switches which side of the robot is considered "forward"
  public static void switchDirection() {
    switcher ^= true;
    fl.setInverted(switcher);
    bl.setInverted(switcher);
    fr.setInverted(switcher);
    br.setInverted(switcher);
  }
  public static void switchLeft(){
    fl.setInverted(true);
    bl.setInverted(true);
  }
  public static void switchRight(){
    fr.setInverted(true);
    br.setInverted(true);
  }

  // Sets the motor voltage so we can drive
  public void setVoltage(double speedLeft, double speedRight) {
    fl.set(ControlMode.PercentOutput, speedLeft);
    bl.set(ControlMode.PercentOutput, speedLeft);
    fr.set(ControlMode.PercentOutput, speedRight);
    br.set(ControlMode.PercentOutput, speedRight);
  }


  public void stopDrivetrain() {
    fl.set(ControlMode.PercentOutput, 0);
    bl.set(ControlMode.PercentOutput, 0);
    fr.set(ControlMode.PercentOutput, 0);
    br.set(ControlMode.PercentOutput, 0);
  }
  //for setting the drivetrain wheels to the left and right commands for vision, because our normal setVoltage method
  //takes a speed and turn parameter and maps it to left and right
  public void visionVoltage(double speed, double turn) {
    double left = speed+turn;
    double right = -speed+turn;

    fl.set(ControlMode.PercentOutput, left);
    bl.set(ControlMode.PercentOutput, left);
    fr.set(ControlMode.PercentOutput, right);
    br.set(ControlMode.PercentOutput, right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run, but we dont use this part
    // because we have a command for it instead
    SmartDashboard.putNumber("Gyro", gyro.getAngle());
  }
}
