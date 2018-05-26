package com.nespresso.exercise.shadows;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;

final class DefaultShadowCastsMerger implements ShadowCastsMerger
{
	
	private Deque<ShadowCast> shadowCasts;

	@Override
	public void setShadowCasts(ShadowCast[] shadowCasts)
	{
		this.shadowCasts = new ArrayDeque<>(Arrays.asList(shadowCasts));
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
				shadowCasts.addLast(afterFirstShadowCast);
				
				mergedShadowCasts.add(firstShadowCast);
			}
			else
			{
				shadowCasts.addLast(afterFirstShadowCast.mergeWithSuperseding(firstShadowCast));
			}
		}
		
		return mergedShadowCasts.toArray(new ShadowCast[mergedShadowCasts.size()]);
	}

}
