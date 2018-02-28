package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.IO.OperatorInterface;
import org.usfirst.frc.team4908.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Lift extends Subsystem
{
	public static Lift mInstance = new Lift();
	public static Lift getInstance()
	{
		return mInstance;
	}

	private TalonSRX mLeft;
	private TalonSRX mRight;
	
	
	public Lift()
	{
		mLeft 	= new TalonSRX(Constants.kLiftLeftMotorID);
		mRight 	= new TalonSRX(Constants.kLiftRightMotorID);
	}
	
	
	@Override
	public void init() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loop() 
	{
		// TODO Auto-generated method stub
		
		mLeft.set(ControlMode.PercentOutput, -OperatorInterface.getInstance().getMaualLift() * 0.5);
		mRight.set(ControlMode.PercentOutput, OperatorInterface.getInstance().getMaualLift() * 0.5);
		
	}

	@Override
	public void end() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interrupt() 
	{
		// TODO Auto-generated method stub
		
	}

}
