package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.IO.OperatorInterface;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Prototype extends Subsystem
{
	public static final Prototype mInstance = new Prototype();
	public static Prototype getInstance() { return mInstance; }
	
	private OperatorInterface oi = OperatorInterface.getInstance();
	
	TalonSRX cim_one;
	TalonSRX mc_one;
	
	private Prototype()
	{
		cim_one = new TalonSRX(4);
		mc_one = new TalonSRX(1);
	}
	
	@Override
	public void init() 
	{
		
	}
	
	@Override
	public void loop() 
	{
		System.out.println("CIM: " + oi.getPrAIOne());
		System.out.println("MC: " + oi.getPrAITwo());
		
		cim_one.set(ControlMode.PercentOutput, oi.getPrAIOne());
		mc_one.set(ControlMode.PercentOutput, oi.getPrAITwo());
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
