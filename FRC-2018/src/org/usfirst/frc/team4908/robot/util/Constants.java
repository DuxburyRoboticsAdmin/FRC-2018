package org.usfirst.frc.team4908.robot.util;

public class Constants 
{
	// AUTO CONSTANTS
	public enum RobotPosition
	{
		LEFT,
		MIDDLE,
		RIGHT
	}
	
	
	// DRIVE CONSTANTS
	public static final int kLeftMasterID 	= 4;
	public static final int kLeftSlaveID	= 6;
	public static final int kRightMasterID	= 3;
	public static final int kRightSlaveID	= 7;
	
	public static final double kTrackWidth	= 29.75;
	public static final double kWheelCircumference = 19.25;
	
	public static final double kJoystickDeadzone = 0.05;

	// INTAKE CONSTANTS
	public static final int kWristMotorID		= -1;
	public static final int kLeftIntakeMotorID	= -1;
	public static final int kRightIntakeMotorID	= -1;


	// LIFT CONSTANTS
	public static final int kLiftTalonID	= -1;
	public static final int kLiftVictorID	= -1;
	
	public static final int kLeftIntakePotID	= -1;
	public static final int kRightIntakePotID	= -1;
	
	public static final int kLeftIntakeIRID		= -1;
	public static final int kRightIntakeIRID	= -1;
	
	public static final int kLeftIntakePistonF	= -1;
	public static final int kLeftIntakePistonR	= -1;
	public static final int kRightIntakePistonF	= -1;
	public static final int kRightIntakePistonR	= -1;
	
	// INTAKE CONTROLS
	public static final int kIntakeEnableButton	= -1;
	public static final int kIntakeDisableButton= -1;
	public static final int kIntakeOpenButton	= -1;
	public static final int kIntakeCloseButton	= -1;
	public static final int kIntakeRollersAxis	= -1;
	public static final int kIntakeWristAxis	= -1;
	
	
	// CLIMBER CONSTANTS
	public static final int kClimberLeftTalonID		= -1;
	public static final int kClimberRightTalonID	= -1;
	public static final int	kClimberLeftVictorID	= -1;
	public static final int kClimberRightVictorID	= -1;
	
	public static final int kClimberSolenoidForward	= -1;
	public static final int kClimberSolenoidReverse	= -1;

	public static final int kClimberSwitchID		= -1;
	public static final int kClimberMaxSpeed		= -1;

	public static final int kClimberReleaseButton	= -1;
	public static final int kClimberSpeedAxis		= -1;

	public static final double kClimberP			= 0.0;
	public static final double kClimberI			= 0.0;
	public static final double kClimberD			= 0.0;
	public static final double kClimberF			= 0.0;

}
