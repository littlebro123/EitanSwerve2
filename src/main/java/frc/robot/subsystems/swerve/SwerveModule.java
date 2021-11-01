package frc.robot.subsystems.swerve;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.subsystems.UnitModel;

import static frc.robot.Constants.SwerveModule.*;
import static frc.robot.Constants.TICKS_PER_DEGREE;

public class SwerveModule {
    public TalonSRX motorAngle;
    public TalonSRX motorSwerve;

    private int ANGLE_PORT;
    private int SWERVE_PORT;
    private int module;
    private UnitModel unitModel = new UnitModel(TICKS_PER_DEGREE);

    public SwerveModule(int ANGLE_PORT, int SWERVE_PORT, int module) {
        this.ANGLE_PORT = ANGLE_PORT;
        this.SWERVE_PORT = SWERVE_PORT;
        this.module = module;

        motorAngle = new TalonSRX(ANGLE_PORT);
        motorSwerve = new TalonSRX(SWERVE_PORT);

        motorAngle.config_kP(PID_SLOT_ANGLE, PID_ANGLE[0]);
        motorAngle.config_kP(PID_SLOT_ANGLE, PID_ANGLE[1]);
        motorAngle.config_kP(PID_SLOT_ANGLE, PID_ANGLE[2]);

        motorSwerve.config_kP(PID_SLOT_SWERVE, PID_SWERVE[0]);
        motorSwerve.config_kP(PID_SLOT_SWERVE, PID_SWERVE[1]);
        motorSwerve.config_kP(PID_SLOT_SWERVE, PID_SWERVE[2]);
    }

    public void setSwerveAngle(double angle) {
        motorAngle.set(ControlMode.Position, unitModel.toTicks(angle));
    }

    public void setSwerveVelocity(double velocity) {
        motorSwerve.set(ControlMode.Velocity, unitModel.toTicks100ms(velocity));
    }

    public double getSwerveAngle() {
        return unitModel.toUnits(motorAngle.getSelectedSensorPosition());
    }

    public double getSwerveVelocity() {
        return unitModel.toVelocity(motorSwerve.getSelectedSensorVelocity());
    }
}
