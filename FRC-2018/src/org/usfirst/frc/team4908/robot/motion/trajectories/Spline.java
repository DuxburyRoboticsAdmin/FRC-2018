package org.usfirst.frc.team4908.robot.motion.trajectories;

import java.util.ArrayList;

/**
 * @author Siggy
 *         $
 */
public class Spline
{
    private int degree;

    private ArrayList<ReferencePoint> positionPoints;
    private ArrayList<ReferencePoint> velocityPoints;

    private double sIncrement;
    private double totalTime;

    public Spline(double totalTime, ArrayList<ReferencePoint> referencePoints)
    {
    	this.totalTime = totalTime;
        this.sIncrement = 1.0/(totalTime * 50.0);

        degree = referencePoints.size() - 1;
        positionPoints = referencePoints;
        velocityPoints = new ArrayList<>();

        for(int i = 0; i < positionPoints.size()-1; i++)
        {
            velocityPoints.add(new ReferencePoint(positionPoints.get(i+1).getX()-positionPoints.get(i).getX(),
                                                    positionPoints.get(i+1).getY()-positionPoints.get(i).getY()));
        }
    }

    public double getX(double s)
    {
        double sum = 0.0;

        for(int v = 0; v <= degree; v++)
        {
            sum += Util.bernstein(degree, v, s) * positionPoints.get(v).getX();
        }

        return sum;
    }

    public double getY(double s)
    {
        double sum = 0.0;

        for(int v = 0; v <= degree; v++)
        {
            sum += Util.bernstein(degree, v, s) * positionPoints.get(v).getY();
        }

        return sum;
    }

    public double getDX(double s)
    {
        double sum = 0.0;

        for(int v = 0; v < degree; v++) // non inclusive because vPoints always has 1 less element
        {
            sum += Util.bernstein(degree-1, v, s) * velocityPoints.get(v).getX();
        }

        return degree*sum;
    }

    public double getDY(double s)
    {
        double sum = 0.0;

        for(int v = 0; v < degree; v++) // non inclusive because vPoints always has 1 less element
        {
            sum += Util.bernstein(degree-1, v, s) * velocityPoints.get(v).getY();
        }

        return degree*sum;
    }

    public double getdYdX(double s)
    {
    	return Math.sqrt(Math.pow(getDX(s), 2) + Math.pow(getDY(s), 2)) / totalTime;
    }

    public double getH(double s)
    {
        return Math.atan2(getDY(s), getDX(s));
    }

    public double getDH(double s)
    {
        if(s == 0.0 || s-sIncrement < 0.0)
            return 0.0;
        else
            return Math.toDegrees(getH(s)-getH(s-sIncrement));
    }

    public double getdHdS(double s)
    {
        return getDH(s)/(sIncrement * totalTime);
    }
}
