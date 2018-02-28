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
	}
	
	
	public double getDriverX()
	{
		return(-mDriverLeftStick.getRawAxis(1));
	}
	
	public double getDriverRot()
	{
		return (-mDriverRightStick.getRawAxis(0));
	}
	
	
	public boolean joysticksMoving()
	{
		return (Math.abs(getDriverX()) > Constants.kJoystickDeadzone || Math.abs(getDriverRot()) >= Constants.kJoystickDeadzone);
	}
	
	public boolean getShifterButton()
	{
		return mDriverLeftStick.getRawButton(1);
	}

	
	// operator inputs
	
	
	public boolean getIntakeButton()
	{
		return mOperatorPanel.getRawButton(Constants.kIntakeEnableButton);
	}
	
	public boolean getIntakeCancelButton()
	{
		return mOperatorPanel.getRawButton(Constants.kIntakeDisableButton);
	}
	
	public boolean getManualOpenIntake()
	{
		return mOperatorPanel.getRawButton(Constants.kIntakeOpenButton);
	}
	
	public boolean getManualCloseIntake()
	{
		return mOperatorPanel.getRawButton(Constants.kIntakeCloseButton);
	}
	
	public double getManualRollers()
	{
		return mOperatorPanel.getRawAxis(Constants.kIntakeRollersAxis);
	}
	
	public double getManualWrist()
	{
		return mOperatorPanel.getRawAxis(Constants.kIntakeWristAxis);
	}
	
	
	
	public boolean getClimberRelease()
	{
		return mOperatorPanel.getRawButton(Constants.kClimberReleaseButton);
	}

	public double getClimberSpeed()
	{
		return mOperatorPanel.getRawAxis(Constants.kClimberSpeedAxis);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// other inputs
	

	public int[] getAutoInputs()
	{
		// TODO: Poteniometer Logic for finding desired values
		
		
		
		return new int[]{0,0,0};
	}
	
	
}
