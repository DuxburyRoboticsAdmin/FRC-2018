package org.usfirst.frc.team4908.robot.motion;

public class DriveCommand 
{
	private double mLeft, mRight;
	
	public DriveCommand(double left, double right)
	{
		this.mLeft = left;
		this.mRight = right;
	}
	
	public double getLeft()
	{
		return mLeft;
	}
	
	public double getRight()
	{
		return mRight;
	}
}

