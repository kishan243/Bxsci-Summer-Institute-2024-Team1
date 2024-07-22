// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int driverControllerPort = 0;
  }
   
  public static class IntakeConstants {
    public static final int rollerPort = 0; //port constants for motor instantiation
    public static final int pivotPort = 0;
    public static final double stopPoint = 0; //encoder constants for extend() and retract() respsectively
    public static final double startPoint = 0; 
    public static final int elevatorPort = 0;
  }
  
  public static class FieldConstants {
    public static final double boxX = 1;// centered at the middle of the power bank //-
    public static final double boxY = 1;// centered at the middle of the power bank //-
  }
}

// "//-" indicates that the constant needs to be tuned