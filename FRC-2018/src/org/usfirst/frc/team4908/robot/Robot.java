package org.usfirst.frc.team4908.robot;

import java.util.ArrayList;

import org.usfirst.frc.team4908.robot.subsystems.Drive;
import org.usfirst.frc.team4908.robot.subsystems.Subsystem;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot
{
	
	private ArrayList<Subsystem> mSubsystems;
	
	public Robot()
	{
		mSubsystems = new ArrayList<>();
	}
	
	
	public void robotInit()
	{
		mSubsystems.add(Drive.getInstance());
	}
	
	public void autonomousInit()
	{
		
	}
	
	public void autonomousPeriodic()
	{
		
	}
	
	public void teleopInit()
	{
		for(Subsystem s : mSubsystems)
		{
			s.init();
		}
	}
	
	public void teleopPeriodic()
	{
		for(Subsystem s : mSubsystems)
		{
			s.loop();
		}
	}
	
	public void disabledInit()
	{
		
	}
	
	public void disabledPeriodic()
	{
		
	}
	
	
}