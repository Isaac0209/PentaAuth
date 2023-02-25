package com.pentacraft.auth;

import com.pentacraft.auth.Commands.login;
import com.pentacraft.auth.Events.Eventslogin;
import com.pentacraft.auth.Events.Join;
import com.pentacraft.auth.Events.Quit;
import com.pentacraft.auth.Events.ServerPing;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        Bukkit.getPluginManager().registerEvents(new Eventslogin(), this);
        Bukkit.getPluginManager().registerEvents(new Join(), this);
        Bukkit.getPluginManager().registerEvents(new ServerPing(), this);
        Bukkit.getPluginManager().registerEvents(new Quit(), this);

        getCommand("login").setExecutor(new login());
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder center 71.045 -142.755");
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 2000");


    }
    @Override
    public void onDisable(){

    }

}
