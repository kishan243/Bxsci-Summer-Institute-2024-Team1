package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import static com.revrobotics.CANSparkLowLevel.MotorType.*;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;

public class Drive extends SubsystemBase {
    private CANSparkMax leftLeader = new CANSparkMax(0, kBrushless);
    private CANSparkMax leftFollower = new CANSparkMax(1, kBrushless);
    private CANSparkMax rightLeader = new CANSparkMax(2, kBrushless);
    private CANSparkMax rightFollower = new CANSparkMax(3, kBrushless);

    private Encoder leftEncoder = new Encoder(null, null);
    private Encoder rightEncoder = new Encoder(null, null);

    private final PIDController pidControllerRotation = new PIDController(1, 0, 1);

    public Drive(){
        rightLeader.setInverted(true);
        leftFollower.follow(leftLeader);
        rightFollower.follow(rightLeader);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        leftLeader.set(leftSpeed);
        rightLeader.set(rightSpeed);
    }

    // dw about all of this - Ankit

    /**
     * updates voltage based on PID in order to fufill rotation command
     * @param degrees degrees to rotate robot(counter-clockwise)
     */
    private void updateDirection(double degrees) {
        double encoderValue = leftEncoder.get() + rightEncoder.get()/2;
        double voltage = pidControllerRotation.calculate(encoderValue/2, degrees * Constants.DriveConstants.DISTANCE_PER_DEGREE);
        
        leftLeader.setVoltage(-voltage);
        rightLeader.setVoltage(voltage);
    }

    /**
     * rotates robot to a certain angle
     * @param degrees degrees to rotate robot(counter-clockwise)
     * @return returns a command that rotates the robot a certain amount of degree counter-clockwise
     */
    public Command setDirection(double degrees) {
        leftEncoder.reset();
        rightEncoder.reset();

        return run(() -> updateDirection(degrees));
    }
}