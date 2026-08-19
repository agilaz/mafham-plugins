package com.slayertaghighlight;

import net.runelite.client.config.*;

import java.awt.*;

@ConfigGroup("slayertaghighlight")
public interface SlayerTagHighlightConfig extends Config
{
	@ConfigItem(
			position = 0,
			keyName = "filterByList",
			name = "Filter by List",
			description = "Only highlights NPCs included in the list (use * as a wildcard, e.g. '*demon' for all demons)"
	)
	default boolean filterByList() {return false;}
	@ConfigItem(
			position = 1,
			keyName = "filterList",
			name = "",
			description = ""
	)
	default String filterList()
	{
		return "";
	}


	@Alpha
	@ConfigItem(
			position = 2,
			keyName = "highlightColor",
			name = "Highlight Color",
			description = "Sets the color of NPC/menu entry highlights"
	)
	default Color highlightColor() {return Color.RED;}

	@ConfigItem(
			position = 3,
			keyName = "tileHighlight",
			name = "Tile Highlight",
			description = "Highlights NPCs tiles"
	)
	default boolean tileHighlight()
	{
		return false;
	}

	@ConfigItem(
			position = 4,
			keyName = "hullHighlight",
			name = "Hull Highlight",
			description = "Highlights NPCs hulls"
	)
	default boolean hullHighlight()
	{
		return false;
	}

	@ConfigItem(
			position = 5,
			keyName = "outlineHighlight",
			name = "Outline Highlight",
			description = "Highlights NPCs outlines"
	)
	default boolean outlineHighlight(){return true;}

	@ConfigItem(
			position = 6,
			keyName = "areaHighlight",
			name = "Area Highlight",
			description = "Highlight NPCs areas"
	)
	default boolean areaHighlight()
	{
		return false;
	}

	@ConfigItem(
			position = 7,
			keyName = "menuHighlight",
			name = "Highlight Menu Names",
			description = "Highlights names in the right-click menu"
	)
	default boolean menuHighlight() {return true;}

	@ConfigItem(
			position = 8,
			keyName = "minimapHighlight",
			name = "Highlight Minimap",
			description = "Highlights the NPC on the minimap"
	)
	default boolean minimapHighlight(){return true;}

	@Range(min = 0, max = 50)
	@ConfigItem(
			position = 9,
			keyName = "tileWidth",
			name = "Tile Width",
			description = "Sets the width of tile highlight"
	)
	default double tileWidth() {return 2;}

	@Range(min = 0, max = 50)
	@ConfigItem(
			position = 10,
			keyName = "outlineWidth",
			name = "Outline/Hull Width",
			description = "Sets the width of the outline/hull highlights"
	)
	default double outlineWidth() {return 2;}

	@Range(min = 0, max = 5)
	@ConfigItem(
			position = 11,
			keyName = "outlineFeather",
			name = "Outline Feather",
			description = "Sets the feather of the outline highlight"
	)
	default int outlineFeather() {return 2;}

	@ConfigItem(
			position = 12,
			keyName = "showTaggedInfobox",
			name = "Show Tagged Count Infobox",
			description = "Show an infobox indicating the number of tagged NPCs"
	)
	default boolean showTaggedInfobox() {return false;}

	@ConfigItem(
			position = 13,
			keyName = "taggedTimeoutMinutes",
			name = "Tagged Infobox Expiry",
			description = "Set the time until the tagged counter infobox expires"
	)
	@Units(Units.MINUTES)
	default int taggedTimeoutMinutes()
	{
		return 5;
	}

	@ConfigItem(
			position = 14,
			keyName = "lowTaggedCountNotification",
			name = "Low Tagged Count Notification",
			description = "Enables notifications for the number of tagged NPCs"
	)
	default Notification lowTaggedCountNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
			position = 15,
			keyName = "taggedCountNotificationThreshold",
			name = "Low Tagged Count Threshold",
			description = "The count of tagged NPCs to notify at"
	)
	default int lowTaggedCountNotificationThreshold()
	{
		return 0;
	}

}
