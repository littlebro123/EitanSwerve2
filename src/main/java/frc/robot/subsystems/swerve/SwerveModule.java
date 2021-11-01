package frc.robot.subsystems.swerve;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.subsystems.UnitModel;

import static frc.robot.Constants.SwerveModule.*;
import static frc.robot.Constants.TICKS_PER_DEGREE;

public class SwerveModule {
    private TalonSRX motorTop;
    private TalonSRX motorBottom;
    private int ANGLE_PORT;
    private int SWERVE_PORT;
    private int module;
    private UnitModel unitModel = new UnitModel(TICKS_PER_DEGREE);

    public SwerveModule(int ANGLE_PORT, int SWERVE_PORT, int module) {
        this.ANGLE_PORT = ANGLE_PORT;
        this.SWERVE_PORT = SWERVE_PORT;
        this.module = module;

        motorTop = new TalonSRX(ANGLE_PORT);
        motorBottom = new TalonSRX(SWERVE_PORT);

        motorTop.config_kP(PID_SLOT, PID[0]);
        motorTop.config_kP(PID_SLOT, PID[1]);
        motorTop.config_kP(PID_SLOT, PID[2]);

        motorBottom.config_kP(PID_SLOT, PID[0]);
        motorBottom.config_kP(PID_SLOT, PID[1]);
        motorBottom.config_kP(PID_SLOT, PID[2]);

        motorTop.setSelectedSensorPosition(SENSOR_POS_TOP[module]);
        motorBottom.setSelectedSensorPosition(SENSOR_POS_BOTTOM[module]);
    }

    public void setMotorTopVelocity(double velocity) {
        motorTop.set(ControlMode.Velocity, unitModel.toTicks100ms(velocity));
    }

    public void setMotorBottomVelocity(double velocity) {
        motorBottom.set(ControlMode.Velocity, unitModel.toTicks100ms(velocity));
    }

    public void setMotorTopAngle(double angle) {
        motorTop.set(ControlMode.Position, unitModel.toTicks(angle));
    }

    public void setMotorBottomAngle(double angle) {
        motorBottom.set(ControlMode.Position, unitModel.toTicks(angle));
    }

    public double getVelocityTop() {
        return unitModel.toVelocity(motorTop.getSelectedSensorVelocity());
    }

    public double getVelocityBottom() {
        return unitModel.toVelocity(motorBottom.getSelectedSensorVelocity());
    }
}
