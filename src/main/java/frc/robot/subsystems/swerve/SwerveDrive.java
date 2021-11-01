package frc.robot.subsystems.swerve;

import static frc.robot.Ports.*;

public class SwerveDrive {
    private SwerveModule[] swerveModules = new SwerveModule[4];

    public SwerveDrive() {
        for (int i = 0; i < 4; i++) {
            swerveModules[i] = new SwerveModule(ANGLE_PORTS[i], SWERVE_PORTS[i], i);
        }
    }
}
