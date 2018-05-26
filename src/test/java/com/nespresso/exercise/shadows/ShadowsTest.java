package com.nespresso.exercise.shadows;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShadowsTest
{
	@Test
	public void aBuildingProjectsShadowDependingOnSunHeight()
	{
		final Shadows shadows = new Shadows(4f, 0f);
		assertEquals("[0,6.93]", shadows.project(30));
		assertEquals("[0,4.00]", shadows.project(45));
		assertEquals("[0,2.31]", shadows.project(60));
		assertEquals("[0,0.00]", shadows.project(90));
	}
}
