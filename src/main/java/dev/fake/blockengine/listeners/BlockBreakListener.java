package dev.fake.blockengine.listeners;

import dev.fake.blockengine.BlockEngine;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Slab;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Block b = e.getBlock();
        if (!(b.getBlockData() instanceof Slab)) return;
        Slab s = (Slab) b.getBlockData();
        if (s.getType() != Slab.Type.DOUBLE) return;
        if (!s.isWaterlogged()) return;
        Player p = e.getPlayer();
        if (e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
            e.setDropItems(false);
            Location l = b.getLocation();
            if (l.getWorld() != null) {
                l.getWorld().dropItem(l, customizeSlab(b.getType()));
            }
        }
        b.setType(Material.AIR);
    }

    private ItemStack customizeSlab(Material t) {
        ItemStack i = new ItemStack(BlockEngine.DUMMY_BLOCK);
        ItemMeta m = i.getItemMeta();
        if (m == null) return i;
        try {
            Class material = t.getClass();
            Field idField = material.getDeclaredField("id");
            idField.setAccessible(true);
            m.setCustomModelData(idField.getInt(t));
        } catch (IllegalAccessException | NoSuchFieldException ignore) {
        }
        m.displayName(Component.translatable("blockengine:" + t.name().toLowerCase()).decoration(TextDecoration.ITALIC, false));
        i.setItemMeta(m);
        return i;
    }

}
