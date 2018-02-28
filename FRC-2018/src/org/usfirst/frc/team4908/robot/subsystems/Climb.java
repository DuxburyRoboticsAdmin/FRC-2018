package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.IO.OperatorInterface;
import org.usfirst.frc.team4908.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.sun.corba.se.impl.orbutil.closure.Constant;

import edu.wpi.first.wpilibj.DigitalInput;

public class Climb extends Subsystem
{
	public static final Climb mInstance = new Climb();
	public static Climb getInstance()
	{
		return mInstance;
	}
	public OperatorInterface oi = OperatorInterface.getInstance();
	
	
	private TalonSRX mLeftMaster;
	private TalonSRX mRightMaster;
	private VictorSPX mLeftSlave;
	private TalonSRX mRightSlave;
	
	private DigitalInput mLimitSwitch;
	
	private enum ClimbState
	{
		RESTING_DOWN,
		RAISING,
		RESTING_UP,
		CLIMBING,
		HOLDING
	}
	private ClimbState mState;
	
	
	private Climb()
	{
		mLeftMaster 	= new TalonSRX(Constants.kClimberLeftTalonID);
		mRightMaster 	= new TalonSRX(Constants.kClimberRightTalonID);
		mLeftSlave		= new VictorSPX(Constants.kClimberLeftVictorID);
		mRightSlave		= new TalonSRX(Constants.kClimberRightVictorID);

		mLeftMaster.configNominalOutputForward(0, 0);
		mLeftMaster.configNominalOutputReverse(0, 0);
		mLeftMaster.configPeakOutputForward(1, 0);
		mLeftMaster.configPeakOutputReverse(-1, 0);
		
		mRightMaster.configNominalOutputForward(0, 0);
		mRightMaster.configNominalOutputReverse(0, 0);
		mRightMaster.configPeakOutputForward(1, 0);
		mRightMaster.configPeakOutputReverse(-1, 0);
		
		mLeftSlave.configNominalOutputForward(0, 0);
		mLeftSlave.configNominalOutputReverse(0, 0);
		mLeftSlave.configPeakOutputForward(1, 0);
		mLeftSlave.configPeakOutputReverse(-1, 0);
		
		mRightSlave.configNominalOutputForward(0, 0);
		mRightSlave.configNominalOutputReverse(0, 0);
		mRightSlave.configPeakOutputForward(1, 0);
		mRightSlave.configPeakOutputReverse(-1, 0);
		
		mLeftSlave.follow(mLeftMaster);
		mRightSlave.follow(mRightMaster);
		
		mLeftMaster.setInverted(false);
		mLeftMaster.setInverted(false);
		
		mRightMaster.setInverted(true);
		mRightSlave.setInverted(true);
		
		mLimitSwitch = new DigitalInput(Constants.kClimberLimitSwitchID);		
	}

	@Override
	public void init() 
	{
		mState = ClimbState.RESTING_DOWN;
	}

	@Override
	public void loop()
	{

		switch(mState)
		{
			case RESTING_DOWN:
			{
				if(oi.getClimbRelease())
				{
					mState = ClimbState.RAISING;
				}
				setMotors(0.0);
				break; 
			}
			case RAISING:
			{
				if(oi.getClimbRelease())
				{
					setMotors(Constants.kClimbReleaseSpeed);
				}
				else
				{
					mState = ClimbState.RESTING_UP;
				}
				break;
			}
			case RESTING_UP: 
			{
				if(oi.getClimbRelease())
				{
					mState = ClimbState.RAISING;
				}
				else if(oi.getClimbButton())
				{
					mState = ClimbState.CLIMBING;
				}
				setMotors(0.0);
				break;

			}
			case CLIMBING:
			{
				if(mLimitSwitch.get())
				{
					setMotors(Constants.kClimbSpeed);
				}
				else
				{
					mState = ClimbState.HOLDING;
				}
				break;

			}
			case HOLDING:
			{
				if(!mLimitSwitch.get())
				{
					setMotors(Constants.kClimbHoldSpeed);
				}
				
				if(oi.getClimbButton())
				{
					mState = ClimbState.CLIMBING;
				}
				else if(oi.getClimbRelease())
				{
					mState = ClimbState.RESTING_DOWN;
				}
				break;

			}
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

	public void setMotors(double speed)
	{
		mLeftMaster.set(ControlMode.PercentOutput, speed);
		mRightMaster.set(ControlMode.PercentOutput, speed);
	}
	
}
