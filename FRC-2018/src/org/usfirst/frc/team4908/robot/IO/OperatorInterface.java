package org.usfirst.frc.team4908.robot.IO;

import org.usfirst.frc.team4908.robot.util.Constants;

import edu.wpi.first.wpilibj.Joystick;

public class OperatorInterface 
{
	public static OperatorInterface mInstance = new OperatorInterface();
	public static OperatorInterface getInstance() { return mInstance;}
	
	public Joystick mDriverLeftStick;
	public Joystick mDriverRightStick;
	public Joystick mOperatorPanel; 
	
	public OperatorInterface()
	{
		mDriverLeftStick 	= new Joystick(0);
		mDriverRightStick 	= new Joystick(1);
		mOperatorPanel 		= new Joystick(2);	
	}
	
	
	public double getDriverX()
	{
		return(mDriverLeftStick.getRawAxis(0));
	}
	
	public double getDriverRot()
	{
		return (mDriverRightStick.getRawAxis(1));
	}
	
	
	public boolean joysticksMoving()
	{
		return (Math.abs(getDriverX()) > Constants.kJoystickDeadzone || Math.abs(getDriverRot()) >= Constants.kJoystickDeadzone);
	}
}
