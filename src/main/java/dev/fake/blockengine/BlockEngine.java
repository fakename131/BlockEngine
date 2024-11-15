package dev.fake.blockengine;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import dev.fake.blockengine.listeners.BlockBreakListener;
import dev.fake.blockengine.listeners.BlockPlaceListener;
import dev.fake.blockengine.listeners.BucketUseListener;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import sun.misc.Unsafe;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class BlockEngine extends JavaPlugin {

    public static final Material DUMMY_BLOCK = Material.DRIPSTONE_BLOCK;

    public static Map<Integer, Material> decode = new HashMap<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new BucketUseListener(), this);

        extractAgent();
        attachAgent();

        for (Material m : Material.values()) {
            if (m.name().toUpperCase().endsWith("_SLAB")) {
                try {
                    Class material = m.getClass();
                    Field idField = material.getDeclaredField("id");
                    idField.setAccessible(true);
                    int ordinal = idField.getInt(m);
                    decode.put(ordinal, m);
                } catch (IllegalAccessException | NoSuchFieldException ignored) {
                }
            }
        }
    }

    private void extractAgent() {
        saveResource("PistonTweaks.jar", false);
    }

    private void attachAgent() {
        String javaHome = System.getProperty("java.home");
        String jcmdPath = javaHome + File.separator + "bin" + File.separator + "jcmd";
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            jcmdPath += ".exe";
        }

        try {
            Runtime.getRuntime().exec(new String[]{jcmdPath, String.valueOf(ProcessHandle.current().pid()), "JVMTI.agent_load", new File(getDataFolder(), "PistonTweaks.jar").getPath()});
        } catch (IOException e) {
            e.printStackTrace();
            getLogger().warning("Error attaching java agent. Moving custom blocks with pistons will revert them to slabs.");
        }

    }

    @Override
    public void onDisable() {
    }
}
