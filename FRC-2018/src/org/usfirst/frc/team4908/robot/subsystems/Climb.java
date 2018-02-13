package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Climb extends Subsystem
{
	public static final Climb mInstance = new Climb();
	public static Climb getInstance()
	{
		return mInstance;
	}
	
	
	private TalonSRX mLeftMaster;
	private TalonSRX mRightMaster;
	private VictorSPX mLeftSlave;
	private VictorSPX mRightSlave;
	
	
	private Climb()
	{
		mLeftMaster 	= new TalonSRX(Constants.kClimberLeftTalonID);
		mRightMaster 	= new TalonSRX(Constants.kClimberRightTalonID);
		mLeftSlave		= new VictorSPX(Constants.kClimberLeftVictorID);
		mRightSlave		= new VictorSPX(Constants.kClimberRightVictorID);
		
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
