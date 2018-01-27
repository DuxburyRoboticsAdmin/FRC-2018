package org.usfirst.frc.team4908.robot.auto;

import org.usfirst.frc.team4908.robot.IO.OperatorInterface;

/**
 * @author Siggy
 *         $
 */
public class AutoSelector
{
    OperatorInterface oi = OperatorInterface.getInstance();

    public AutoRoutine getDesiredRoutine()
    {
        int pos = oi.getAutoInputs()[0];
        int switch_priority = oi.getAutoInputs()[1];
        int scale_priority = oi.getAutoInputs()[2];

        AutoRoutine routine;



        return new AutoRoutine();
    }

}
