package com.pentacraft.auth.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener {


    @EventHandler
    public void Quit(PlayerQuitEvent player){
        player.setQuitMessage("Poxaaa, o player §4" + player.getPlayer().getName() + " §rSaiu do servidor :(");
    }
}
