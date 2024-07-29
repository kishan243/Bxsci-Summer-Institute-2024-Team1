// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.units.Distance;
import edu.wpi.first.units.Measure;
import static edu.wpi.first.units.Units.*;

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
    public static final int OperatorControllerPort = 0;
  }
  
  public static class FieldConstants {
    // 0,0 is at the center

    // -90,156 is at the top left
    // 90,156 is at the top right

    // -90, -156 is at the bottom left
    // 90, -156 is at the bottom right

    // positive Y is up the field
    // positive X is to the right

    public static final Measure<Distance> BankLength = Inches.of(36);
    public static final Measure<Distance> BankWidth = Inches.of(48);

    public static final Measure<Distance> bankX = Inches.of(132);
    public static final Measure<Distance> bankY = Inches.of(90);

    public static final Measure<Distance> fieldLength = Inches.of(312);
    public static final Measure<Distance> fieldWidth = Inches.of(180);
    //dimensions of field

    public static final Measure<Distance> fieldX = Inches.of(0);
    public static final Measure<Distance> fieldY = Inches.of(0);

    public static final Measure<Distance> humanPlayerZoneLength = Inches.of(24);
    public static final Measure<Distance> humanPlayerZoneWidth = Inches.of(36);

    public static final Measure<Distance> humanPlayerZoneX = Inches.of(90);
    public static final Measure<Distance> humanPlayerZoneY = Inches.of(-156);

    public static final Measure<Distance> cellBankZoneLength = Inches.of(87);
    public static final Measure<Distance> cellBankZoneWidth = Inches.of(180);

    public static final Measure<Distance> midZoneLength = Inches.of(68);
    public static final Measure<Distance> midZoneWidth = Inches.of(180);

    public static final Measure<Distance> endZoneLength = Inches.of(155);
    public static final Measure<Distance> endZoneWidth = Inches.of(180);

  }
}
