package com.tobgearchecker;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum Spellbook {
    NONE("None",-1),
    STANDARD("Standard",0),
    ANCIENT("Ancient",1),
    LUNAR("Lunar",2),
    ARCEUUS("Arceuus",3);

    private final String name;
    @Getter(AccessLevel.PUBLIC)
    private final int id;

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

}
