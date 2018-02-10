package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.IO.OperatorInterface;
import org.usfirst.frc.team4908.robot.motion.DriveCommand;
import org.usfirst.frc.team4908.robot.motion.DriveHelper;
import org.usfirst.frc.team4908.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Subsystem
{
	public static final Drive mInstance = new Drive();
	public static Drive getInstance()
	{
		return mInstance;
	}
	
	private TalonSRX leftMaster;
	private TalonSRX leftSlave;
	private TalonSRX rightMaster;
	private TalonSRX rightSlave;
	
	private DoubleSolenoid mShifter;
	
	
	private OperatorInterface oi = OperatorInterface.getInstance();
	
	private boolean mShifterWasPressed = false;
	private boolean isHighGear = true;
	
	private enum DriveState
	{
		NEUTRAL,
		OPEN_LOOP,
		PATH_FOLLOWER,
		ROTATE_TO_ANGLE,
		DRIVE_TO_DISTANCE
	}
	private static DriveState mDriveState;
	
	
	private Drive()
	{
		leftMaster = new TalonSRX(Constants.kLeftMasterID);
		leftSlave = new TalonSRX(Constants.kLeftSlaveID);
		rightMaster = new TalonSRX(Constants.kRightMasterID);
		rightSlave = new TalonSRX(Constants.kRightSlaveID);	
	
		mShifter = new DoubleSolenoid(0,1);
		
		leftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		rightMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
		leftMaster.configNominalOutputForward(0, 0);
		leftMaster.configNominalOutputReverse(0, 0);
		leftMaster.configPeakOutputForward(1, 0);
		leftMaster.configPeakOutputReverse(-1, 0);
		
		rightMaster.configNominalOutputForward(0, 0);
		rightMaster.configNominalOutputReverse(0, 0);
		rightMaster.configPeakOutputForward(1, 0);
		rightMaster.configPeakOutputReverse(-1, 0);
		
		leftSlave.configNominalOutputForward(0, 0);
		leftSlave.configNominalOutputReverse(0, 0);
		leftSlave.configPeakOutputForward(1, 0);
		leftSlave.configPeakOutputReverse(-1, 0);
		
		rightSlave.configNominalOutputForward(0, 0);
		rightSlave.configNominalOutputReverse(0, 0);
		rightSlave.configPeakOutputForward(1, 0);
		rightSlave.configPeakOutputReverse(-1, 0);
		
		leftSlave.follow(leftMaster);
		rightSlave.follow(rightMaster);
		
		leftMaster.setInverted(false);
		leftSlave.setInverted(false);
		
		rightMaster.setInverted(true);
		rightSlave.setInverted(true);
		
		
		// FLIP these such that the sensor reads positive when the talons are GREEN
		leftMaster.setSensorPhase(true);
		rightMaster.setSensorPhase(true);
		
		leftMaster.configClosedloopRamp(0.3, 0);
		rightMaster.configClosedloopRamp(0.3, 0);
	}
	

	@Override
	public void init() 
	{
		mDriveState = DriveState.NEUTRAL;
		resetEncoders();
	}

	@Override
	public void loop() 
	{
		
		
		if(OperatorInterface.getInstance().joysticksMoving())
		{
			mDriveState = DriveState.OPEN_LOOP;
		}
		else
		{
			mDriveState = DriveState.NEUTRAL;
		}
		
		switch(mDriveState)
		{
			case NEUTRAL:
			{		
				setMotors(new DriveCommand(0,0));
				break;
			}
			case OPEN_LOOP:
			{
				setMotors(DriveHelper.joystickDrive());
				break;
			}
		}
		
		
		

		if(oi.getSolTwo() && !mShifterWasPressed)
		{
			if(isHighGear)
			{
				mShifter.set(DoubleSolenoid.Value.kReverse);
				isHighGear = false;
			}
			else
			{
				mShifter.set(DoubleSolenoid.Value.kForward);
				isHighGear = true;
			}
			
			mShifterWasPressed = true;
		}
		else if(!oi.getSolTwo() && mShifterWasPressed)
		{
			mShifter.set(DoubleSolenoid.Value.kOff);
			mShifterWasPressed = false;
		}
		
		
		
	}
	
	
	public void setMotors(DriveCommand dc)
	{
		//TODO: add talon setting stuff
		
		
		SmartDashboard.putNumber("Left Encoder Vel", leftMaster.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Right Encoder Vel", rightMaster.getSelectedSensorVelocity(0));
		
		SmartDashboard.putNumber("Left Encoder Pos", leftMaster.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Right Encoder Pos", rightMaster.getSelectedSensorPosition(0));
		
		SmartDashboard.putNumber("Left Drive Command", dc.getLeft());
		SmartDashboard.putNumber("Right Drive Command", dc.getRight());
		
		
		
		leftMaster.set(ControlMode.PercentOutput, dc.getLeft());
		rightMaster.set(ControlMode.PercentOutput, dc.getRight());
	}

	@Override
	public void end() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interrupt() 
	{
		mDriveState = DriveState.NEUTRAL;
		
	}
	
	public void resetEncoders()
	{
		leftMaster.setSelectedSensorPosition(0, 0, 0);
		rightMaster.setSelectedSensorPosition(0, 0, 0);
	}
	
	
	
	// AUTON METHODS
	
	public void driveForTime(double speed, double angle)
	{
		// TODO: ADD ANGLE CORRECTION
		// TODO: DECIDE ON STATIC P GAIN (good enough lmao) OR PID LOOP (hard)
		
		setMotors(new DriveCommand(speed, speed));
	}	
	
	
	double leftTEMP;
	double rightTEMP;
	public void followPath(DriveCommand dc)
	{
		leftTEMP = leftMaster.getSelectedSensorVelocity(0);
		rightTEMP = rightMaster.getSelectedSensorVelocity(0);
		

		SmartDashboard.putNumber("Left Encoder Vel", leftMaster.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Right Encoder Vel", rightMaster.getSelectedSensorVelocity(0));
		
		SmartDashboard.putNumber("Left Encoder Pos", leftMaster.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Right Encoder Pos", rightMaster.getSelectedSensorPosition(0));
		
		SmartDashboard.putNumber("Left Drive Command", dc.getLeft());
		SmartDashboard.putNumber("Right Drive Command", dc.getRight());
		
		
		leftMaster.set(ControlMode.Velocity, dc.getLeft());
		rightMaster.set(ControlMode.Velocity, dc.getRight());
	
		//rightMaster.set(ControlMode.PercentOutput, 1.0);
	}	
	
	
}
