package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.*;

// The shooter is to be manually tuned once the robot is all set and working.
// In order to simplify this process we will have methods to aid in testing.
// ex: a method to raise power, and a method to lower power

// Because of physics(and according to team 254's tech binder) this tuning -
// process only really has to be done for one specific distance, as all of -
// the other distances can be calculated based on this one. 

// Drivetrain needs to add encoders in order to determine the angle at -
// which to shoot(since we need our position relative to the goal)
// Also some weird math is required in order to make sure that we get it -
// into the square. Therefore we just have to aim for the orgin

public class Shooter extends SubsystemBase {
    private final CANSparkMax motor = new CANSparkMax(ShooterConstants.motorPort, MotorType.kBrushless);
    private double power;
    
    /** 
     * calculates the amount of power neccesary to score the cell into the bank
     * @param currentX the current X position of the robot on the field
     * @param currentY the current Y position of the robot on the field
     * @return the amount of power neccesary to score the cell into the bank
     */
    public double calculatePower(double currentX, double currentY) {
        double xDistanceFromBank = Math.pow(currentX - Constants.FieldConstants.boxX,2);
        double yDistanceFromBank = Math.pow(currentY - Constants.FieldConstants.boxY,2);
        double distanceFromBank = Math.sqrt( xDistanceFromBank +  yDistanceFromBank);

        double cpower = distanceFromBank/ShooterConstants.testingDistance * ShooterConstants.testingPower;
        return cpower;
    }

    /** 
     * increases the launching power of the shooter
     */
    public void increasePower() {
        // increase power
        power += 0.1;
        updatePower();
    }

    /** 
     * decreases the launching power of the shooter
     */
    public void decreasePower() {
        // decrease power
        power -= 0.1;
        updatePower();
    }

    /** 
     * turns on the motor
     */
    public void turnOn() {
        // turn on motor
        updatePower();
    }

    /** 
     * turns off the motor
     */
    public void turnOff() {
        // turn off motor
        motor.stopMotor();
    }

    /** 
     * Updates the motor's power
     */
    public void updatePower() {
        motor.set(power);
    }

    /** 
     * Called periodically when tuning the robot
     */
    public void tuningPeriodic(XboxController controller, double currentX, double currentY) {
        if (controller.getRightBumperPressed()) {increasePower();}
        if (controller.getLeftBumperPressed()) {decreasePower();}
        
        if (controller.getBackButton()) {
            turnOff();
        }
        if (controller.getStartButton()) {
            turnOn();
        }

        System.out.println("X:" + String.valueOf(currentX) + " Y:" + String.valueOf(currentY));
    }
}
