package com.nespresso.exercise.shadows;

import java.util.Locale;

final class ShadowCast extends Segment
{

	ShadowCast(float position, double height)
	{
		super(position, height);
	}
	
	private double extent()
	{
		return position + height;
	}

	String cast()
	{
		return String.format(Locale.US, "[%.0f,%.2f]", position, extent());
	}
	
	boolean isSupersededBy(final ShadowCast other)
	{
		return other.extent() >= position;
	}
	
	ShadowCast mergeWithSuperseding(final ShadowCast superseding)
	{
		return new ShadowCast(superseding.position, superseding.extent() > extent() ? superseding.height : extent() - superseding.position);
	}

}
