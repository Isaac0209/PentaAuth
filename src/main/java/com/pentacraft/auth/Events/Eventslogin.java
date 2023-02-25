package com.pentacraft.auth.Events;

import com.pentacraft.auth.Mysql.verificarplayer;
import com.pentacraft.auth.Others.kick;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class Eventslogin implements Listener{
    private String nick;

    @EventHandler
    public void evento(org.bukkit.event.player.PlayerLoginEvent player) throws SQLException, InterruptedException, ExecutionException {
        nick = player.getPlayer().getName();
        Plugin plugin = Bukkit.getPluginManager().getPlugin("PentaCraftAuth");
        new BukkitRunnable() {


            @Override
            public void run() {
                verificarplayer verificar = new verificarplayer(nick);
                verificar.verificar();
                if (verificar.getResposta() == false) {
                    new kick(player.getPlayer().getName(), "Nick não cadastrado, entre em nosso Discord e faça o seu cadastro!");
                }
            }
        }.runTaskAsynchronously(plugin);
    }
}
