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
		
		mRPs.add(new ReferencePoint(0.0, 0.0));
		mRPs.add(new ReferencePoint(0.0, 2.0));
		mRPs.add(new ReferencePoint(0.0, 4.0));
		mRPs.add(new ReferencePoint(0.0, 6.0));
		
		mTrajectory =  new Trajectory(0.85, mRPs);
	}	
	
	
	public Trajectory getTrajectory()
	{
		return mTrajectory;
	}
}
