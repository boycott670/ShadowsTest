package com.nespresso.exercise.shadows;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

final class DefaultShadowCastsMerger implements ShadowCastsMerger
{
	
	private Deque<ShadowCast> shadowCasts;

	@Override
	public void setShadowCasts(ShadowCast[] shadowCasts)
	{
		this.shadowCasts = Arrays.stream(shadowCasts)
				.sorted(Comparator.comparingDouble((Segment segment) -> segment.position))
				.collect(Collectors.toCollection(ArrayDeque::new));
	}

	@Override
	public ShadowCast[] merge()
	{
		final Collection<ShadowCast> mergedShadowCasts = new ArrayList<>();
		
		ShadowCast firstShadowCast;
		
		while((firstShadowCast = shadowCasts.pollFirst()) != null)
		{
			final ShadowCast afterFirstShadowCast = shadowCasts.pollFirst();
			
			if (afterFirstShadowCast == null)
			{
				mergedShadowCasts.add(firstShadowCast);
			}
			else if (!afterFirstShadowCast.isSupersededBy(firstShadowCast))
			{
				shadowCasts.addFirst(afterFirstShadowCast);
				
				mergedShadowCasts.add(firstShadowCast);
			}
			else
			{
				shadowCasts.addFirst(afterFirstShadowCast.mergeWithSuperseding(firstShadowCast));
			}
		}
		
		return mergedShadowCasts.toArray(new ShadowCast[0]);
	}

}
