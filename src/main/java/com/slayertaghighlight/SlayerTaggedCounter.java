package com.slayertaghighlight;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.infobox.Counter;

import java.awt.image.BufferedImage;

public class SlayerTaggedCounter extends Counter {
    public SlayerTaggedCounter(BufferedImage image, Plugin plugin, int count) {
        super(image, plugin, count);
    }
}
