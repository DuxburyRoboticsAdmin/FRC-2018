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
<<<<<<< HEAD
	public static final int kWristMotorID		= -1;
	public static final int kLeftIntakeMotorID	= -1;
	public static final int kRightIntakeMotorID	= -1;


	// LIFT CONSTANTS
	public static final int kLiftTalonID	= -1;
	public static final int kLiftVictorID	= -1;
	
	public static final int kLeftIntakePotID	= -1;
	public static final int kRightIntakePotID	= -1;
=======
	public static final int kWristMotorID		= 30;
	public static final int kLeftIntakeMotorID	= 0;
	public static final int kRightIntakeMotorID	= 1;
>>>>>>> 18b4c03f387c5d30c0ad64cd1de99ae700c319cb
	
	public static final int kLeftIntakeIRID		= -1;
	public static final int kRightIntakeIRID	= -1;
	
	public static final int kLeftIntakePistonF	= 3;
	public static final int kLeftIntakePistonR	= 7;
	
	// INTAKE CONTROLS
	public static final int kIntakeEnableButton	= 1;
	public static final int kIntakeDisableButton= 4;
	public static final int kIntakeOpenButton	= 2;
	public static final int kIntakeCloseButton	= 3;
	public static final int kIntakeRollersAxis	= 1;
	public static final int kIntakeWristAxis	= -1;
	
	
	// LIFT CONSTANTS
	public static final int kLiftLeftMotorID	= 12;
	public static final int kLiftRightMotorID	= 15;
	
	// LIFT CONTROLS
	public static final int kLiftAxis1	= 3;
	public static final int kLiftAxis2	= 2;
	
	
	// CLIMBER CONSTANTS
	public static final int kClimberLeftTalonID		= 14;
	public static final int kClimberRightTalonID	= 13;
	public static final int	kClimberLeftVictorID	= 21;
	public static final int kClimberRightVictorID	= 17;
	
<<<<<<< HEAD
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
=======
	public static final int kClimberLimitSwitchID	= 0;
	
	public static final int kClimbAxis				= 5;
	public static final int kClimbReleaseButton 	= 5;
	public static final int kClimbButton 			= 6;
	
	public static final double kClimbReleaseSpeed 	= -0.5;
	public static final double kClimbSpeed 			= 0.6;
	public static final double kClimbHoldSpeed		= 0.2;
>>>>>>> 18b4c03f387c5d30c0ad64cd1de99ae700c319cb

}
