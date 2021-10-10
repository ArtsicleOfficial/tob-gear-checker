package com.gearchecker.gear;

import com.gearchecker.GearCheckerConfig;
import com.gearchecker.RuneSets;

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
        StringBuilder output = new StringBuilder();
        if(config.blowpipe()) {
            if(blowpipeDartType.equals("") || blowpipeDarts == -1 || blowpipeScales == -1) {
                output.append("Please check charges on your blowpipe\n");
            } else {
                if (!blowpipeDartType.equals(config.blowpipeDartType().toString()) && blowpipeDarts > 0) {
                    output.append(blowpipeDartType).append(" instead of ").append(config.blowpipeDartType()).append(" blowpipe darts\n");
                }
                if (blowpipeDarts < config.blowpipeDartAmounts()) {
                    output.append(blowpipeDarts).append("/").append(config.blowpipeDartAmounts()).append(" blowpipe darts\n");
                }
                if (blowpipeScales < config.blowpipeScaleAmounts()) {
                    output.append(blowpipeScales).append("/").append(config.blowpipeScaleAmounts()).append(" blowpipe scales\n");
                }
            }
        }
        if(config.serpentine()) {
            if(serpentineScales == -1) {
                output.append("Please check charges on your serpentine\n");
            } else if (serpentineScales < config.serpentineAmount()) {
                output.append(serpentineScales).append("/").append(config.serpentineAmount()).append(" serpentine scales\n");
            }
        }
        if(config.trident()) {
            if(tridentCharges == -1) {
                output.append("Please check charges on your trident\n");
            } else if(tridentCharges < config.tridentAmount()) {
                output.append(tridentCharges).append("/").append(config.tridentAmount()).append(" trident charges\n");
            }
        }
        if(config.scythe()) {
            if(scytheCharges == -1) {
                output.append("Please check charges on your scythe\n");
            } else if(scytheCharges < config.scytheAmount()) {
                output.append(scytheCharges).append("/").append(config.scytheAmount()).append(" scythe charges\n");
            }
        }
        return output.toString();
    }
}
