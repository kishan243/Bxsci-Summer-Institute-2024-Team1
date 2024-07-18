package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import static com.revrobotics.CANSparkLowLevel.MotorType.*;

public class Drive extends SubsystemBase {
    private CANSparkMax leftLeader = new CANSparkMax(13, kBrushless);
    private CANSparkMax leftFollower = new CANSparkMax(37, kBrushless);
    private CANSparkMax rightLeader = new CANSparkMax(25, kBrushless);
    private CANSparkMax rightFollower = new CANSparkMax(18, kBrushless);

    public Drive() {
        leftFollower.follow(leftLeader);
        rightFollower.follow(rightLeader);

        rightLeader.burnFlash();
        rightFollower.burnFlash();
        leftLeader.burnFlash();
        leftFollower.burnFlash();
    }

    public void drive(double leftSpeed, double rightSpeed) {
        leftLeader.set(Math.copySign(Math.pow(leftSpeed, 2), leftSpeed));
        rightLeader.set(Math.copySign(Math.pow(rightSpeed, 2), -rightSpeed));
    }
}