package org.usfirst.frc.team4908.robot.auto.commands;

import org.usfirst.frc.team4908.robot.auto.AutoCommand;
import org.usfirst.frc.team4908.robot.subsystems.Drive;

public class DriveForTime extends AutoCommand
{
	double mSpeed;
	double startAngle;
	double currentAngle;

	// constructor for INITIAL command
	public DriveForTime(commandType type, double speed, double time) 
	{
		super(type, time);
		this.mSpeed = speed;
	}
	
	
	
	public void init()
	{
		// call drive class to init for velocity control
		startAngle = 0; // CURRENT ANGLE FROM NAVX
	}
	
	
	public void loop()
	{
		Drive.getInstance().driveForTime(mSpeed, (currentAngle - startAngle));
	}


	@Override
	public boolean finished() 
	{
		// this will simply use the time out from the super class because we dont really have any other condition
		return super.timeOut();
	}


	@Override
	public void end() 
	{
		// call drive class to reset talons to default mode
	}
	

}
