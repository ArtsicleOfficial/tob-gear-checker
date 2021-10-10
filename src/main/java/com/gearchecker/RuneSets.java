package com.gearchecker;

public enum RuneSets {
    NONE("None",new Runes[]{},Spellbook.NONE),
    FREEZESWATER("No-Kodai Freezes",new Runes[]{Runes.WATER,Runes.SOUL,Runes.BLOOD,Runes.DEATH},Spellbook.ANCIENT),
    FREEZES("Freezes",new Runes[]{Runes.SOUL,Runes.BLOOD,Runes.DEATH},Spellbook.ANCIENT),
    POTSHARE("Pot Share/Venge",new Runes[]{Runes.MUD,Runes.DEATH,Runes.ASTRAL},Spellbook.LUNAR),
    THRALLS("Thralls",new Runes[]{Runes.FIRE,Runes.BLOOD,Runes.COSMIC},Spellbook.ARCEUUS);


    private final String name;
    private final Runes[] runes;
    private final Spellbook spellbook;

    public Spellbook getSpellbook() {
        return spellbook;
    }

    public Runes[] getRunes() { return runes; }

    public String toString() {
        return name;
    }
    RuneSets(String name,Runes[] runes,Spellbook spellbook) {
        this.name = name; this.runes = runes; this.spellbook = spellbook;
    }
}
