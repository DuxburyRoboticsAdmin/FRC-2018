package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.IO.OperatorInterface;
import org.usfirst.frc.team4908.robot.motion.DriveCommand;
import org.usfirst.frc.team4908.robot.motion.DriveHelper;
import org.usfirst.frc.team4908.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;

public class Drive extends Subsystem
{
	public static final Drive mInstance = new Drive();
	public static Drive getInstance()
	{
		return mInstance;
	}
	
	private TalonSRX leftMaster;
	private TalonSRX leftSlave;
	private TalonSRX rightMaster;
	private TalonSRX rightSlave;
	
	private DoubleSolenoid mShifter;
	
	
	private OperatorInterface oi = OperatorInterface.getInstance();
	
	private boolean mShifterWasPressed = false;
	private boolean isHighGear = true;
	
	private enum DriveState
	{
		NEUTRAL,
		OPEN_LOOP,
		PATH_FOLLOWER,
		ROTATE_TO_ANGLE,
		DRIVE_TO_DISTANCE
	}
	private static DriveState mDriveState;
	
	
	private Drive()
	{
		leftMaster = new TalonSRX(Constants.kLeftMasterID);
		leftSlave = new TalonSRX(Constants.kLeftSlaveID);
		rightMaster = new TalonSRX(Constants.kRightMasterID);
		rightSlave = new TalonSRX(Constants.kRightSlaveID);	
	
		mShifter = new DoubleSolenoid(0,1);
	}
	

	@Override
	public void init() 
	{
		mDriveState = DriveState.NEUTRAL;
	}

	@Override
	public void loop() 
	{
		if(OperatorInterface.getInstance().joysticksMoving())
		{
			mDriveState = DriveState.OPEN_LOOP;
		}
		else
		{
			mDriveState = DriveState.NEUTRAL;
		}
		
		switch(mDriveState)
		{
			case NEUTRAL:
			{		
				setMotors(new DriveCommand(0,0));
				break;
			}
			case OPEN_LOOP:
			{
				setMotors(DriveHelper.joystickDrive());
				break;
			}
		}
		
		
		

		if(oi.getSolTwo() && !mShifterWasPressed)
		{
			if(isHighGear)
			{
				mShifter.set(DoubleSolenoid.Value.kReverse);
				isHighGear = false;
			}
			else
			{
				mShifter.set(DoubleSolenoid.Value.kForward);
				isHighGear = true;
			}
			
			mShifterWasPressed = true;
		}
		else if(!oi.getSolTwo() && mShifterWasPressed)
		{
			mShifter.set(DoubleSolenoid.Value.kOff);
			mShifterWasPressed = false;
		}
		
		
		
	}
	
	
	public void setMotors(DriveCommand dc)
	{
		//TODO: add talon setting stuff
		
		leftMaster.set(ControlMode.PercentOutput, -dc.getLeft());
		rightMaster.set(ControlMode.PercentOutput, dc.getRight());
		leftSlave.set(ControlMode.Follower, Constants.kLeftMasterID);
		rightSlave.set(ControlMode.Follower, Constants.kRightMasterID);
	}

	@Override
	public void end() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interrupt() 
	{
		mDriveState = DriveState.NEUTRAL;
		
	}
	
	
	
	
	
	// AUTON METHODS
	
	public void driveForTime(double speed, double angle)
	{
		// TODO: ADD ANGLE CORRECTION
		// TODO: DECIDE ON STATIC P GAIN (good enough lmao) OR PID LOOP (hard)
		
		setMotors(new DriveCommand(speed, speed));
	}	
	
	
	
	public void followPath(DriveCommand dc)
	{
		leftMaster.set(ControlMode.Velocity, -dc.getLeft());
		rightMaster.set(ControlMode.Velocity, dc.getRight());
		
		leftSlave.set(ControlMode.Follower, Constants.kLeftMasterID);
		rightSlave.set(ControlMode.Follower, Constants.kRightMasterID);
		
	}
	
	public void configTalonsVelocityMode()
	{
		leftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		rightMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
	
		leftMaster.configNominalOutputForward(0, 10);
		leftMaster.configNominalOutputReverse(0, 10);
		leftMaster.configPeakOutputForward(1, 10);
		leftMaster.configPeakOutputReverse(-1, 10);
		
		rightMaster.configNominalOutputForward(0, 10);
		rightMaster.configNominalOutputReverse(0, 10);
		rightMaster.configPeakOutputForward(1, 10);
		rightMaster.configPeakOutputReverse(-1, 10);
	}
		
	
}
