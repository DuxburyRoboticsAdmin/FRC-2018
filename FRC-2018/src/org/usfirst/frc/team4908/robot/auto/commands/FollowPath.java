package org.usfirst.frc.team4908.robot.auto.commands;

import org.usfirst.frc.team4908.robot.auto.*;
import org.usfirst.frc.team4908.robot.motion.DriveHelper;
import org.usfirst.frc.team4908.robot.motion.trajectories.Trajectory;
import org.usfirst.frc.team4908.robot.subsystems.Drive;

public class FollowPath extends AutoCommand
{
	Trajectory mTrajectory;
	int mIndex;
	
	public FollowPath(commandType type, double timeOutTime, Trajectory trajectory) 
	{
		super(type, timeOutTime);
		
		this.mTrajectory = trajectory;
	}

	@Override
	public void init() 
	{
		mIndex = 0;
		// TODO: INIT TALONS FOR VELOCITY CONTROL
	
	}

	@Override
	public void loop() 
	{
		Drive.getInstance().setMotors(DriveHelper.followPath(mIndex, mTrajectory));
		mIndex++;
	}

	@Override
	public boolean finished() 
	{	
		return mIndex > mTrajectory.getSetpoints().size() - 1;
	}

	@Override
	public void end() 
	{
		
	}

}
