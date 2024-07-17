package frc.robot.subsystems;

import java.util.function.BooleanSupplier;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
      // Import all necessary items
import frc.robot.Constants;
public class Intake extends SubsystemBase {
    boolean extended = false;
    BooleanSupplier isExtended = () -> extended;
    boolean elevated = false;
    BooleanSupplier isElevated = () -> elevated;
    AbsoluteEncoder pivotEncoder;
    CANSparkMax roller = new CANSparkMax(Constants.IntakeConstants.rollerPort, MotorType.kBrushless);
    CANSparkMax pivot = new CANSparkMax(Constants.IntakeConstants.pivotPort, MotorType.kBrushless);
    CANSparkMax elevator = new CANSparkMax(Constants.IntakeConstants.elevatorPort, MotorType.kBrushless);

    public Intake() {
        pivotEncoder = pivot.getAbsoluteEncoder();
    }

// Toggles the extension motor
    public Command toggleExtension() {
        return runOnce(
            () -> {
                if (isExtended.getAsBoolean()) {
                retract();
                extended = false;
            } else {
                extend();
                extended = true;
            } 
            }
        );
    }


// Extends until a certain "angle" is reached
    public Command extend() {
        return runOnce(
            () -> pivot.set(.5)
        ).andThen(
            //TODO
            Commands.waitUntil(() -> pivotEncoder.getPosition() > Constants.IntakeConstants.stopPoint)
            .andThen(() -> pivot.set(0))
        );
    }
// Retracts until the original point
    public Command retract () {
        return runOnce(
            () -> pivot.set(-.5)
        ).andThen(
            Commands.waitUntil(() -> pivotEncoder.getPosition() < Constants.IntakeConstants.startPoint)
            .andThen(() -> pivot.set(0))
        );

    }
// Starts the intake
    public Command runIntake() {
        return run(
            () -> roller.set(1)
        ).finallyDo(
            () -> roller.set(0)
        );
    }
// Starts the elevator
public Command toggleElevation() {
        return runOnce(
            () -> {
                if (isElevated.getAsBoolean()) {
                elevator.set(0);
                elevated = false;
            } else {
                elevator.set(1);
                elevated = true;
            } 
            }
        );
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
