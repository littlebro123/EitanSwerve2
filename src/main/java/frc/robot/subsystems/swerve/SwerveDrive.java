package frc.robot.subsystems.swerve;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.interfaces.Gyro;

import static frc.robot.Ports.ANGLE_PORTS;
import static frc.robot.Ports.SWERVE_PORTS;

public class SwerveDrive {
    private SwerveModule[] swerveModules = new SwerveModule[4];
    private Gyro gyro = new ADXRS450_Gyro(SPI.Port.kMXP);

    public SwerveDrive() {
        gyro.calibrate();
        gyro.reset();

        for (int i = 0; i < 4; i++) {
            swerveModules[i] = new SwerveModule(ANGLE_PORTS[i], SWERVE_PORTS[i], i);
        }
    }

    public void follow() {
        for (int i = 1; i < 4; i++) {
            swerveModules[i].motorSwerve.follow(swerveModules[i - 1].motorSwerve);
            swerveModules[i].motorAngle.follow(swerveModules[i - 1].motorAngle);
        }
    }

    public void driveInDirection(double velocity, double angle) {
        follow();

        swerveModules[0].setSwerveAngle(angle);
        swerveModules[0].setSwerveVelocity(velocity);
    }

    public void unfollow() {
        for (int i = 0; i < 4; i++) {
            swerveModules[i].motorSwerve.follow(swerveModules[i].motorSwerve);
            swerveModules[i].motorAngle.follow(swerveModules[i].motorAngle);
        }
    }
}