package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.IO.OperatorInterface;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Intake extends Subsystem
{
	public static final Intake mInstance = new Intake();
	public static Intake getInstance() { return mInstance; }
	
	TalonSRX leftMotor;
	TalonSRX rightMotor;
	
	OperatorInterface oi = OperatorInterface.getInstance();
	
	
	public Intake()
	{
		leftMotor = new TalonSRX(2);
		rightMotor = new TalonSRX(8);
	}
	

	@Override
	public void init() 
	{
		
	}

	@Override
	public void loop() 
	{
		leftMotor.set(ControlMode.PercentOutput, oi.getDriverX());
		rightMotor.set(ControlMode.PercentOutput, -oi.getDriverX());
	
	}

	@Override
	public void end() 
	{
		
	}

	@Override
	public void interrupt() 
	{
		
	}

}
