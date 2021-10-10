package com.gearchecker.gear;

import com.gearchecker.GearCheckerConfig;
import com.gearchecker.RuneSets;
import com.gearchecker.Runes;
import com.gearchecker.Spellbook;

public class HaveRunes {
    public boolean runePouch = false;
    public int[] runeAmounts = new int[22];
    public Spellbook spellbook = Spellbook.NONE;

    public HaveRunes() {

    }

    public String getReadableIssues(GearCheckerConfig config) {
        StringBuilder output = new StringBuilder();
        if(config.targetRuneSet() != RuneSets.NONE) {
            if (spellbook.getId() != config.targetRuneSet().getSpellbook().getId()) {
                output.append("Wrong spellbook (Need ").append(config.targetRuneSet().getSpellbook().toString()).append(")\n");
            }
            if(!runePouch) {
                output.append("No rune pouch\n");
            }
            boolean foundAny = false;
            for (int i = 0; i < config.targetRuneSet().getRunes().length; i++) {
                Runes rune = config.targetRuneSet().getRunes()[i];
                if (runeAmounts[rune.getRunePouchID()] <= config.runeAmounts()) {
                    output.append(foundAny ? "\n" : "").append(runeAmounts[rune.getRunePouchID()]).append("/").append(config.runeAmounts()).append(" ").append(rune.name().substring(0, 1).toUpperCase()).append(rune.name().substring(1).toLowerCase()).append(" runes");
                    foundAny = true;
                }
            }
        }
        return output.toString();
    }
}
