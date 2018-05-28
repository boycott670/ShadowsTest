package com.nespresso.exercise.shadows;

final class Building extends Segment
{

	Building(float position, float height)
	{
		super(position, height);
	}

	ShadowCast project(final int sunHeightInDegrees)
	{
		return new ShadowCast(position, height / Math.tan(Math.toRadians(sunHeightInDegrees)));
	}

}
