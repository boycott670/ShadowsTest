package com.nespresso.exercise.shadows;

abstract class Segment
{
	final float position;
	final double height;
	
	Segment(float position, double height)
	{
		this.position = position;
		this.height = height;
	}
	
	final double extent()
	{
		return position + height;
	}
}
