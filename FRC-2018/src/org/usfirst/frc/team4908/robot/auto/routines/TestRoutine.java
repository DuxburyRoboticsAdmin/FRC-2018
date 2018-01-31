package org.usfirst.frc.team4908.robot.auto.routines;

import org.usfirst.frc.team4908.robot.auto.AutoCommand.commandType;
import org.usfirst.frc.team4908.robot.auto.AutoRoutine;
import org.usfirst.frc.team4908.robot.auto.commands.DriveForTime;

public class TestRoutine extends AutoRoutine
{

	@Override
	public void routine() 
	{
		addCommand(new DriveForTime(commandType.INITIAL, 12.0, 3.5));
		addCommand(new DriveForTime(commandType.SEQUENTIAL, -5.0, 2.0));
		
	}
	
	
	

}
