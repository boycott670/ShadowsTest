package com.nespresso.exercise.shadows;

import java.util.function.IntToDoubleFunction;

final class Building extends Segment
{

	Building(float position, float height)
	{
		super(position, height);
	}

	ShadowCast project(final int sunHeightInDegrees)
	{
		final IntToDoubleFunction degreesToRadians = degrees -> degrees * Math.PI/180;
		
		return new ShadowCast(position, height * Math.tan(degreesToRadians.applyAsDouble(90 - sunHeightInDegrees)));
	}

}
