package frc.robot.commands;


import edu.wpi.first.units.Distance;
import edu.wpi.first.units.Measure;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.drivetrain.Drivetrain;

public class driveDistanceCommand extends Command{
    public Drivetrain drivetrain;
    

    public driveDistanceCommand (Drivetrain drivetrain, Measure<Distance> metersToTravel){
        
    }
}
