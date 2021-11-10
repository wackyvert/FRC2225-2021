package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;


public class pid extends CommandBase {
    private static final double TARGET = 20;
    public pid(){

    }
    @Override
    public void initialize(){
        Robot.enc1.reset();
        Robot.enc2.reset();

    }
    @Override
    public void execute(){
        System.out.println("enc1: " + Robot.enc1.getDistance() + ", enc2: " + Robot.enc2.getDistance());
        RobotContainer.m_Drivetrain.setVoltage(clamp(Robot.enc1.getDistance() - TARGET, 0.3), clamp(Robot.enc2.getDistance() - TARGET, 0.3));
        System.out.println(Robot.pid.calculate(Robot.enc1.getDistance(), 20));
    }

    private double clamp(double val, double clamp) {
        double sign = Math.signum(val);
        val = Math.min(Math.abs(val), Math.abs(clamp));
        val *= sign;
        return val;
    }

}
