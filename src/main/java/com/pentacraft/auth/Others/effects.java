package com.pentacraft.auth.Others;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class effects {
    public effects(PotionEffectType potion, Player player){
        new BukkitRunnable() {
            @Override
            public void run() {
                player.removePotionEffect(potion);

            }
        }.runTask(Bukkit.getPluginManager().getPlugin("PentaCraftAuth"));
    }

}
