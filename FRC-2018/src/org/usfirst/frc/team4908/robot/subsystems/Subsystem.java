package org.usfirst.frc.team4908.robot.subsystems;

public abstract class Subsystem 
{
	public abstract void init();
	
	public abstract void loop();
	
	public abstract void end();
	
	public abstract void interrupt();
}