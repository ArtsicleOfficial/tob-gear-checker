package com.tobgearchecker;

import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;

public class ToBGearCheckerOverlayPanel extends OverlayPanel {
    private boolean visible = false;

    private boolean everythingGood;
    private String problems;

    @Inject
    public ToBGearCheckerOverlayPanel(ToBGearCheckerPlugin plugin, boolean everythingGood, String problems) {
        super(plugin);

        this.everythingGood = everythingGood;
        this.problems = problems;
        setPriority(OverlayPriority.MED);
        setPosition(OverlayPosition.TOP_CENTER);
    }

    @Override
    public Dimension render(Graphics2D graphics) {

        panelComponent.getChildren().add(TitleComponent.builder()
                .text(everythingGood ? "You are ready for ToB!" : "ToB Setup Issues!")
                .color(everythingGood ? Color.GREEN : Color.RED)
                .build());

        if(!everythingGood) {
            String[] spaced = problems.split("\n");
            for (int i = 0; i < spaced.length; i++) {
                panelComponent.getChildren().add(
                        LineComponent
                                .builder()
                                .left(spaced[i])
                                .leftColor(spaced[i].contains("Please") ? (i % 2 == 0 ? Color.WHITE : Color.GRAY) : (i % 2 == 0 ? Color.ORANGE : Color.YELLOW))
                                .build());
            }
        }

        return super.render(graphics);
    }

    public void SetProblems(boolean everythingGood, String problems) {
        this.everythingGood = everythingGood;
        this.problems = problems;
    }

    public void setVisible(boolean isVisible)
    {
        this.visible = isVisible;
    }

    public boolean isVisible()
    {
        return this.visible;
    }

}
