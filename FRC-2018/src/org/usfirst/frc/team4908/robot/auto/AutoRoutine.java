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
			{
				mFinalCommand = true;
			}
			
			mCommands.get(mIndex).init();
			
			if(!mFinalCommand)
			{
				mNextCommandParallel = mCommands.get(mIndex + 1).mType.equals(AutoCommand.commandType.PARALLEL);
			}
			else
			{
				mNextCommandParallel = false;
			}
				
			if(mNextCommandParallel)
			{
				System.out.println("Initializing PARALLEL command " + (mIndex + 1));
				mCommands.get(mIndex + 1).init();
			}
			
			mRunning = true;
		}
		else if(mRunning && !mDone)
		{
			System.out.println("Looping SEQUENTIAL command " + (mIndex));
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
					System.out.println("Checking TIMEOUT PARALLEL Command " + (mIndex + 1));
					mCommands.get(mIndex + 1).end();
				}
				else
				{
					System.out.println("Looping PARALLEL command " + (mIndex + 1));
					mCommands.get(mIndex + 1).loop();

				}
				
				if(mCommands.get(mIndex).finished() || mCommands.get(mIndex).timeOut())
				{
					mCommands.get(mIndex).end();

					if(mIndex == mCommands.size() - 1)
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
			System.out.println("DONE WITH EVERYTHING");
		}
		
	}
	
	// Adds each command to the array list of THIS class
	public void addCommand(AutoCommand comm)
	{
		mCommands.add(comm);
	}
	
	
	
}
