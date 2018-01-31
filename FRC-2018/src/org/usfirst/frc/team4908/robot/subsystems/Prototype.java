package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.IO.OperatorInterface;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Prototype extends Subsystem
{
	public static final Prototype mInstance = new Prototype();
	public static Prototype getInstance() { return mInstance; }
	
	private OperatorInterface oi = OperatorInterface.getInstance();
	
	TalonSRX cim_one;
	TalonSRX mc_one;
	
	DoubleSolenoid dx_one;
	DoubleSolenoid dx_two;
	
	private boolean isTwoDeployed;
	private boolean twoWasPressed;
	
	private Prototype()
	{
		cim_one = new TalonSRX(4);
		mc_one = new TalonSRX(1);
		
		dx_one = new DoubleSolenoid(0, 1);
		dx_two = new DoubleSolenoid(2, 3);
		
		isTwoDeployed = false;
		twoWasPressed = false;
		
	}
	
	@Override
	public void init() 
	{
		
	}
	
	@Override
	public void loop() 
	{	
		//cim_one.set(ControlMode.PercentOutput, oi.getPrAIOne());
		//mc_one.set(ControlMode.PercentOutput, oi.getPrAITwo());
		
		if(oi.getSolOne())
		{
			dx_one.set(DoubleSolenoid.Value.kForward);
		}
		else
		{
			dx_one.set(DoubleSolenoid.Value.kReverse);
		}
		
		
		if(oi.getSolTwo() && !twoWasPressed)
		{
			if(isTwoDeployed)
			{
				dx_two.set(DoubleSolenoid.Value.kReverse);
				isTwoDeployed = false;
			}
			else
			{
				dx_two.set(DoubleSolenoid.Value.kForward);
				isTwoDeployed = true;
			}
			
			twoWasPressed = true;
		}
		else if(!oi.getSolTwo() && twoWasPressed)
		{
			dx_two.set(DoubleSolenoid.Value.kOff);
			twoWasPressed = false;
		}
		
		
		
		
		
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
