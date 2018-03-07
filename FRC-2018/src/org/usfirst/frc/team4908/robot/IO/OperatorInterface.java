package org.usfirst.frc.team4908.robot.IO;

import org.usfirst.frc.team4908.robot.subsystems.Lift;
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
		return (-mDriverRightStick.getRawAxis(2));
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
	
	public double getIntakeValue()
	{
		return mOperatorPanel.getRawAxis(Constants.kIntakeLeftAxis) - mOperatorPanel.getRawAxis(Constants.kIntakeRightAxis);
	}
	
	
	public double getManualWrist()
	{
		return mOperatorPanel.getRawAxis(Constants.kWristAxis);
	}
	
	public double getMaualLift()
	{
		return(mOperatorPanel.getRawAxis(Constants.kLiftAxis1));
	}
	

	public double getManualClimb()
	{
		return -mOperatorPanel.getRawAxis(Constants.kClimbAxis);
	}
	
	public boolean getClimbRelease()
	{
		return mOperatorPanel.getRawButton(Constants.kClimbReleaseButton);
	}
	
	public boolean getClimbButton()
	{
		return mOperatorPanel.getRawButton(Constants.kClimbButton);
	}
	
	
	public Lift.liftHeight getDesiredLiftHeight()
	{
		if(mOperatorPanel.getRawButton(Constants.kBottomHeightButton))
		{
			return Lift.liftHeight.BOTTOM_SET;
		}
		else if(mOperatorPanel.getRawButton(Constants.kCarryHeightButton))
		{
			return Lift.liftHeight.CARRY_SET;
		}
		else if(mOperatorPanel.getRawButton(Constants.kTopHeightButton))		
		{
			return Lift.liftHeight.TOP_SET;
		}
		else if(mOperatorPanel.getRawButton(Constants.kBackHeightButton))
		{
			return Lift.liftHeight.BACK_SET;
		}
		else
		{
			return Lift.liftHeight.NULL_SET;
		}
	}
	
	
	
	// other inputs
	

	public int[] getAutoInputs()
	{
		// TODO: Poteniometer Logic for finding desired values
		
		
		
		return new int[]{0,0,0};
	}
	
	
}
