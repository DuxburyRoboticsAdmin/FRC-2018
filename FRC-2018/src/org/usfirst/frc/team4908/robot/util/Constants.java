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
}
