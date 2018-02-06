package org.usfirst.frc.team4908.robot.auto.commands;

import org.usfirst.frc.team4908.robot.auto.AutoCommand;

public class DoNothing extends AutoCommand
{

	public DoNothing(commandType type, double timeOutTime) 
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
		System.out.println("im gay -russo");
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean finished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

}
