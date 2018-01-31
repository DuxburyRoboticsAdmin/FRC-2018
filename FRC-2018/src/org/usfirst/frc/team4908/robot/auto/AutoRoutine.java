package org.usfirst.frc.team4908.robot.auto;

import java.util.ArrayList;

/**
 * @author Siggy
 *         $
 */
public abstract class AutoRoutine
{
	private ArrayList<AutoCommand> mCommands = new ArrayList();
	private int mIndex = 0;
	private boolean mRunning = false;
	private boolean mNextCommandParallel = false;
	private boolean mFinalCommand = false;
	private boolean mDone = false;
	
	public abstract void routine();

	public void loop()
	{
		if(!mRunning && !mDone)
		{
			if(mIndex == mCommands.size() - 1)
				mFinalCommand = true;
			
			if(!mFinalCommand)
				mNextCommandParallel = mCommands.get(mIndex + 1).equals(AutoCommand.commandType.PARALLEL);
			
			mCommands.get(mIndex).init();
			
			if(mNextCommandParallel)
			{
				mCommands.get(mIndex + 1).init();
			}
			
			mRunning = true;
		}
		else if(mRunning && !mDone)
		{
			mCommands.get(mIndex).loop();
		
			if(!mNextCommandParallel && mCommands.get(mIndex).finished() || mCommands.get(mIndex).timeOut())
			{
				mCommands.get(mIndex).end();
				mRunning = false;
				mIndex++;
				
				if(mIndex == mCommands.size() - 1)
				{
					mDone = true;
				}
			}
			
			if(mNextCommandParallel)
			{
				if(mCommands.get(mIndex + 1).finished() || mCommands.get(mIndex + 1).timeOut())
				{
					mCommands.get(mIndex + 1).end();
				}
				else
				{
					mCommands.get(mIndex + 1).loop();
				}
				
				if(mCommands.get(mIndex).finished() || mCommands.get(mIndex).timeOut())
				{
					mCommands.get(mIndex).end();

					if(mIndex + 1 == mCommands.size() - 1)
					{
						mDone = true;
					}
					else
					{
						mIndex++;
					}
					
					mRunning = false;
				}
			}
		}
		else if(mDone)
		{
			// TODO: FIND WHAT TO DO HERE
		}
		
	}
	
	public void runCommand()
	{
		
	}
	
	public void runSequential()
	{
		
	}
	
	// Adds each command to the array list of THIS class
	public void addCommand(AutoCommand comm)
	{
		mCommands.add(comm);
	}
	
	
	
}
