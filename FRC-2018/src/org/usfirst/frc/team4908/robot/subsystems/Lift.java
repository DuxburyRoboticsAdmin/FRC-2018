package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.IO.OperatorInterface;
import org.usfirst.frc.team4908.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lift extends Subsystem
{
	public static Lift mInstance = new Lift();
	public static Lift getInstance()
	{
		return mInstance;
	}

	private TalonSRX mLeft;
	private TalonSRX mRight;
	private TalonSRX mWrist;
	
	public static enum liftHeight
	{
		BOTTOM_SET,
		CARRY_SET,
		TOP_SET,
		BACK_SET,
		NULL_SET
	}
	public liftHeight mDesiredHeight;
	
	public double mLiftSetpoint;
	public double mWristSetpoint;
	
	public Lift()
	{
		mDesiredHeight = liftHeight.NULL_SET;
		
		mLeft 	= new TalonSRX(Constants.kLiftLeftMotorID);
		mRight 	= new TalonSRX(Constants.kLiftRightMotorID);
		
		
		mLeft.configNominalOutputForward(0, 0);
		mLeft.configNominalOutputReverse(0, 0);
		mLeft.configPeakOutputForward(1, 0);
		mLeft.configPeakOutputReverse(-1, 0);
		mLeft.setInverted(true);
		mRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		mRight.configNominalOutputForward(0, 0);
		mRight.configNominalOutputReverse(0, 0);
		mRight.configPeakOutputForward(1, 0);
		mRight.configPeakOutputReverse(-1, 0);
		mRight.setSensorPhase(true);
		mRight.configClosedloopRamp(0.25, 0);
		mLeft.follow(mRight);
		
		
		mWrist = new TalonSRX(Constants.kWristMotorID);

		mWrist.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		mWrist.configNominalOutputForward(0, 0);
		mWrist.configNominalOutputReverse(0, 0);
		mWrist.configPeakOutputForward(1, 0);
		mWrist.configPeakOutputReverse(-1, 0);
		mWrist.setInverted(true);
		mWrist.setSensorPhase(false);
	}
	
	
	@Override
	public void init() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loop() 
	{	
		// TODO: ADD IN INTAKE INPUTS AS WELL
		
		// GRAB THE DESIRED HEIGHT / POSITION OF THE LIFT / WRIST
		mDesiredHeight = OperatorInterface.getInstance().getDesiredLiftHeight();

		switch(mDesiredHeight)
		{
			case BOTTOM_SET:
			{
				mLiftSetpoint = Constants.kBottomHeight;
				mWristSetpoint = Constants.kFlatAngle;
				break;
			}
			case CARRY_SET:
			{
				mLiftSetpoint = Constants.kCarryHeight;
				mWristSetpoint = Constants.kCarryAngle;
				break;
			}
			case TOP_SET:
			{
				mLiftSetpoint = Constants.kTopHeight;
				mWristSetpoint = Constants.kFlatAngle;
				break;
			}
			case BACK_SET:
			{
				mLiftSetpoint = Constants.kBackHeight;
				mWristSetpoint = Constants.kBackAngle;
				break;
			}
			default:
			{
				break;
			}
		}
		
		// IF IT IS AT THE BOTTOM, ZERO THE ENCODER
		if(mLiftSetpoint == Constants.kBottomHeight && mRight.getSelectedSensorPosition(0) <= 5000)
		{
			mRight.setSelectedSensorPosition(0, 0, 0);
		}
	
		// IF THE WRIST WILL NOT GET IN THE WAY OF THE LIFTS MOTION
		if(mWrist.getSelectedSensorPosition(0) <= Constants.kWristThresholdAngle)
		{
			// If the manual operation is desired
			if(Math.abs(OperatorInterface.getInstance().getMaualLift()) >= Constants.kLiftDeadzone)
			{
				mRight.set(ControlMode.PercentOutput, OperatorInterface.getInstance().getMaualLift());
				mLeft.set(ControlMode.PercentOutput, OperatorInterface.getInstance().getMaualLift());
				
				mDesiredHeight = liftHeight.NULL_SET;
			}
			// if the desired height is not null (is not being overridden by the manual operation
			else if(mDesiredHeight != liftHeight.NULL_SET)
			{
				mRight.set(ControlMode.Position, mLiftSetpoint);
				mLeft.set(ControlMode.Follower, Constants.kLiftRightMotorID);
			}
			else
			{
				mRight.set(ControlMode.Disabled, 0);
				mLeft.set(ControlMode.Disabled, 0);
			}
		}
		else
		{
			mRight.set(ControlMode.Disabled, 0);
			mLeft.set(ControlMode.Disabled, 0);
		}
		
		// if the manual operation of the wrist is desired
		if(Math.abs(OperatorInterface.getInstance().getManualWrist()) >= Constants.kWristDeadzone)
		{
			mWrist.set(ControlMode.PercentOutput, OperatorInterface.getInstance().getManualWrist());
		}
		else
		{
			if(mWristSetpoint == Constants.kBackAngle)
			{
				// super structure collision avoidance
				if(mRight.getSelectedSensorPosition(0) >= 0.95 * Constants.kTopHeight)
				{
					mWrist.set(ControlMode.Position, Constants.kBackAngle);
				}
			}
			else if(mWristSetpoint == Constants.kFlatAngle)
			{
				mWrist.set(ControlMode.Position, Constants.kFlatAngle);
			}
			else if(mWristSetpoint == Constants.kCarryAngle)
			{
				mWrist.set(ControlMode.Position, Constants.kCarryAngle);
			}
		}
		
		SmartDashboard.putNumber("Position", mRight.getSelectedSensorPosition(0));
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
	
	
	public void setLiftPosition(liftHeight lh)
	{		
		if(lh.equals(liftHeight.BACK_SET))
		{
			mRight.set(ControlMode.Position, Constants.kBackHeight);
			mLeft.set(ControlMode.Follower, Constants.kLiftRightMotorID);
			//mWrist.set(ControlMode.Position, Constants.kBackAngle);
		}
		else if(lh.equals(liftHeight.BOTTOM_SET))
		{
			mRight.set(ControlMode.Position, Constants.kBottomHeight);
			mLeft.set(ControlMode.Follower, Constants.kLiftRightMotorID);
			//mWrist.set(ControlMode.Position, Constants.kFlatAngle);
		}
		else if(lh.equals(liftHeight.CARRY_SET))
		{
			mRight.set(ControlMode.Position, Constants.kCarryHeight);
			mLeft.set(ControlMode.Follower, Constants.kLiftRightMotorID);
			//mWrist.set(ControlMode.Position, Constants.kCarryAngle);
		}
		
		SmartDashboard.putNumber("Position", mRight.getSelectedSensorPosition(0));

	}
	
	public double getLiftError()
	{
		return mRight.getClosedLoopError(0);
	}
	
	public double getWristError()
	{
		return 0.0;
	}

}
