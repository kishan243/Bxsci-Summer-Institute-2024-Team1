package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import static com.revrobotics.CANSparkLowLevel.MotorType.*;

public class DriveSubsystem extends SubsystemBase {
    private CANSparkMax leftLeader = new CANSparkMax(0, kBrushless);
    private CANSparkMax leftFollower = new CANSparkMax(1, kBrushless);
    private CANSparkMax rightLeader = new CANSparkMax(2, kBrushless);
    private CANSparkMax rightFollower = new CANSparkMax(3, kBrushless);

    public DriveSubsystem(){
        rightLeader.setInverted(true);
        leftFollower.follow(leftLeader);
        rightFollower.follow(rightLeader);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        leftLeader.set(leftSpeed);
        rightLeader.set(rightSpeed);
    }
}