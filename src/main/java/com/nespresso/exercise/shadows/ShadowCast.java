package com.nespresso.exercise.shadows;

import java.util.Locale;

final class ShadowCast extends Segment
{

	ShadowCast(float position, double height)
	{
		super(position, height);
	}

	String cast()
	{
		return String.format(Locale.US, "[%.0f,%.2f]", position, height);
	}

}
