package dev.fake.blockengine.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;

public class BucketUseListener implements Listener {

    @EventHandler
    public void onBucketUse(PlayerBucketFillEvent e) {
        if (e.getBlockClicked().getType().name().toUpperCase().endsWith("_SLAB")) e.setCancelled(true);
    }

}
