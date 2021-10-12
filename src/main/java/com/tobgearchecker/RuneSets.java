package com.tobgearchecker;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum RuneSets {
    NONE("None",new Runes[]{},Spellbook.NONE),
    FREEZESWATER("No-Kodai Freezes",new Runes[]{Runes.WATER,Runes.SOUL,Runes.BLOOD,Runes.DEATH},Spellbook.ANCIENT),
    FREEZES("Freezes",new Runes[]{Runes.SOUL,Runes.BLOOD,Runes.DEATH},Spellbook.ANCIENT),
    POTSHARE("Pot Share/Venge",new Runes[]{Runes.MUD,Runes.DEATH,Runes.ASTRAL},Spellbook.LUNAR),
    THRALLS("Thralls",new Runes[]{Runes.FIRE,Runes.BLOOD,Runes.COSMIC},Spellbook.ARCEUUS);


    private final String name;
    @Getter(AccessLevel.PUBLIC)
    private final Runes[] runes;
    @Getter(AccessLevel.PUBLIC)
    private final Spellbook spellbook;

    public String toString() {
        return name;
    }
}
