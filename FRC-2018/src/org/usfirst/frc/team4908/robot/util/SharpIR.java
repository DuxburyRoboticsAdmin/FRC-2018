package org.usfirst.frc.team4908.robot.util;

import edu.wpi.first.wpilibj.AnalogInput;

public class SharpIR extends AnalogInput
{
	// TODO: fix this value I guess
	private static final double K_VAL = 9.48; 
	

	public SharpIR(int channel)
	{
		super(channel);
	}
	
	
	
	public double getDistance()
	{
		return K_VAL / (this.getVoltage() - 0.42);
	}

}
