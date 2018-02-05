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
		double left, right = 0;
        double dX = (t.getSetpoints().get(index).getdYdX() * 60.0 / ((Constants.kWheelCircumference / 12.0) * (50.0/24.0))); // linear velocity in fps * 60 seconds/min *
        double dR = Math.toRadians(t.getSetpoints().get(index).getdHdS()) * 60.0 / Math.PI; // rotational velocity in radians per second
        double deltaV;

        deltaV = (Constants.kTrackWidth / 2.0) * dR;
        
        left = (dX - deltaV) * 4096.0 / 600.0;
        right = (dX + deltaV) * 4096.0 / 600.0;
        
        
        System.out.println("Index: " + index + "\tLeft RPM: " + (dX - deltaV) + "\tRight RPM: " + (dX + deltaV));

        
        return new DriveCommand(left, right);
	}
	
	
	
	
	

}
