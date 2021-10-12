package com.tobgearchecker;

import static net.runelite.api.ItemID.AIR_RUNE;
import static net.runelite.api.ItemID.ASTRAL_RUNE;
import static net.runelite.api.ItemID.BLOOD_RUNE;
import static net.runelite.api.ItemID.BODY_RUNE;
import static net.runelite.api.ItemID.CHAOS_RUNE;
import static net.runelite.api.ItemID.COSMIC_RUNE;
import static net.runelite.api.ItemID.DEATH_RUNE;
import static net.runelite.api.ItemID.DUST_RUNE;
import static net.runelite.api.ItemID.EARTH_RUNE;
import static net.runelite.api.ItemID.FIRE_RUNE;
import static net.runelite.api.ItemID.LAVA_RUNE;
import static net.runelite.api.ItemID.LAW_RUNE;
import static net.runelite.api.ItemID.MIND_RUNE;
import static net.runelite.api.ItemID.MIST_RUNE;
import static net.runelite.api.ItemID.MUD_RUNE;
import static net.runelite.api.ItemID.NATURE_RUNE;
import static net.runelite.api.ItemID.SMOKE_RUNE;
import static net.runelite.api.ItemID.SOUL_RUNE;
import static net.runelite.api.ItemID.STEAM_RUNE;
import static net.runelite.api.ItemID.WATER_RUNE;
import static net.runelite.api.ItemID.WRATH_RUNE;

public enum Runes {
    NONE(0, 0),
    AIR(1, AIR_RUNE),
    WATER(2, WATER_RUNE),
    EARTH(3, EARTH_RUNE),
    FIRE(4, FIRE_RUNE),
    MIND(5, MIND_RUNE),
    CHAOS(6, CHAOS_RUNE),
    DEATH(7, DEATH_RUNE),
    BLOOD(8, BLOOD_RUNE),
    COSMIC(9, COSMIC_RUNE),
    NATURE(10, NATURE_RUNE),
    LAW(11, LAW_RUNE),
    BODY(12, BODY_RUNE),
    SOUL(13, SOUL_RUNE),
    ASTRAL(14, ASTRAL_RUNE),
    MIST(15, MIST_RUNE),
    MUD(16, MUD_RUNE),
    DUST(17, DUST_RUNE),
    LAVA(18, LAVA_RUNE),
    STEAM(19, STEAM_RUNE),
    SMOKE(20, SMOKE_RUNE),
    WRATH(21, WRATH_RUNE);

    int runePouchID;
    int itemID;

    public int getRunePouchID() {
        return runePouchID;
    }

    Runes(int runePouchID, int itemID) {
        this.runePouchID = runePouchID;
        this.itemID = itemID;
    }
}
