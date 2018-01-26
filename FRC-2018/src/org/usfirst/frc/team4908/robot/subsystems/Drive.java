package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.IO.OperatorInterface;
import org.usfirst.frc.team4908.robot.motion.DriveCommand;
import org.usfirst.frc.team4908.robot.motion.DriveHelper;

import edu.wpi.first.wpilibj.SpeedController;

public class Drive extends Subsystem
{
	public static final Drive mInstance = new Drive();
	public static Drive getInstance()
	{
		return mInstance;
	}
	
	private SpeedController leftMaster;
	private SpeedController leftSlave;
	private SpeedController rightMaster;
	private SpeedController rightSlave;
	
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
		//frontLeft = new SpeedController(Constants.kLeftMasterID);
		//rearLeft = new SpeedController(Constants.kLeftSlaveID);
		//frontRight = new SpeedController(Constants.kRightMasterID);
		//rearRight = new SpeedController(Constants.kRightSlaveID);
		
		
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
	}
	
	
	private void setMotors(DriveCommand dc)
	{
		//TODO: add talon setting stuff
		
		/**
		 
		 mLeftMaster.set(dc.getLeft());
		 mRightMaster.set(dc.getRight());
		 
		 
		 
		 */
		
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

	
	

}
