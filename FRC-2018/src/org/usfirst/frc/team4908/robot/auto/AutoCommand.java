package org.usfirst.frc.team4908.robot.auto;

/**
 * @author Siggy
 *         $
 */
public abstract class AutoCommand
{
	public double timeOutTime;
	public double startTime;
	public double currentTime;

	public enum commandType
	{
		INITIAL,
		SEQUENTIAL,
		PARALLEL
	}
	
	public final commandType mType;
	
	// constructor for INITAL command
	public AutoCommand(commandType type, double timeOutTime)
	{
		this.mType = type;
		
		this.timeOutTime = timeOutTime * 1000000000.0;
		startTime = System.nanoTime();
	}
	
	public abstract void init();
	
	public abstract void loop();
	
	public abstract boolean finished();
	
	public abstract void end();
	
	public boolean timeOut()
	{
		if(currentTime - startTime >= timeOutTime)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
