package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;


public class RobotTemplate extends SimpleRobot {
    final int SPEED_CONTROLLER_SLOT = 1;
    final int LEFT_DRIVETRAIN = 1;
    final int RIGHT_DRIVETRAIN = 2;
    final int JOYSTICK = 1;
    final int X_AXIS = 2;
    final int Y_AXIS = 4;
    
    Victor leftVictor = new Victor(SPEED_CONTROLLER_SLOT,LEFT_DRIVETRAIN);
    Victor rightVictor = new Victor(SPEED_CONTROLLER_SLOT,RIGHT_DRIVETRAIN); 
    RobotDrive drivetrain = new RobotDrive(leftVictor, rightVictor); 
    Joystick joystick = new Joystick(JOYSTICK);
   
    public void robotInit() {
        drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        leftVictor.enableDeadbandElimination(true);
        rightVictor.enableDeadbandElimination(true);
    }

   
    public void operatorControl() {
        drivetrain.setSafetyEnabled(true);
        while(isOperatorControl() && this.isEnabled()) {
            drivetrain.arcadeDrive(joystick.getRawAxis(X_AXIS), joystick.getRawAxis(Y_AXIS));
            Timer.delay(0.01);   
        }
    }
}
