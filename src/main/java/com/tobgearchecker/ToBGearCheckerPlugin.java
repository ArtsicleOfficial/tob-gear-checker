package com.tobgearchecker;

import com.tobgearchecker.gear.HaveCharges;
import com.tobgearchecker.gear.HaveRunes;
import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;

import java.util.*;

@Slf4j
@PluginDescriptor(
	name = "ToB Gear Checker",
	description = "A plugin that checks your spellbook, runes, and charges.",
	tags = {"tob","gear","rune","spellbook","spells","charges"}
)
public class ToBGearCheckerPlugin extends Plugin
{
	private ToBGearCheckerOverlayPanel gearCheckerOverlayPanel = null;
	public boolean leftVersinhaza = true;

	public HaveCharges charges = new HaveCharges();
	public HaveRunes runes = new HaveRunes();

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private Client client;

	@Inject
	private ToBGearCheckerConfig config;

	@Getter(AccessLevel.PACKAGE)
	private NavigationButton navButton;

	@Override
	protected void startUp()
	{

		gearCheckerOverlayPanel = new ToBGearCheckerOverlayPanel(this, true, ""
		);

	}

	@Subscribe
	public void onChatMessage(ChatMessage event) {
		if(!isInVersinhaza()) {
			return;
		}
		if(event.getType() != ChatMessageType.GAMEMESSAGE && event.getType() != ChatMessageType.SPAM) {
			return;
		}

		String message = Text.removeTags(event.getMessage());

		String[] words = message.split(" ");

		// For blowpipe, there will be three numbers: # of Darts, # of Scales, and % of Scales
		// ^ Exception if player is out of scales or darts.
		// For serp, there will be two numbers: # of Scales, and % of Scales
		// For scythe/trident, there will be one number: # of Charges
		ArrayList<Integer> numbers = new ArrayList<>();

		for(String numericWord : words) {
			numericWord = numericWord.replaceAll("[^\\d]","");
			if(numericWord.length() > 0) {
				numbers.add(Integer.parseInt(numericWord));
			}
 		}

		if(config.blowpipe() && message.toLowerCase().contains("darts") && message.toLowerCase().contains("scales")) {
			boolean hasDarts = true;
			if(words[1].equalsIgnoreCase("none")) {
				hasDarts = false;
				charges.blowpipeDarts = 0;
			} else {
				charges.blowpipeDarts = numbers.get(0);
			}
			charges.blowpipeScales = numbers.get(hasDarts ? 1 : 0);
			charges.blowpipeDartType = words[1];
		} else if(config.scythe() && message.toLowerCase().contains("scythe of vitur")) {
			if(numbers.size() == 0) {
				//NO charges, I assume (not sure what message it gives)
				charges.scytheCharges = 0;
			} else {
				charges.scytheCharges = numbers.get(0);
			}
		} else if(config.serpentine() && message.toLowerCase().contains("scales:") && !message.toLowerCase().contains("darts")) {
			charges.serpentineScales = numbers.get(0);
		} else if (config.trident() && (message.toLowerCase().contains("your weapon has") || message.toLowerCase().contains("sanguinesti staff")) && message.contains("charges")) {
			charges.tridentCharges = numbers.get(0);
		}
	}

	@Override
	protected void shutDown()
	{
		if(gearCheckerOverlayPanel.isVisible()) {
			overlayManager.remove(gearCheckerOverlayPanel);
			gearCheckerOverlayPanel.setVisible(false);
		}
	}

	@Subscribe
	public void onGameTick(GameTick event) {
		if(!isInVersinhaza()) {
			//if we're just leaving
			if(!leftVersinhaza) {
				//Reset charges upon leaving
				charges = new HaveCharges();
			}
			leftVersinhaza = true;
		}
		if(isInVersinhaza()) {
			runes = getPlayerRunes();
			leftVersinhaza = false;
		}
		updateInfoBox();
	}

	private HaveRunes getPlayerRunes() {
		HaveRunes output = new HaveRunes();
		int[] runePouch = new int[22];
		ItemContainer container = client.getItemContainer(InventoryID.INVENTORY);

		output.spellbook = Spellbook.getSpellbookByID(client.getVarbitValue(4070));

		runePouch[client.getVar(Varbits.RUNE_POUCH_RUNE1)] = client.getVar(Varbits.RUNE_POUCH_AMOUNT1);
		runePouch[client.getVar(Varbits.RUNE_POUCH_RUNE2)] = client.getVar(Varbits.RUNE_POUCH_AMOUNT2);
		runePouch[client.getVar(Varbits.RUNE_POUCH_RUNE3)] = client.getVar(Varbits.RUNE_POUCH_AMOUNT3);
		output.runeAmounts = runePouch;
		output.runePouch = false;

		if(container == null) {
			return output;
		}
		Item[] items = container.getItems();
		for (Item item : items) {
			if (item == null) {
				continue;
			}
			if (item.getId() == ItemID.RUNE_POUCH) {
				output.runePouch = true;
				continue;
			}
			for (Runes rune : Runes.values()) {
				if (item.getId() == rune.itemID) {
					output.runeAmounts[rune.runePouchID] += item.getQuantity();
				}
			}
		}
		return output;
	}


	@Provides
	ToBGearCheckerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ToBGearCheckerConfig.class);
	}

	public boolean isInVersinhaza() {
		Player localPlayer = client.getLocalPlayer();
		if(localPlayer == null) {
			return false;
		}
		return localPlayer.getWorldLocation().getRegionID() == 14642;
	}

	private void updateInfoBox() {
		if(!isInVersinhaza() && gearCheckerOverlayPanel.isVisible()) {
			overlayManager.remove(gearCheckerOverlayPanel);
			gearCheckerOverlayPanel.setVisible(false);
		} else if(isInVersinhaza() && !gearCheckerOverlayPanel.isVisible()) {
			overlayManager.add(gearCheckerOverlayPanel);
			gearCheckerOverlayPanel.setVisible(true);
		}
		if(!isInVersinhaza()) {
			return;
		}
		String output;
		String runeIssues = runes.getReadableIssues(config);
		String chargeIssues = charges.getReadableIssues(config);

		if(runeIssues.equals("")) {
			output = chargeIssues;
		} else if(chargeIssues.equals("")) {
			output = runeIssues;
		} else {
			output = runeIssues + "\n\n" + chargeIssues;
		}
		if(runeIssues.length() + chargeIssues.length() == 0) {
			gearCheckerOverlayPanel.SetProblems(true,"");
		} else {
			gearCheckerOverlayPanel.SetProblems(false,output);
		}
	}
}
