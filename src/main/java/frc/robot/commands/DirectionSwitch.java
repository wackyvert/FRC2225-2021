/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class DirectionSwitch extends InstantCommand {
  public DirectionSwitch() {
      addRequirements(RobotContainer.m_Drivetrain);
  }

  // Called when the command is initially scheduled. Switches the driving direction of the robot. May or may not be used for competition.
  @Override
  public void initialize() {
    Drivetrain.switchDirection();
  }
}
