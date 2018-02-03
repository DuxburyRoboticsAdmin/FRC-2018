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
		mRPs.add(new ReferencePoint(0.0, 0.0));
		mRPs.add(new ReferencePoint(0.0, 2.0));
		mRPs.add(new ReferencePoint(7.0, 9.0));
		mRPs.add(new ReferencePoint(6.0, 3.0));
		
		mTrajectory =  new Trajectory(5.0, mRPs);
	}	
	
	
	public Trajectory getTrajectory()
	{
		return mTrajectory;
	}
}
