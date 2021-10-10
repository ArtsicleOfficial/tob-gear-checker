package com.gearchecker;

public enum DartType {
    DRAGON("Dragon"),
    AMETHYST("Amethyst"),
    ADAMANT("Adamant"),
    MITHRIL("Mithril");

    private final String name;

    public String toString() {
        return name;
    }
    DartType(String name) {
        this.name = name;
    }
}
