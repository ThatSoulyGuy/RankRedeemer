package com.thatsoulyguy.rankredeemer.command.subcommands;

import com.thatsoulyguy.rankredeemer.RankRedeemer;
import com.thatsoulyguy.rankredeemer.command.RRCommand;
import com.thatsoulyguy.rankredeemer.command.RRCommandRegistration;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GiveRankCommand extends RRCommand
{

    @Override
    public int Execute(Player player, String[] args)
    {
        if (args.length == 0)
        {
            player.sendMessage(ChatColor.DARK_RED + "You must input a name.");
            return -1;
        }

        ItemStack itemOut = new ItemStack(Material.PAPER);
        ItemMeta meta = itemOut.getItemMeta();

        if (meta == null)
        {
            player.sendMessage(ChatColor.DARK_RED + "Error creating item meta.");
            return -2;
        }

        int id;

        try
        {
            id = (int) RankRedeemer.GetInstance().defaultConfig.GetValue("ranks." + args[0] + ".id");
        }
        catch (Exception e)
        {
            player.sendMessage(ChatColor.DARK_RED + "Error retrieving rank ID.");
            return -3;
        }

        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.values());
        meta.setLore(List.of(new String[]{String.valueOf(id), args[0]}));
        meta.setDisplayName(ChatColor.GREEN + "Redeem " + args[0] + " rank!");

        itemOut.setItemMeta(meta);

        player.getInventory().addItem(itemOut);

        return 0;
    }

    @Override
    public RRCommandRegistration Register()
    {
        return RRCommandRegistration.Register("giverank", "Gives you a configures rank upgrade", "/rankredeemer giverank <name>");
    }
}