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
	public static final int kLeftMasterID 	= 16;
	public static final int kLeftSlaveID	= 23;
	public static final int kRightMasterID	= 11;
	public static final int kRightSlaveID	= 22;
	
	public static final double kDriveLeftP	= 0.0;
	public static final double kDriveLeftI	= 0.0;
	public static final double kDriveLeftD	= 0.0;
	public static final double kDriveLeftF	= 0.0;
	
	public static final double kDriveRightP	= 0.0;
	public static final double kDriveRightI	= 0.0;
	public static final double kDriveRightD	= 0.0;
	public static final double kDriveRightF	= 0.0;
	
	
	
	public static final int kShifterF		= 0;
	public static final int kShifterR		= 4;
	
	public static final double kTrackWidth	= 29.75;
	public static final double kWheelCircumference = 19.25;
	
	public static final double kJoystickDeadzone = 0.05;

	// INTAKE CONSTANTS
	public static final int kWristMotorID		= 30;
	public static final int kLeftIntakeMotorID	= 0;
	public static final int kRightIntakeMotorID	= 1;
	
	public static final int kLeftIntakeIRID		= -1;
	public static final int kRightIntakeIRID	= -1;
	
	public static final int kLeftIntakePistonF	= 3;
	public static final int kLeftIntakePistonR	= 7;
	
	public static final double kIRUpper = 10.0;
	public static final double kIRLower	= 0.0;
	
	// INTAKE CONTROLS
	public static final int kIntakeLeftAxis		= 2;
	public static final int kIntakeRightAxis	= 3;
	
	// LIFT CONSTANTS
	public static final int kLiftLeftMotorID	= 12;
	public static final int kLiftRightMotorID	= 15;
	
	// LIFT CONTROLS
	public static final int kLiftAxis1			= 1;	
	
	public static final double kLiftDeadzone 	= 0.1;
	public static final double kWristDeadzone	= 0.1;
	
	public static final int kBottomHeightButton = 1;
	public static final int kCarryHeightButton 	= 3;
	public static final int kTopHeightButton 	= 4;
	public static final int kBackHeightButton 	= 2;
	
	// LIFT HEIGHTS
	public static final double kBottomHeight	= 0.0;
	public static final double kCarryHeight		= 500000.0;
	public static final double kTopHeight		= 1350000.0;
	public static final double kBackHeight		= 1350000.0;
	
	public static final double kLiftEpsilon		= 50000.0;
	
	// WRISST ANGLES
	public static final double kBackAngle			= 0.0;
	public static final double kCarryAngle			= 0.0;
	public static final double kFlatAngle			= 0.0;
	public static final double kWristThresholdAngle = 0.0;
	

	public static final int kWristAxis	= -1;
	
	
	
	// CLIMBER CONSTANTS
	public static final int kClimberLeftTalonID		= 14;
	public static final int kClimberRightTalonID	= 13;
	public static final int	kClimberLeftVictorID	= 21;
	public static final int kClimberRightVictorID	= 17;
	
	public static final int kClimberLimitSwitchID	= 0;
	
	public static final int kClimbAxis				= 5;
	public static final int kClimbReleaseButton 	= 5;
	public static final int kClimbButton 			= 6;
	
	public static final double kClimbReleaseSpeed 	= -0.5;
	public static final double kClimbSpeed 			= 0.6;
	public static final double kClimbHoldSpeed		= 0.2;
	

}
