package frc.robot.subsystems.swerve;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.subsystems.UnitModel;

import static frc.robot.Constants.SwerveModule.*;
import static frc.robot.Constants.TICKS_PER_DEGREE;

public class SwerveModule {
    private TalonSRX motorTop;
    private TalonSRX motorBottom;
    private int TOP_PORT;
    private int BOTTOM_PORT;
    private int module;
    private UnitModel unitModel = new UnitModel(TICKS_PER_DEGREE);

    public SwerveModule(int TOP_PORT, int BOTTOM_PORT, int module) {
        this.TOP_PORT = TOP_PORT;
        this.BOTTOM_PORT = BOTTOM_PORT;
        this.module = module;

        motorTop = new TalonSRX(TOP_PORT);
        motorBottom = new TalonSRX(BOTTOM_PORT);

        motorTop.config_kP(PID_X, PID[0]);
        motorTop.config_kP(PID_X, PID[1]);
        motorTop.config_kP(PID_X, PID[2]);

        motorBottom.config_kP(PID_X, PID[0]);
        motorBottom.config_kP(PID_X, PID[1]);
        motorBottom.config_kP(PID_X, PID[2]);

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
