package org.usfirst.frc.team4908.robot.subsystems;

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

        mLiftMaster.configClosedLoopRampRate(0.2, 0);
        mLiftSlave.configClosedLoopRampRate(0.2, 0);

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
}
