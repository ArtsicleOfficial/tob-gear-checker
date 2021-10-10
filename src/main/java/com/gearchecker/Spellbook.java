package com.gearchecker;

public enum Spellbook {
    NONE("None",-1),
    STANDARD("Standard",0),
    ANCIENT("Ancient",1),
    LUNAR("Lunar",2),
    ARCEUUS("Arceuus",3);

    private final String name;
    private final int id;

    public int getID() { return this.id; }

    public static Spellbook getSpellbookByID(int id) {
        for(int i = 0; i < Spellbook.values().length; i++) {
            if(Spellbook.values()[i].id == id) {
                return Spellbook.values()[i];
            }
        }
        return Spellbook.NONE;
    }

    public String toString() {
        return this.name;
    }

    Spellbook(String name, int id) {
        this.name = name; this.id = id;
    }

}
