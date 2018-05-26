package com.nespresso.exercise.shadows;

interface ShadowCastsMerger
{
	void setShadowCasts(final ShadowCast[] shadowCasts);
	
	ShadowCast[] merge();
}
