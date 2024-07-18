// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.XboxController;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final Shooter shooter = new Shooter();
  private static final XboxController controller = new XboxController(Constants.OperatorConstants.driverControllerPort);

  private static double x;
  private static double y;  

  enum TuneMode {
    SHOOTER_TUNING,
    INTAKE_TUNING,
    DRIVETRAIN_TUNING,
    DEFAULT, // doesn't allow for tuning mode selection
    SELECTING // allows for tuning mode selection
  }

  private static TuneMode tuneMode = TuneMode.SELECTING;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {}

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically during disabled mode. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {}

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  /** This function is called once each time the robot enters operator control. */
  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    // Configures button bindings for shooter
    if(controller.getAButton()) {
      shooter.increasePower();
    }
    if(controller.getBButton()) {
      shooter.decreasePower();
    }
    if (controller.getStartButton()) {
      shooter.turnOn();
    }
    if (controller.getBackButton()) {
      shooter.turnOff();
    }
  }

  /** This function is called once each time the robot enters testing mode. */
  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    if (tuneMode == TuneMode.SELECTING) {
      if (controller.getAButtonPressed()) {
        tuneMode = TuneMode.DRIVETRAIN_TUNING;
      }
      if (controller.getBButtonPressed()) {
        tuneMode = TuneMode.SHOOTER_TUNING;
      }
      if (controller.getXButtonPressed()) {
        tuneMode = TuneMode.INTAKE_TUNING;
      }
      if (controller.getYButtonPressed()) {
        tuneMode = TuneMode.DEFAULT;
      }
    }

    if (controller.getRightStickButton()) {
      tuneMode = TuneMode.SELECTING;
    }
    if (tuneMode == TuneMode.SELECTING) {
      return;
    }

    switch (tuneMode) {
      case DRIVETRAIN_TUNING:
        // insert your code for testing here(feel free to delete if u don't want this)
        break;
      case SHOOTER_TUNING:
        shooter.tuningPeriodic(controller, x, y);
        break;
      case INTAKE_TUNING:
        // insert your code for testing here(feel free to delete if u don't want this)
        break;
      default:

        break;
    }
  }
}
