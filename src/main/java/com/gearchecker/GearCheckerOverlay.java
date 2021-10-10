package com.gearchecker;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;

public class GearCheckerOverlay extends OverlayPanel {

    private final Client client;
    private final GearCheckerPlugin plugin;
    private final GearCheckerConfig config;

    @Inject
    private GearCheckerOverlay(Client client, GearCheckerPlugin plugin, GearCheckerConfig config) {
        super(plugin);
        this.client = client;
        this.plugin = plugin;
        this.config = config;
        setPosition(OverlayPosition.TOP_CENTER);
        setPriority(OverlayPriority.MED);
    }

    @Override
    public Dimension render(Graphics2D graphics) {

        //panelComponent.getChildren().add(TitleComponent)
        return super.render(graphics);
    }
}
