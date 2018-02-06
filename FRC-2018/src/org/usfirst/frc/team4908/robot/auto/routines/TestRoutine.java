package org.usfirst.frc.team4908.robot.auto.routines;

import org.usfirst.frc.team4908.robot.auto.AutoCommand.commandType;
import org.usfirst.frc.team4908.robot.auto.AutoRoutine;
import org.usfirst.frc.team4908.robot.auto.commands.DoNothing;
import org.usfirst.frc.team4908.robot.auto.commands.DriveForTime;
import org.usfirst.frc.team4908.robot.auto.commands.FollowPath;
import org.usfirst.frc.team4908.robot.motion.trajectories.paths.TestPath1;

public class TestRoutine extends AutoRoutine
{

	@Override
	public void routine() 
	{
		System.out.println("HERE in the routine declaration");
		addCommand(new FollowPath(commandType.INITIAL, 10, new TestPath1().getTrajectory()));
		addCommand(new DoNothing(commandType.SEQUENTIAL, 100));
	}
}
