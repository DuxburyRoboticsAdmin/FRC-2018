package org.usfirst.frc.team4908.robot.motion.trajectories.paths;

import java.util.ArrayList;

import org.usfirst.frc.team4908.robot.motion.trajectories.ReferencePoint;
import org.usfirst.frc.team4908.robot.motion.trajectories.Trajectory;

public class TestPath1 
{
	ArrayList<ReferencePoint> mRPs;
	
	Trajectory mTrajectory;
	
	public TestPath1()
	{
		mRPs = new ArrayList();
		
		/**
		mRPs.add(new ReferencePoint(0.0, 0.0));
		mRPs.add(new ReferencePoint(0.0, 3.0));
		mRPs.add(new ReferencePoint(3.0, 6.0));
		mRPs.add(new ReferencePoint(6.0, 6.0));
		*/
		mRPs.add(new ReferencePoint(0.0, 0.0));
		mRPs.add(new ReferencePoint(0.0, 1.0));
		mRPs.add(new ReferencePoint(0.0, 3.0));
		mRPs.add(new ReferencePoint(0.0, 4.0));
		
				
		
		
		mTrajectory =  new Trajectory(1.5, mRPs);
	}	
	
	
	public Trajectory getTrajectory()
	{
		return mTrajectory;
	}
}
