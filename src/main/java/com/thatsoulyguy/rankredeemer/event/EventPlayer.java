package com.thatsoulyguy.rankredeemer.event;

import com.thatsoulyguy.rankredeemer.RankRedeemer;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class EventPlayer implements Listener
{
    @EventHandler
    public void OnPlayerRedeemRank(PlayerInteractEvent event)
    {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            if (event.getItem() != null && event.getItem().getType() == Material.PAPER)
            {
                if (event.getItem().hasItemMeta() && Objects.requireNonNull(event.getItem().getItemMeta()).hasLore())
                {
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "luckperms user " + event.getPlayer().getName() + " parent set " + RankRedeemer.GetInstance().defaultConfig.GetValue("ranks." + Objects.requireNonNull(event.getItem().getItemMeta().getLore()).get(0) + ".transform_to"));

                    event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0F, 1.0F);

                    event.getPlayer().sendMessage(ChatColor.GREEN + "Your rank has been updated to: '" + Objects.requireNonNull(event.getItem().getItemMeta().getLore()).get(0) + "'!");

                    event.getPlayer().getInventory().removeItem(event.getItem());
                }
            }
        }
    }
}