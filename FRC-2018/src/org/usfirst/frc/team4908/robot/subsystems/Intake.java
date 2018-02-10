package org.usfirst.frc.team4908.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
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
	
	private TalonSRX left_motor;
	private TalonSRX right_motor;
	private TalonSRX wrist_motor;
	
	private DoubleSolenoid mLeftArmPiston;
	private DoubleSolenoid mRightArmPiston;

	private TalonSRX mWristMotor;
	private TalonSRX mLeftArmMotor;
	private TalonSRX mRightArmMotor;

	private Potentiometer mLeftPot;
	private Potentiometer mRightPot;

	
	public Intake()
	{
		mLeftArmPiston = new DoubleSolenoid(2, 3);
		mRightArmPiston = new DoubleSolenoid(4, 5);

		mWristMotor 	= new TalonSRX(Constants.kWristMotorID);
		mLeftArmMotor 	= new TalonSRX(Constants.kLeftIntakeMotorID);
		mRightArmMotor 	= new TalonSRX(Constants.kRightIntakeMotorID);

		mWristMotor.configNominalOutputForward(0, 0);
		mWristMotor.configNominalOutputReverse(0, 0);
		mWristMotor.configPeakOutputForward(1, 0);
		mWristMotor.configPeakOutputReverse(-1, 0);

		mWristMotor.setInverted(true);
		mWristMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		mWristMotor.setSensorPhase(false);

		mLeftArmMotor.configNominalOutputForward(0, 0);
		mLeftArmMotor.configNominalOutputReverse(0, 0);
		mLeftArmMotor.configPeakOutputForward(1, 0);
		mLeftArmMotor.configPeakOutputReverse(-1, 0);
		mRightArmMotor.configNominalOutputForward(0, 0);
		mRightArmMotor.configNominalOutputReverse(0, 0);
		mRightArmMotor.configPeakOutputForward(1, 0);
		mRightArmMotor.configPeakOutputReverse(-1, 0);
	}
	

	@Override
	public void init() 
	{
		// TODO: init wrist motor for POSITION control, use Mag encoder or potentiometer


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
