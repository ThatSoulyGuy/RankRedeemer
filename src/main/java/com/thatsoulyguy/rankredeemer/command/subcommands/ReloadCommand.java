package com.thatsoulyguy.rankredeemer.command.subcommands;

import com.thatsoulyguy.rankredeemer.RankRedeemer;
import com.thatsoulyguy.rankredeemer.command.RRCommand;
import com.thatsoulyguy.rankredeemer.command.RRCommandRegistration;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ReloadCommand extends RRCommand
{

    @Override
    public int Execute(Player player, String[] args)
    {
        player.sendMessage(ChatColor.YELLOW + "Attempting to reload...");

        RankRedeemer.GetInstance().defaultConfig.Reload();

        player.sendMessage(ChatColor.GREEN + "Successfully Reloaded!");

        return 0;
    }

    @Override
    public RRCommandRegistration Register()
    {
        return RRCommandRegistration.Register("reload", "Reloads the plugin", "/rankredeemer reload");
    }
}