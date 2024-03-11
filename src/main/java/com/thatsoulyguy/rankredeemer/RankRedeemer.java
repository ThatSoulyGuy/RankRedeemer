package com.thatsoulyguy.rankredeemer;

import com.thatsoulyguy.rankredeemer.command.CommandManager;
import com.thatsoulyguy.rankredeemer.event.EventPlayer;
import com.thatsoulyguy.rankredeemer.util.RRConfig;
import org.bukkit.plugin.java.JavaPlugin;

public final class RankRedeemer extends JavaPlugin
{
    public RRConfig defaultConfig = new RRConfig();

    private static RankRedeemer instance = null;

    @Override
    public void onEnable()
    {
        instance = this;

        CommandManager.Initialize();

        getServer().getPluginManager().registerEvents(new EventPlayer(), this);
        getCommand("rankredeemer").setExecutor(new CommandManager());

        defaultConfig.Initialize("config.yml");
    }

    @Override
    public void onDisable()
    {

    }

    public static RankRedeemer GetInstance()
    {
        return instance;
    }
}
