package org.usfirst.frc.team4908.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import org.usfirst.frc.team4908.robot.IO.OperatorInterface;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import org.usfirst.frc.team4908.robot.util.Constants;
import org.usfirst.frc.team4908.robot.util.SharpIR;

public class Intake extends Subsystem
{
	public static final Intake mInstance = new Intake();
	public static Intake getInstance() { return mInstance; }
	OperatorInterface oi = OperatorInterface.getInstance();

	private DoubleSolenoid mIntakePiston;

	private VictorSP mLeftArmMotor;
	private VictorSP mRightArmMotor;

	private SharpIR mRightIR;
	private SharpIR mLeftIR;
	
	private boolean mDeployed;
	private boolean mDropping;
	private boolean mEjecting;
	
	
	
	public enum IntakeState
	{
		GETTING,
		CLOSING,
		DISABLED
	}
	public IntakeState mIntakeState;
	
	public Intake()
	{
		mIntakePiston = new DoubleSolenoid(Constants.kLeftIntakePistonF, Constants.kLeftIntakePistonR);
		
		mLeftArmMotor 	= new VictorSP(Constants.kLeftIntakeMotorID);
		mRightArmMotor 	= new VictorSP(Constants.kRightIntakeMotorID);
		
		mRightIR = new SharpIR(Constants.kRightIntakeIRID);
		mLeftIR = new SharpIR(Constants.kLeftIntakeIRID);

	}
	

	@Override
	public void init() 
	{
		
	}

	@Override
	public void loop() 
	{
		if(oi.getIntakeValue() >= 0.1)
		{
			mIntakeState = IntakeState.GETTING;
		}
		
		
		if(mIntakeState == IntakeState.GETTING)
		{
			mIntakePiston.set(Value.kForward);
			mLeftArmMotor.set(oi.getIntakeValue());
			mRightArmMotor.set(oi.getIntakeValue());
			
			if(mRightIR.getDistance() <= Constants.kIRUpper && mRightIR.getDistance() >= Constants.kIRLower &&
					mLeftIR.getDistance() <= Constants.kIRUpper && mLeftIR.getDistance() >= Constants.kIRLower)
			{
				mIntakePiston.set(Value.kReverse);
				mIntakeState = IntakeState.CLOSING;
			}
			
			if(oi.getIntakeValue() <= -0.1)
			{
				mIntakePiston.set(Value.kReverse);
				mIntakeState = IntakeState.DISABLED;
			}
		}
		else if(mIntakeState == IntakeState.CLOSING)
		{
			if(oi.getIntakeValue() <= -0.1)
			{
				mEjecting = true;
				mLeftArmMotor.set(oi.getIntakeValue());
				mRightArmMotor.set(oi.getIntakeValue());
			}
			else if(oi.getIntakeValue() >= 0.5)
			{
				mDropping = true;
				mIntakePiston.set(Value.kForward);
			}
			else
			{
				mLeftArmMotor.set(0.0);
				mRightArmMotor.set(0.0);
				
				if(mDropping)
				{
					mIntakePiston.set(Value.kReverse);
					mDropping = false;
					mIntakeState = IntakeState.DISABLED;
				}
				else
				{
					mIntakePiston.set(Value.kOff);
				}
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
	
	
	public void zeroWrist()
	{
		
		
		
		set = true;
	}

}
