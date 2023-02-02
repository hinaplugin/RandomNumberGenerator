package com.hinaplugin.randomnumbergenerator.randomnumbergenerator;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomNumberGenerator extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            PluginCommand rng = getCommand("rng");
            if (rng != null){
                rng.setExecutor(new Commands());
            }

            getLogger().info("RandomNumberGenerator is Enabled!");
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        try {
            getLogger().info("RandomNumberGenerator is Disabled!");
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
