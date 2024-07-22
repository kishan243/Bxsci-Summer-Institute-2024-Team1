// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
<<<<<<< HEAD
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
=======
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ShootCommand;
import frc.robot.drivetrain.Drivetrain;
import frc.robot.shooter.Shooter;
>>>>>>> main

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
<<<<<<< HEAD
  private Command m_autonomousCommand;

  private CommandXboxController controller = new CommandXboxController(0);
  private Intake intake = new Intake();
  private Elevator elevator = new Elevator();

=======
  private static final Shooter shooter = new Shooter();
  private static final Drivetrain drivetrain = new Drivetrain();
  private static final CommandXboxController controller = new CommandXboxController(
      Constants.OperatorConstants.driverControllerPort);

  private static Pose2d position = new Pose2d(0, 0, new Rotation2d());

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {
  }
>>>>>>> main

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items
   * like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler. This is responsible for polling buttons, adding
    // newly-scheduled
    // commands, running already-scheduled commands, removing finished or
    // interrupted commands,
    // and running subsystem periodic() methods. This must be called from the
    // robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {
  }

  /** This function is called periodically during disabled mode. */
  @Override
  public void disabledPeriodic() {
  }

  /** This function is called once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {
<<<<<<< HEAD
    
=======
>>>>>>> main
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  }

  /** This function is called once each time the robot enters operator control. */
  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
<<<<<<< HEAD
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
// controller inputs 
    
=======

    controller.a().onTrue(shooter.turnOff());

    controller.b().onTrue(new ShootCommand(drivetrain,shooter,position)); // replace with beambrake sensor
>>>>>>> main
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
<<<<<<< HEAD
    controller.a().whileTrue(
      Commands.sequence(
        intake.extend()
        .alongWith(intake.runIntake())
        .alongWith(elevator.intakeBrake())
      )
    );
    
=======
    drivetrain.drive(controller.getLeftY(), controller.getRightY());
    shooter.updateVelocity(position.getX(), position.getY());
>>>>>>> main
  }

  /** This function is called once each time the robot enters testing mode. */
  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
<<<<<<< HEAD
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
=======
  public void testPeriodic() {
  }
}
>>>>>>> main
