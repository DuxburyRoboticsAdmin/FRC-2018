package org.usfirst.frc.team4908.robot;

import java.util.ArrayList;

import org.usfirst.frc.team4908.robot.auto.AutoRunner;
import org.usfirst.frc.team4908.robot.subsystems.Climb;
import org.usfirst.frc.team4908.robot.subsystems.Drive;
import org.usfirst.frc.team4908.robot.subsystems.Intake;
import org.usfirst.frc.team4908.robot.subsystems.Lift;
import org.usfirst.frc.team4908.robot.subsystems.Subsystem;
import org.usfirst.frc.team4908.robot.util.ADIS16448_IMU;
import org.usfirst.frc.team4908.robot.util.SharpIR;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot
{	
	private ArrayList<Subsystem> mSubsystems;
				
	//CameraServer cs;
	//UsbCamera cam;
	public ADIS16448_IMU gyro = new ADIS16448_IMU();
	
	
	SharpIR lmfao = new SharpIR(0);

	public Robot()
	{
		mSubsystems = new ArrayList<>();
        //CameraServer.getInstance().startAutomaticCapture();
	}
	
	public void robotInit()
	{
		/*
		mSubsystems.add(Drive.getInstance());
    	mSubsystems.add(Lift.getInstance());
    	mSubsystems.add(Climb.getInstance());
    	mSubsystems.add(Intake.getInstance());
		*/
	}
	
	public void autonomousInit()
	{
		AutoRunner.getInstance().setRoutine();
		AutoRunner.getInstance().initRoutine();
	}
	  
	public void autonomousPeriodic()
	{
		AutoRunner.getInstance().loop();
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

		SmartDashboard.putNumber("AngleX", gyro.getAngleX());
		SmartDashboard.putNumber("AngleY", gyro.getAngleY());
		SmartDashboard.putNumber("AngleZ", gyro.getAngleZ());
		
		SmartDashboard.putNumber("Val", lmfao.getVoltage());
		SmartDashboard.putNumber("dis", lmfao.getDistance());
		double temp = SmartDashboard.getNumber("asdf", lmfao.K_VAL);
		
		if (temp != lmfao.K_VAL)
		{
			lmfao.setK(temp);
		}
		
	}
	
	public void disabledInit()
	{
		AutoRunner.getInstance().setRoutine();
	}
	
	public void disabledPeriodic()
	{
		//TODO: ADD REDUNDANCIES TO ONLY CHANGE IT WHEN IT IS CHANGED
		
		//AutoRunner.getInstance().setRoutine();
	}
	
	
}