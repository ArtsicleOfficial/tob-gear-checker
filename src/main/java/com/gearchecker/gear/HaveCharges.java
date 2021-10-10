package com.gearchecker.gear;

import com.gearchecker.GearCheckerConfig;
import com.gearchecker.RuneSets;
import sun.text.resources.cldr.ext.FormatData_sr_Cyrl_BA;

public class HaveCharges {
    public String blowpipeDartType = "";
    public int blowpipeDarts = -1;
    public int blowpipeScales = -1;
    public int serpentineScales = -1;
    public int scytheCharges = -1;
    public int tridentCharges = -1;

    public RuneSets set;

    public HaveCharges() {

    }

    public HaveCharges(String blowpipeDartType, int blowpipeDarts, int blowpipeScales, int serpentineScales, int scytheCharges, int tridentCharges) {
        this.blowpipeDartType = blowpipeDartType;
        this.blowpipeDarts = blowpipeDarts;
        this.blowpipeScales = blowpipeScales;
        this.serpentineScales = serpentineScales;
        this.scytheCharges = scytheCharges;
        this.tridentCharges = tridentCharges;
    }

    public String getReadableIssues(GearCheckerConfig config) {
        String output = "";
        if(config.blowpipe()) {
            if(blowpipeDartType.equals("") || blowpipeDarts == -1 || blowpipeScales == -1) {
                output += "Please check charges on your blowpipe\n";
            } else {
                if (!blowpipeDartType.equals(config.blowpipeDartType().toString()) && blowpipeDarts > 0) {
                    output += blowpipeDartType + " instead of " + config.blowpipeDartType() + " blowpipe darts\n";
                }
                if (blowpipeDarts < config.blowpipeDartAmounts()) {
                    output += blowpipeDarts + "/" + config.blowpipeDartAmounts() + " blowpipe darts\n";
                }
                if (blowpipeScales < config.blowpipeScaleAmounts()) {
                    output += blowpipeScales + "/" + config.blowpipeScaleAmounts() + " blowpipe scales\n";
                }
            }
        }
        if(config.serpentine()) {
            if(serpentineScales == -1) {
                output += "Please check charges on your serpentine\n";
            } else if (serpentineScales < config.serpentineAmount()) {
                output += serpentineScales + "/" + config.serpentineAmount() + " serpentine scales\n";
            }
        }
        if(config.trident()) {
            if(tridentCharges == -1) {
                output += "Please check charges on your trident\n";
            } else if(tridentCharges < config.tridentAmount()) {
                output += tridentCharges + "/" + config.tridentAmount() + " trident charges\n";
            }
        }
        if(config.scythe()) {
            if(scytheCharges == -1) {
                output += "Please check charges on your scythe\n";
            } else if(scytheCharges < config.scytheAmount()) {
                output += scytheCharges + "/" + config.scytheAmount() + " scythe charges\n";
            }
        }
        return output;
    }
}
