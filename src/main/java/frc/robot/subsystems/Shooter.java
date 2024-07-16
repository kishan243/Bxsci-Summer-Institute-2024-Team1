package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

// The shooter is to be manually tuned once the robot is all set and working.
// In order to simplify this process we will have methods to aid in testing.
// ex: a method to raise power, and a method to lower power

// Because of physics(and according to team 254's tech binder) this tuning -
// process only really has to be done for one specific distance, as all of -
// the other distances can be calculated based on this one. 

// Drivetrain needs to add encoders in order to determine the angle at -
// which to shoot(since we need our position relative to the goal)
// Also some weird math is required in order to make sure that we get it -
// into the square.

public class Shooter extends SubsystemBase {
    private final CANSparkMax motor = new CANSparkMax(Constants.MotorConstants.kShooterMotorPort, MotorType.kBrushless);

    private double power;
    private double increment;

    public void IncreasePower() {
        power += increment;
    }
    public void DecreasePower() {
        power -= increment;
    }
    public void IncreaseIncrement() {
        increment += 0.1;
    }
    public void DecreaseIncrement() {
        increment -= 0.1;
    }
    public void UpdatePower() {
        motor.set(power);
    }
}
