package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RollerIntake extends SubsystemBase {
    public VictorSPX rollerIntake = new VictorSPX(5);
    public RollerIntake(){
    }
    //method to spin the wheels on the intake
    public void grabPowerCell(){
        rollerIntake.set(ControlMode.PercentOutput, -Constants.OPTIMAL_INTAKE_SPEED);
    }
    public void stop(){
        rollerIntake.set(ControlMode.PercentOutput, 0);
    }


}
