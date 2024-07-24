package frc.robot.drivetrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import static com.revrobotics.CANSparkLowLevel.MotorType.*;
import static frc.robot.drivetrain.DrivetrainConstants.*;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.Distance;
import edu.wpi.first.units.Measure;
import edu.wpi.first.wpilibj.Encoder;

public class Drivetrain extends SubsystemBase {
    private CANSparkMax leftLeader = new CANSparkMax(0, kBrushless);
    private CANSparkMax leftFollower = new CANSparkMax(1, kBrushless);
    private CANSparkMax rightLeader = new CANSparkMax(2, kBrushless);
    private CANSparkMax rightFollower = new CANSparkMax(3, kBrushless);

    private Encoder leftEncoder = new Encoder(null, null);
    private Encoder rightEncoder = new Encoder(null, null);

    private final PIDController pidControllerRotation = new PIDController(1, 0, 1);

    // public enum State {
    //     IDLE,
    //     ROTATING,
    //     DRIVING,
    // }

    // public State state;

    public Drivetrain() {
        leftFollower.follow(leftLeader);
        rightFollower.follow(rightLeader);

        rightLeader.burnFlash();
        rightFollower.burnFlash();
        leftLeader.burnFlash();
        leftFollower.burnFlash();
    }

    public void drive(double leftSpeed, double rightSpeed) {
        // if (state == State.ROTATING) {
        //     return;
        // }

        leftLeader.set(Math.copySign(Math.pow(leftSpeed, 2), leftSpeed));
        rightLeader.set(Math.copySign(Math.pow(rightSpeed, 2), -rightSpeed));

        // state = State.DRIVING;
    }

    /**
     * updates voltage based on PID in order to drive a certain distance
     * @return voltage of the motors
     */
    public double driveDistance(Measure<Distance> meters) {
        double voltage = 0;

        // code to calculate voltage that needs to be applied-
        // in order to move a certain distance
        // hint: use PID

        return voltage;
    }


    /**
     * updates voltage based on PID in order to fufill rotation command.
     * @param degrees degrees to rotate robot(counter-clockwise).
     */
    public double updateDirection(double x, double y) {
        double degrees = 0;
        // state = State.ROTATING;

        double encoderValue = leftEncoder.get() + rightEncoder.get()/2;
        double voltage = pidControllerRotation.calculate(encoderValue/2, degrees * DISTANCE_PER_DEGREE);
        
        leftLeader.setVoltage(-voltage);
        rightLeader.setVoltage(voltage);

        // if (voltage < 0.1) {
        //     state = State.IDLE;
        // }

        return voltage;
    }
}