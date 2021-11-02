package frc.robot.subsystems.swerve.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.UnitModel;
import frc.robot.subsystems.swerve.SwerveDrive;

import static frc.robot.Constants.SwerveModule.TICKS_PER_RADIAN;
import static frc.robot.Constants.TICKS_PER_DEGREE;
import static frc.robot.Ports.SwerveDrive.JOYSTICK;

public class Drive extends CommandBase {
    private SwerveDrive swerveDrive = new SwerveDrive();
    private Joystick joystick = new Joystick(JOYSTICK);
    private UnitModel unitModel = new UnitModel(TICKS_PER_RADIAN);
    private UnitModel unitModel2 = new UnitModel(TICKS_PER_DEGREE);

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        double output = Math.hypot(joystick.getX(), joystick.getY());
        double joystickAngle = unitModel2.toUnits(unitModel.toTicks(Math.atan2(joystick.getY(), joystick.getX())));

        swerveDrive.follow();
        swerveDrive.driveInDirection(output, joystickAngle);
        swerveDrive.unfollow();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
