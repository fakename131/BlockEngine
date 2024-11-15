package dev.fake.blockengine.listeners;

import dev.fake.blockengine.BlockEngine;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Slab;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Block b = e.getBlock();
        if (b.getType() != BlockEngine.DUMMY_BLOCK) return;
        ItemStack i = e.getItemInHand();
        ItemMeta m = i.getItemMeta();
        if (m == null) return;
        if (!m.hasCustomModelData()) return;
        e.getBlock().setType(BlockEngine.decode.get(m.getCustomModelData()));
        Slab s = (Slab) b.getBlockData();
        s.setWaterlogged(true);
        s.setType(Slab.Type.DOUBLE);
        e.getBlock().setBlockData(s);
    }

}
