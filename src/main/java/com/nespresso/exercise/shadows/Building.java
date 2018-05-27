package com.nespresso.exercise.shadows;

import java.util.function.IntToDoubleFunction;

final class Building extends Segment
{
	
	private static final IntToDoubleFunction DEGREES_TO_RADIANS = degrees -> degrees * Math.PI/180;

	Building(float position, float height)
	{
		super(position, height);
	}

	ShadowCast project(final int sunHeightInDegrees)
	{
		return new ShadowCast(position, height * Math.tan(DEGREES_TO_RADIANS.applyAsDouble(90 - sunHeightInDegrees)));
	}

}
