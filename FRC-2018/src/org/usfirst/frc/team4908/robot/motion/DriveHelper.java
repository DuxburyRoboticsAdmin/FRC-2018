package org.usfirst.frc.team4908.robot.motion;

import org.usfirst.frc.team4908.robot.IO.OperatorInterface;

public class DriveHelper 
{
	public static DriveCommand joystickDrive()
	{
		double x = OperatorInterface.getInstance().getDriverX();
		double rot = OperatorInterface.getInstance().getDriverRot();
	
		x = x * Math.abs(x);
		rot = rot * Math.abs(rot);

		if(x > 1.0)
			x = 1.0;
		else if(x < -1.0)
			x = -1.0;
		
		if(rot > 1.0)
			rot = 1.0;
		else if(rot < -1.0)
			rot = -1.0;
		
		
		return new DriveCommand(x - rot, x + rot);
	}
	
	
	

}
