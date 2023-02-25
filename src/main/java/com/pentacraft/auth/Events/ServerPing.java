package com.pentacraft.auth.Events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerPing implements Listener {
    @EventHandler
    public void ping(ServerListPingEvent ping){
        Bukkit.getConsoleSender().sendMessage(String.valueOf(Bukkit.hasWhitelist()));
        if(Bukkit.hasWhitelist()){
            ping.setMotd("§4§l Servidor em manutenção!");
        }
    }
}
