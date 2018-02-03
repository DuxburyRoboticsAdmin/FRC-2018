package org.usfirst.frc.team4908.robot.motion;

import java.awt.AWTException;
import java.awt.Robot;

import org.usfirst.frc.team4908.robot.IO.OperatorInterface;
import org.usfirst.frc.team4908.robot.motion.trajectories.Trajectory;
import org.usfirst.frc.team4908.robot.util.Constants;

import com.sun.glass.events.KeyEvent;

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
	
	
	public static DriveCommand followPath(int index, Trajectory t)
	{
        double dX = (t.getSetpoints().get(index).getdYdX() * 60.0 / (Constants.kWheelCircumference / 12.0)); // linear velocity in fps * 60 seconds/min *
        double dR = Math.toRadians(t.getSetpoints().get(index).getdHdS()) * 60.0 / Math.PI; // rotational velocity in radians per second
        double deltaV;

        deltaV = (Constants.kTrackWidth / 2.0) * dR;
        return new DriveCommand(dX - deltaV, dX + deltaV);
	}
	
	
	
	
	

}
