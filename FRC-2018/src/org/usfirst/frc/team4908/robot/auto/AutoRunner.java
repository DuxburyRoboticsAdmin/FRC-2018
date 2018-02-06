package org.usfirst.frc.team4908.robot.auto;

import org.usfirst.frc.team4908.robot.IO.OperatorInterface;
import org.usfirst.frc.team4908.robot.auto.routines.TestRoutine;

/**
 * @author Siggy
 *         $
 */
public class AutoRunner
{
	public static AutoRunner mInstance = new AutoRunner();
	public static AutoRunner getInstance() { return mInstance; }
	
	// TODO: FIGURE OUT IF THIS CLASS IS EVEN NECESSARY
	
	
	OperatorInterface oi = OperatorInterface.getInstance();
	AutoRoutine mRoutine;
	
	
	// TODO: FIll this stuff (painful)
	// TODO: Maybe outsource this method to a AutoSelector Class?? (if it gets too complicated here)
	public void setRoutine()
	{
		switch (oi.getAutoInputs()[0]) 
		{
			case 0: // LEFT POSITION
			{				

			}
			case 1: // MIDDLE POSITION
			{
				
			}
			case 2: // RIGHT POSITION
			{
				
			}
			default:
			{
				mRoutine = new TestRoutine();	
				break;
			}
			
		}
	}
	
	
	public void loop()
	{		
		mRoutine.loop();
	}
	
	
	public void initRoutine()
	{
		mRoutine.routine();
	}
	
	
	
	
}

