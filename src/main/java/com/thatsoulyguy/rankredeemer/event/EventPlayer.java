package com.thatsoulyguy.rankredeemer.event;

import com.thatsoulyguy.rankredeemer.RankRedeemer;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;
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
                    List<String> lore = event.getItem().getItemMeta().getLore();

                    assert lore != null;
                    String id = (String) RankRedeemer.GetInstance().defaultConfig.GetValue("ranks." + lore.get(1) + ".id");

                    if (lore.size() == 1 && id.equals(lore.get(0)))
                    {
                        LuckPerms luckPerms = RankRedeemer.GetInstance().luckPerms;

                        User user = luckPerms.getUserManager().getUser(event.getPlayer().getUniqueId());

                        assert user != null;
                        user.setPrimaryGroup(lore.get(1));

                        luckPerms.getUserManager().saveUser(user);

                        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0F, 1.0F);

                        event.getPlayer().sendMessage(ChatColor.GREEN + "Your rank has been updated to: '" + lore.get(1) + "'!");

                        event.getPlayer().getInventory().removeItem(event.getItem());
                    }
                }
            }
        }
    }
}