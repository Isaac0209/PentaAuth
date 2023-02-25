package com.pentacraft.auth.Events;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Join implements Listener {
    @EventHandler
    public void join (PlayerJoinEvent player){
        player.setJoinMessage("O Player §4" + player.getPlayer().getName() + " §rEntrou");
        player.getPlayer().sendMessage("Faça o login digitando /login (senha)");
        PotionEffect potionEffect = new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1);
        PotionEffect movimento = new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 255);

        player.getPlayer().addPotionEffect(potionEffect);
        player.getPlayer().addPotionEffect(movimento);
    }





}
