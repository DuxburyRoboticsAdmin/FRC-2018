package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.IO.OperatorInterface;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Intake extends Subsystem
{
	public static final Intake mInstance = new Intake();
	public static Intake getInstance() { return mInstance; }
	
	OperatorInterface oi = OperatorInterface.getInstance();
	
	private TalonSRX left_motor;
	private TalonSRX right_motor;
	private TalonSRX wrist_motor;
	
	
	public Intake()
	{	
		
		
	}
	

	@Override
	public void init() 
	{
		
	}

	@Override
	public void loop() 
	{
		
		
		
		
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
