package org.usfirst.frc.team4908.robot.IO;

import org.usfirst.frc.team4908.robot.util.Constants;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;

public class OperatorInterface 
{
	public static final OperatorInterface mInstance = new OperatorInterface();
	public static OperatorInterface getInstance() { return mInstance;}
	
	public Joystick mDriverLeftStick;
	public Joystick mDriverRightStick;
	public Joystick mOperatorPanel; 
	
	
	public AnalogInput pr_analog_one;
	public AnalogInput pr_analog_two;
	
	public OperatorInterface()
	{
		mDriverLeftStick 	= new Joystick(0);
		mDriverRightStick 	= new Joystick(1);
		mOperatorPanel 		= new Joystick(2);	
		
		pr_analog_one = new AnalogInput(0);
		pr_analog_two = new AnalogInput(1);
	}
	
	
	public double getDriverX()
	{
		return(mDriverLeftStick.getRawAxis(1));
	}
	
	public double getDriverRot()
	{
		return (mDriverRightStick.getRawAxis(0));
	}
	
	
	public boolean joysticksMoving()
	{
		return (Math.abs(getDriverX()) > Constants.kJoystickDeadzone || Math.abs(getDriverRot()) >= Constants.kJoystickDeadzone);
	}
	
	public boolean getSolOne()
	{
		return mDriverLeftStick.getRawButton(3);
		
	}
	
	public boolean getSolTwo()
	{
		return mDriverLeftStick.getRawButton(4);
	}
	
	public boolean getSolThree()
	{
		return mDriverLeftStick.getRawButton(5);
	}
	
	
	public double getPrAIOne()
	{
		return 2 * (pr_analog_one.getAverageValue() / 4096.0) - 1.0;
	}
	
	public double getPrAITwo()
	{
		return 2 * (pr_analog_two.getAverageValue() / 4096.0) - 1.0;
	}

	public int[] getAutoInputs()
	{
		// TODO: Poteniometer Logic for finding desired values
		return new int[]{0,0,0};
	}
}
