package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Feeder extends CommandBase {
    DigitalInput limitSwitch = new DigitalInput(4);
    public Feeder(){
        //addRequirements(RobotContainer.m_Shooter);
    }
    @Override
    public void execute(){
        RobotContainer.m_Shooter.startFeeder();
        if (limitSwitch.get()){
            RobotContainer.m_Shooter.stopFeeder();
        }
    }
}
