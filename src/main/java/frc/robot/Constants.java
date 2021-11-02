/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final double ROBOT_DIMENSION = 0;
    public static final double TICKS_PER_DEGREE = 1024 / 360.0;

    public static class SwerveModule {
        public static final double[] PID_ANGLE = {0.1, 0, 0.01}; // kp, ki, kd
        public static final double[] PID_SWERVE = {0.2, 0, 0.02}; // kp, ki, kd
        public static final int PID_SLOT_ANGLE = 0;
        public static final int PID_SLOT_SWERVE = 0;
        public static final double TICKS_PER_RADIAN = 1024 / (2 * Math.PI);
    }
}
