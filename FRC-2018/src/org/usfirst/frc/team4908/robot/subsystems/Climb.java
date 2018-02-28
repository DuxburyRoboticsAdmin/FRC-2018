package org.usfirst.frc.team4908.robot.subsystems;

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team4908.robot.IO.OperatorInterface;
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

	private OperatorInterface oi = OperatorInterface.getInstance();

	private TalonSRX mLeftMaster;
	private TalonSRX mRightMaster;
	private VictorSPX mLeftSlave;
	private VictorSPX mRightSlave;

	private DoubleSolenoid mLockPiston;
	private boolean mClimberReleased = false;

	private DigitalInput mLimitSwitch;

	private Climb()
	{
		mLeftMaster 	= new TalonSRX(Constants.kClimberLeftTalonID);
		mRightMaster 	= new TalonSRX(Constants.kClimberRightTalonID);
		mLeftSlave		= new VictorSPX(Constants.kClimberLeftVictorID);
		mRightSlave		= new VictorSPX(Constants.kClimberRightVictorID);

		mLockPiston = new DoubleSolenoid(Constants.kClimberSolenoidForward, Constants.kClimberSolenoidReverse);

		mLimitSwitch = new DigitalInput(Constants.kClimberSwitchID);
	}

	@Override
	public void init() 
	{
		mLeftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

		mLeftMaster.configNominalOutputForward(0, 0);
		mLeftMaster.configNominalOutputReverse(0, 0);
		mLeftMaster.configPeakOutputForward(1, 0);
		mLeftMaster.configPeakOutputReverse(-1, 0);

		mLeftSlave.configNominalOutputForward(0, 0);
		mLeftSlave.configNominalOutputReverse(0, 0);
		mLeftSlave.configPeakOutputForward(1, 0);
		mLeftSlave.configPeakOutputReverse(-1, 0);

		mRightMaster.configNominalOutputForward(0,0);
		mRightMaster.configNominalOutputReverse(0,0);
		mRightMaster.configPeakOutputForward(1,0);
		mRightMaster.configPeakOutputReverse(-1,0);

		mRightSlave.configNominalOutputForward(0,0);
		mRightSlave.configNominalOutputReverse(0,0);
		mRightSlave.configPeakOutputForward(1,0);
		mRightSlave.configPeakOutputReverse(-1,0);

		mLeftMaster.config_kP(0, Constants.kClimberP,0);
		mLeftMaster.config_kI(0, Constants.kClimberI,0);
		mLeftMaster.config_kD(0, Constants.kClimberD,0);
		mLeftMaster.config_kF(0, Constants.kClimberF,0);

		mLeftSlave.follow(mLeftMaster);
		mRightMaster.follow(mLeftMaster);
		mRightSlave.follow(mLeftMaster);

		mLeftMaster.setInverted(true);
		mLeftSlave.setInverted(true);
		mRightMaster.setInverted(false);
		mRightSlave.setInverted(false);

		mLeftMaster.setSensorPhase(true);
	}

	@Override
	public void loop()
	{
		if(oi.getClimberRelease() && !mClimberReleased)
		{
			mLockPiston.set(DoubleSolenoid.Value.kReverse);
			mClimberReleased = true;
		}

		if(mClimberReleased)
		{
			mLeftMaster.set(ControlMode.Velocity, Constants.kClimberMaxSpeed * oi.getClimberSpeed());
			mRightMaster.set(ControlMode.Velocity, Constants.kClimberMaxSpeed * oi.getClimberSpeed());
		}

		if(mLimitSwitch.get())
		{
			mLockPiston.set(DoubleSolenoid.Value.kForward);
			mClimberReleased = false;
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
