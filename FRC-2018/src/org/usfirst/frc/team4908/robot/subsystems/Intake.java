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

public class Intake extends Subsystem
{
	public static final Intake mInstance = new Intake();
	public static Intake getInstance() { return mInstance; }
	OperatorInterface oi = OperatorInterface.getInstance();

	private DoubleSolenoid mLeftArmPiston;

	private TalonSRX mWristMotor;
	private VictorSP mLeftArmMotor;
	private VictorSP mRightArmMotor;

	private AnalogInput mLeftPot;
	private AnalogInput mRightPot;

	private boolean set = false;
	
	private boolean mLeftDeployed = false;
	private boolean mRightDeployed = false;
	
	public enum IntakeState
	{
		GETTING,
		CLOSING,
		HOLDING,
		ZEROING,
		DISABLED
	}
	public IntakeState mIntakeState;
	
	public Intake()
	{
		mLeftArmPiston = new DoubleSolenoid(Constants.kLeftIntakePistonF, Constants.kLeftIntakePistonR);
		
		//mLeftPot = new AnalogInput(Constants.kLeftIntakePotID);
		//mRightPot = new AnalogInput(Constants.kRightIntakePotID);
		
		mWristMotor 	= new TalonSRX(Constants.kWristMotorID);
		mLeftArmMotor 	= new VictorSP(Constants.kLeftIntakeMotorID);
		mRightArmMotor 	= new VictorSP(Constants.kRightIntakeMotorID);

		mWristMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		mWristMotor.configNominalOutputForward(0, 0);
		mWristMotor.configNominalOutputReverse(0, 0);
		mWristMotor.configPeakOutputForward(1, 0);
		mWristMotor.configPeakOutputReverse(-1, 0);
		mWristMotor.setInverted(true);
		mWristMotor.setSensorPhase(false);
	}
	

	@Override
	public void init() 
	{
		 if(!set)
		 {
			 mIntakeState = IntakeState.ZEROING;
		 }
		 else
		 {
			 mIntakeState = IntakeState.DISABLED;
		 }
	}

	@Override
	public void loop() 
	{		
		if(oi.getManualOpenIntake())
		{
			System.out.println("openin");
			mLeftArmPiston.set(Value.kForward);
		}
		else if(oi.getManualCloseIntake())
		{
			System.out.println("closing");
			mLeftArmPiston.set(Value.kReverse);
		}
		else
		{
			
			mLeftArmPiston.set(Value.kOff);
		}
		
		if(oi.getIntakeButton())
		{
			mWristMotor.set(ControlMode.PercentOutput, 0.5);
		}
		else if(oi.getIntakeCancelButton())
		{
			mWristMotor.set(ControlMode.PercentOutput, -0.5);
		}
		else
		{
			mWristMotor.set(ControlMode.PercentOutput, 0.0);
		}
		
		
		mLeftArmMotor.set(-oi.getManualRollers());
		mRightArmMotor.set(oi.getManualRollers());
		
		//mWristMotor.set(ControlMode.PercentOutput, oi.getManualWrist());
		
	}

	@Override
	public void end() 
	{
		
	}

	@Override
	public void interrupt() 
	{
		
	}
	
	
	public boolean zeroWrist()
	{
		if(!set)
		{
			mWristMotor.set(ControlMode.PercentOutput, -0.1);
		}
		else
		{
			set = true;
		}
		
		
		return false;
	}



}
