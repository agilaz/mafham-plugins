package com.slayertaghighlight;

import net.runelite.client.Notifier;

import javax.inject.Inject;

public class SlayerTaggedCounterManager {
    @Inject
    SlayerTagInfobox infobox;
    @Inject
    SlayerTagHighlightConfig config;
    @Inject
    private Notifier notifier;

    public void clear() {
        infobox.clear();
    }

    public void refresh(int oldCount, int newCount) {
        infobox.refresh(newCount);

        if (config.lowTaggedCountNotification().isEnabled()
                && oldCount > config.lowTaggedCountNotificationThreshold()
                && newCount <= config.lowTaggedCountNotificationThreshold()) {
            notifier.notify(config.lowTaggedCountNotification(), "Tagged NPC Count is low");
        }
    }
}
