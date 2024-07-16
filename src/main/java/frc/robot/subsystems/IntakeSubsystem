package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
      // Import all necessary items
public class Intake extends TimedRobot {
  private final PWMSparkMax rollerMotor1 = new PWMSparkMax(0);  
  private final PWMSparkMax rollerMotor2 = new PWMSparkMax(1);  
  private final PWMSparkMax piviotMotor3 = new PWMSparkMax(2);  
      // Sets up and initializes the motor

  public void Update(XboxController controller) {
    SmartDashboard.putBoolean("Button Pressed", controller.getRawButton(1));
    System.out.println("Button state: " + controller.getRawButton(1));
     if (controller.getRawButton(1)) {
      // Button is pressed and moving pivot motor to the target position
      rollerMotor1.set(0.5);
      rollerMotor2.set(0.5);
      piviotMotor3.set(0.5);
    } else {
      // Button is not pressed, turn off all motors
      rollerMotor1.set(0.0);
      rollerMotor2.set(0.0);
      piviotMotor3.set(-0.5);

    } 
  }
}




public class Intake extends SubsystemBase {
    boolean extended = false;
    BooleanSupplier isExtended = () -> extended;
    AbsoluteEncoder pivotEncoder;
    CANSparkMax roller = new CANSparkMax(Constants.IntakeConstants.rollerPort, MotorType.kBrushless);
    CANSparkMax pivot = new CANSparkMax(Constants.IntakeConstants.pivotPort, MotorType.kBrushless);

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

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
