package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

import static frc.robot.RobotContainer.m_Drivetrain;


public class pid extends CommandBase {
    private static final double TARGET = 10;
    private double pos  = Robot.enc1.getDistance();
    private double error = TARGET-pos;
    private double kP = .2;
    public pid(){

    }
    @Override
    public void initialize(){
        Robot.enc1.reset();
        addRequirements(m_Drivetrain);

    }
    @Override
    public void execute(){
        m_Drivetrain.setVoltage(error*kP, error*kP);
    }


}
