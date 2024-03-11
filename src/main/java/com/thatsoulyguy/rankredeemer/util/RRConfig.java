package com.thatsoulyguy.rankredeemer.util;

import com.thatsoulyguy.rankredeemer.RankRedeemer;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class RRConfig
{
    private File configFile;
    private FileConfiguration config;
    private String path;

    public void Initialize(String path)
    {
        this.path = path;

        configFile = new File(RankRedeemer.GetInstance().getDataFolder(), path);

        if (!configFile.exists())
        {
            configFile.getParentFile().mkdirs();
            RankRedeemer.GetInstance().saveResource(path, false);
        }

        config = new YamlConfiguration();

        try
        {
            config.load(configFile);
        }
        catch (IOException | InvalidConfigurationException e)
        {
            e.printStackTrace();
        }
    }

    public void Reload()
    {
        configFile = new File(RankRedeemer.GetInstance().getDataFolder(), path);

        if (!configFile.exists())
        {
            configFile.getParentFile().mkdirs();
            RankRedeemer.GetInstance().saveResource(path, false);
        }

        config = new YamlConfiguration();

        try
        {
            config.load(configFile);
        }
        catch (IOException | InvalidConfigurationException e)
        {
            e.printStackTrace();
        }
    }

    public void SetValue(String path, Object value)
    {
        config.set(path, value);
        Save();
    }

    public Object GetValue(String path)
    {
        return config.get(path);
    }

    public void Save()
    {
        try
        {
            config.save(configFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}