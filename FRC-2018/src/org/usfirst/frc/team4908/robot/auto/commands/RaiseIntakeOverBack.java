package org.usfirst.frc.team4908.robot.auto.commands;

import org.usfirst.frc.team4908.robot.auto.AutoCommand;
import org.usfirst.frc.team4908.robot.subsystems.Lift;
import org.usfirst.frc.team4908.robot.util.Constants;

public class RaiseIntakeOverBack extends AutoCommand
{
	int doneCount = 0;
	
	public RaiseIntakeOverBack(commandType type, double timeOutTime) 
	{
		super(type, timeOutTime);
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public void init() 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void loop() 
	{
		System.out.println("Loop");
		// TODO Auto-generated method stub
		Lift.getInstance().setLiftPosition(Lift.liftHeight.BACK_SET);	
	}

	@Override
	public boolean finished() 
	{
		System.out.println("FinishedMethod");
		if(Math.abs(Lift.getInstance().getLiftError()) <= Constants.kLiftEpsilon)
		{
			System.out.println("doneCount:\t" + doneCount);
			doneCount++;
		}
		
		// TODO Auto-generated method stub
		return doneCount >= 10;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

}
