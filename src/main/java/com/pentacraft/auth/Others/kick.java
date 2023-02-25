package com.pentacraft.auth.Others;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class kick {

    public kick(String nick, String motivo){
        new BukkitRunnable() {
            @Override
            public void run() {
                Player player = Bukkit.getPlayer(nick);
                if (player != null) {
                    player.kickPlayer(motivo);

                }

            }
        }.runTask(Bukkit.getPluginManager().getPlugin("PentaCraftAuth"));
    }

}
