package org.usfirst.frc.team4908.robot.subsystems;

<<<<<<< HEAD
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import org.usfirst.frc.team4908.robot.util.Constants;

/**
 * @author Siggy
 *         $
 */
public class Lift extends Subsystem
{
    private TalonSRX mLiftMaster;
    private VictorSPX mLiftSlave;


    public Lift()
    {
        mLiftMaster = new TalonSRX(Constants.kLiftTalonID);
        mLiftSlave = new VictorSPX(Constants.kLiftVictorID);

        mLiftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

        mLiftMaster.configNominalOutputForward(0, 0);
        mLiftMaster.configNominalOutputReverse(0, 0);
        mLiftMaster.configPeakOutputForward(1, 0);
        mLiftMaster.configPeakOutputReverse(-1, 0);

        mLiftSlave.configNominalOutputForward(0, 0);
        mLiftSlave.configNominalOutputReverse(0, 0);
        mLiftSlave.configPeakOutputForward(1, 0);
        mLiftSlave.configPeakOutputReverse(-1, 0);

        mLiftSlave.follow(mLiftMaster);

        mLiftMaster.configClosedloopRamp(0.2, 0);
        mLiftSlave.configClosedloopRamp(0.2, 0);

        mLiftMaster.setInverted(true);
        mLiftSlave.setInverted(true);

        mLiftMaster.setSensorPhase(true);
        mLiftSlave.setSensorPhase(true);


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


    public void resetEncoder()
    {

    }
=======
import org.usfirst.frc.team4908.robot.IO.OperatorInterface;
import org.usfirst.frc.team4908.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Lift extends Subsystem
{
	public static Lift mInstance = new Lift();
	public static Lift getInstance()
	{
		return mInstance;
	}

	private TalonSRX mLeft;
	private TalonSRX mRight;
	
	
	public Lift()
	{
		mLeft 	= new TalonSRX(Constants.kLiftLeftMotorID);
		mRight 	= new TalonSRX(Constants.kLiftRightMotorID);
	}
	
	
	@Override
	public void init() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loop() 
	{
		// TODO Auto-generated method stub
		
		mLeft.set(ControlMode.PercentOutput, -OperatorInterface.getInstance().getMaualLift() * 0.5);
		mRight.set(ControlMode.PercentOutput, OperatorInterface.getInstance().getMaualLift() * 0.5);
		
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

>>>>>>> 18b4c03f387c5d30c0ad64cd1de99ae700c319cb
}
