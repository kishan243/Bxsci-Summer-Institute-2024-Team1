package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

public class ShootCommand extends Command {
    // public Hopper hopper;
    // public Drivetrain drivetrain;

    /**
     * instantiates the shoot command alongside the subsystems
     * 
     * @param shooterSubsystem    An instance of the shooter subsystem
     * @param drivetrainSubsystem An instance of the drivetrain subsystem
     */
    public ShootCommand(/* Hopper hopperSubsystem , Drivetrain drivetrainSubsystem */ ) {
        // hopper = hopperSubsystem;
        // drivetrain = drivetrainSubsystem;
        // addRequirements(shooter);
        // addRequirements(hopper);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // this is ran in execute because the drivetrain should rotate using PID
        // drivetrain.faceBank();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // this is ran in end because once the cell is transported, it is-
        // instantly launched. Therefoee the drivetrain should rotate the robot-
        // before the cell is transported
        // hopper.transportCellToShooter();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        // ends command once drivetrain is in the correct orientation
        // if (drivetrain.inPlace()) {
            // return true;
        //}
        return false;
    }
}
