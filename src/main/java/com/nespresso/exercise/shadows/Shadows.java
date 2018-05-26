package com.nespresso.exercise.shadows;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class Shadows
{
	private final Building[] buildings;
	
	Shadows(final float... segmentsCoordinates)
	{
		buildings = IntStream.iterate(0, previousIndex -> previousIndex + 2)
				.limit(segmentsCoordinates.length / 2)
				.mapToObj(index -> new Building(segmentsCoordinates[index + 1], segmentsCoordinates[index]))
				.toArray(Building[]::new);
	}
	
	String project(final int sunHeightInDegrees)
	{
		return Arrays.stream(buildings)
				.map(building -> building.project(sunHeightInDegrees))
				.map(ShadowCast::cast)
				.collect(Collectors.joining());
	}
}
