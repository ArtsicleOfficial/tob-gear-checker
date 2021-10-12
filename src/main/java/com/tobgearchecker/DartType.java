package com.tobgearchecker;

public enum DartType {
    MITHRIL("Mithril"),
    ADAMANT("Adamant"),
    RUNE("Rune"),
    AMETHYST("Amethyst"),
    DRAGON("Dragon");

    private final String name;

    public String toString() {
        return name;
    }
    DartType(String name) {
        this.name = name;
    }
}
