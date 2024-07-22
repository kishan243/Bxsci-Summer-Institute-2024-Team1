package frc.robot.drivetrain;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import static com.revrobotics.CANSparkLowLevel.MotorType.*;
import static frc.robot.drivetrain.DrivetrainConstants.*;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;

public class Drivetrain extends SubsystemBase {
    private CANSparkMax leftLeader = new CANSparkMax(0, kBrushless);
    private CANSparkMax leftFollower = new CANSparkMax(1, kBrushless);
    private CANSparkMax rightLeader = new CANSparkMax(2, kBrushless);
    private CANSparkMax rightFollower = new CANSparkMax(3, kBrushless);

    private Encoder leftEncoder = new Encoder(null, null);
    private Encoder rightEncoder = new Encoder(null, null);

    private final PIDController pidControllerRotation = new PIDController(1, 0, 1);

    public enum State {
        IDLE,
        ROTATING,
        DRIVING,
    }

    public State state;

    public Drivetrain(){
        rightLeader.setInverted(true);
        leftFollower.follow(leftLeader);
        rightFollower.follow(rightLeader);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        if (state == State.ROTATING) {
            return;
        }

        leftLeader.set(leftSpeed);
        rightLeader.set(rightSpeed);

        state = State.DRIVING;
    }

    // dw about all of this - Ankit

    /**
     * updates voltage based on PID in order to fufill rotation command
     * @param degrees degrees to rotate robot(counter-clockwise)
     */
    public double updateDirection(double x, double y) {
        double degrees = 0;
        state = State.ROTATING;

        double encoderValue = leftEncoder.get() + rightEncoder.get()/2;
        double voltage = pidControllerRotation.calculate(encoderValue/2, degrees * DISTANCE_PER_DEGREE);
        
        leftLeader.setVoltage(-voltage);
        rightLeader.setVoltage(voltage);

        if (voltage < 0.1) {
            state = State.IDLE;
        }

        return voltage;
    }
}