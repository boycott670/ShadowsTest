package com.nespresso.exercise.shadows;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class Shadows
{
	private final ShadowCastsMerger shadowCastsMerger;
	
	private final Building[] buildings;
	
	Shadows(final float... segmentsCoordinates)
	{
		shadowCastsMerger = new DefaultShadowCastsMerger();
		
		buildings = IntStream.iterate(0, previousIndex -> previousIndex + 2)
				.limit(segmentsCoordinates.length / 2)
				.mapToObj(index -> new Building(segmentsCoordinates[index + 1], segmentsCoordinates[index]))
				.toArray(Building[]::new);
	}
	
	String project(final int sunHeightInDegrees)
	{
		shadowCastsMerger.setShadowCasts(
				Arrays.stream(buildings)
					.map(building -> building.project(sunHeightInDegrees))
					.toArray(ShadowCast[]::new)
		);
		
		return Arrays.stream(shadowCastsMerger.merge())
				.map(ShadowCast::cast)
				.collect(Collectors.joining());
	}
}
