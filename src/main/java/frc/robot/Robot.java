/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import java.util.Map;

import static edu.wpi.first.wpilibj2.command.CommandScheduler.getInstance;
import static frc.robot.RobotContainer.*;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    public static PIDController pid;
    private RobotContainer m_robotContainer;

  
    public static Encoder enc1;
    public static Encoder enc2;
    private static final double cpr = 360;
    private static final double whd = 6; // for 6 inch wheel
    DigitalInput limitSwitch;
    int p=0;
    int i=0;
    int d=0;

    /**
   * Note: Any example colors should be calibrated as the user needs, these
   * are here as a basic example.
   */
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
     enc1 = new Encoder(0,1);
      enc1.setDistancePerPulse(Math.PI*whd/cpr); //distance per pulse is pi* (wheel diameter / counts per revolution)
      enc2 = new Encoder(2,3);
      enc2.setDistancePerPulse(Math.PI*whd/cpr); //distance per pulse is pi* (wheel diameter / counts per revolution)
        limitSwitch = new DigitalInput(4);

      //makes new camera
    final CameraServer camera = CameraServer.getInstance();
      camera.startAutomaticCapture();
    m_robotContainer = new RobotContainer();
    //Sets the default command of the drivetrain subsystem to arcade drive so I don't have to have anything in teleopPeriodic
    getInstance().setDefaultCommand(m_Drivetrain, RobotContainer.m_ArcadeDrive);
    //getInstance().setDefaultCommand(m_Shooter, RobotContainer.m_Feeder);

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    
   //The scheduler that runs the commands. DONT TOUCH
    getInstance().run();



  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {

  }

  /**
   * This function is called periodically during autonomous.
   */


    @Override
    public void autonomousPeriodic() {
    }

  @Override
  public void teleopInit() {
      pid = new PIDController(p, i, d);
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
      boolean lSwitch = limitSwitch.get();
      SmartDashboard.putBoolean("Switch", lSwitch);

  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
