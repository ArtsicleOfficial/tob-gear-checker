package com.tobgearchecker;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ToBGearCheckerTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(ToBGearCheckerPlugin.class);
		RuneLite.main(args);
	}
}