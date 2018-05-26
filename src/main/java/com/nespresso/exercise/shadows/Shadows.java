package com.nespresso.exercise.shadows;

final class Shadows
{
	private final Building building;
	
	Shadows(final float buildingHeight, final float buildingPosition)
	{
		building = new Building(buildingPosition, buildingHeight);
	}
	
	String project(final int sunHeightInDegrees)
	{
		return building.project(sunHeightInDegrees).cast();
	}
}
