package com.gearchecker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("tobgearchecker")
public interface GearCheckerConfig extends Config
{
	@ConfigSection(
			name = "Spell Checks",
			description = "Checks for the player's spellbook and runes",
			position = 0
	)
	String spellSection = "spell";

	@ConfigSection(
			name = "Blowpipe Checks",
			description = "Checks for the blowpipe's scales and darts",
			position = 1
	)
	String blowpipeSection = "blowpipe";

	@ConfigSection(
			name = "Charges",
			description = "Weapon charge checks",
			position = 2
	)
	String chargeSection = "charges";

	@ConfigItem(
			keyName = "targetRuneSet",
			name = "Target Rune Set",
			description = "The types of runes to aim for",
			section = spellSection
	)
	default RuneSets targetRuneSet() {
		return RuneSets.NONE;
	}

	@ConfigItem(
			keyName = "runeAmounts",
			name = "Amount of Runes (Each)",
			description = "The number of each rune to aim for",
			section=spellSection
	)
	default int runeAmounts() {
		return 2000;
	}

	@ConfigItem(
			keyName = "blowpipe",
			name = "Check Blowpipe Scales/Darts",
			description = "Whether or not to check the blowpipe",
			section=blowpipeSection
	)
	default boolean blowpipe() {
		return false;
	}

	@ConfigItem(
			keyName = "targetScales",
			name = "Target Scales",
			description = "How many scales to aim for",
			section = blowpipeSection
	)
	default int blowpipeScaleAmounts() {
		return 5000;
	}


	@ConfigItem(
			keyName = "targetDarts",
			name = "Target Darts",
			description = "How many darts to aim for",
			section = blowpipeSection
	)
	default int blowpipeDartAmounts() {
		return 5000;
	}

	@ConfigItem(
			keyName = "dartType",
			name = "Dart Type",
			description = "Type of dart to aim for",
			section = blowpipeSection
	)
	default DartType blowpipeDartType() {
		return DartType.DRAGON;
	}

	@ConfigItem(
			keyName = "serp",
			name = "Check Serp",
			description = "Whether or not to check the serpentine helmet",
			section=chargeSection
	)
	default boolean serpentine() {
		return false;
	}

	@ConfigItem(
			keyName = "serpScales",
			name = "Serp Scales",
			description = "The amount of scales to aim for in the serpentine helmet",
			section=chargeSection
	)
	default int serpentineAmount() {
		return 2000;
	}

	@ConfigItem(
			keyName = "trident",
			name = "Check Trident/Sang",
			description = "Whether or not to check the trident or sang staffs",
			section=chargeSection
	)
	default boolean trident() {
		return false;
	}

	@ConfigItem(
			keyName = "tridentCharges",
			name = "Trident/Sang Charges",
			description = "The amount of charges to aim for in the trident or sang staffs",
			section=chargeSection
	)
	default int tridentAmount() {
		return 1000;
	}

	@ConfigItem(
			keyName = "scythe",
			name = "Check Scythe",
			description = "Whether or not to check the scythe",
			section=chargeSection
	)
	default boolean scythe() {
		return false;
	}

	@ConfigItem(
			keyName = "scytheCharges",
			name = "Scythe Charges",
			description = "The amount of charges to aim for in the scythe",
			section=chargeSection
	)
	default int scytheAmount() {
		return 600;
	}
}
