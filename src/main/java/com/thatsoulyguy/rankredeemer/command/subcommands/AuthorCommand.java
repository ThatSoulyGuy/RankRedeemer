package com.thatsoulyguy.rankredeemer.command.subcommands;

import com.thatsoulyguy.rankredeemer.command.RRCommand;
import com.thatsoulyguy.rankredeemer.command.RRCommandRegistration;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AuthorCommand extends RRCommand
{

    @Override
    public int Execute(Player player, String[] args)
    {
        player.sendMessage(ChatColor.YELLOW + "This plugin was created by ThatSoulyGuy, also known as 0x0000FFFD.");

        return 0;
    }

    @Override
    public RRCommandRegistration Register()
    {
        return RRCommandRegistration.Register("author", "Tells you who made this plugin.", "/rankredeemer author");
    }
}