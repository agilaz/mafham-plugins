package com.slayertaghighlight;

import net.runelite.api.gameval.ItemID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

import javax.inject.Inject;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class SlayerTagInfobox {
    @Inject
    private InfoBoxManager infoBoxManager;

    @Inject
    private SlayerTagHighlightConfig config;
    @Inject
    private SlayerTagHighlightPlugin plugin;
    @Inject
    private ItemManager itemManager;

    private SlayerTaggedCounter counter;

    private Instant counterExpiresAt;

    public void clear() {
        if (counter != null) {
            infoBoxManager.removeInfoBox(counter);
            counter = null;
            counterExpiresAt = null;
        }
    }

    public void refresh(int count) {
        if (!config.showTaggedInfobox()) {
            clear();
            return;
        }

        // Set live count
        if (counter != null) {
            counter.setCount(count);
        }

        if (count == 0) {
            // Maintain counter expiry:
            // - start a timer when count drops to 0
            // - remove infobox when the timer expires
            if (counterExpiresAt == null && counter != null) {
                counterExpiresAt = Instant.now().plus(config.taggedTimeoutMinutes(), ChronoUnit.MINUTES);
            } else if (counterExpiresAt != null && counterExpiresAt.isBefore(Instant.now())) {
                clear();
            }
        } else {
            // Reset expiry timer
            counterExpiresAt = null;

            // Create infobox if it does not exist
            if (counter == null) {
                BufferedImage image = itemManager.getImage(ItemID.BRONZE_DART);
                counter = new SlayerTaggedCounter(image, plugin, count);
                infoBoxManager.addInfoBox(counter);
                counter.setTooltip("Number of tagged NPCs");
            }
        }
    }
}
