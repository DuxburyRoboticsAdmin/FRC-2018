package org.usfirst.frc.team4908.robot;

import java.util.ArrayList;

import org.usfirst.frc.team4908.robot.auto.AutoRunner;
import org.usfirst.frc.team4908.robot.subsystems.Climb;
import org.usfirst.frc.team4908.robot.subsystems.Drive;
import org.usfirst.frc.team4908.robot.subsystems.Intake;
import org.usfirst.frc.team4908.robot.subsystems.Subsystem;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot
{
	
	private Compressor c;
	
	private ArrayList<Subsystem> mSubsystems;
	
	
	AnalogInput us;
	
	public Robot()
	{
		mSubsystems = new ArrayList<>();
		c = new Compressor();
		
		us = new AnalogInput(0);
	}
	
	public void robotInit()
	{
		mSubsystems.add(Drive.getInstance());
		mSubsystems.add(Climb.getInstance());
		mSubsystems.add(Intake.getInstance());
	}
	
	public void autonomousInit()
	{
		AutoRunner.getInstance().setRoutine();
	}
	  
	public void autonomousPeriodic()
	{
		AutoRunner.getInstance().loop();
	}
	
	public void teleopInit()
	{
		c.start();
		
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
		
		System.out.println(us.getAverageValue() / 4.0 * 5.0 / 10.0);
		
	}
	
	public void disabledInit()
	{
		c.stop();
	}
	
	public void disabledPeriodic()
	{
		//TODO: ADD REDUNDANCIES TO ONLY CHANGE IT WHEN IT IS CHANGED
		
		AutoRunner.getInstance().setRoutine();
	}
	
	
}