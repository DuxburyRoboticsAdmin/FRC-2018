package org.usfirst.frc.team4908.robot.motion.trajectories.paths;

import java.util.ArrayList;

import org.usfirst.frc.team4908.robot.motion.trajectories.ReferencePoint;
import org.usfirst.frc.team4908.robot.motion.trajectories.Trajectory;

public class StartToScaleSameSide 
{
	ArrayList<ReferencePoint> mRPs;
	
	Trajectory mTrajectory;
	
	public StartToScaleSameSide()
	{
		mRPs = new ArrayList();
		
		mRPs.add(new ReferencePoint(0.0, 0.0));
		mRPs.add(new ReferencePoint(0.0, 5.22));
		mRPs.add(new ReferencePoint(2.27, 13.98));
		mRPs.add(new ReferencePoint(-2.75, 18.14));
		mRPs.add(new ReferencePoint(-2.75, 23.38));
		
		mTrajectory =  new Trajectory(5.0, mRPs);
	}	
	
	
	public Trajectory getTrajectory()
	{ 
		return mTrajectory;
	}

}
