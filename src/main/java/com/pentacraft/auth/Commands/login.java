package com.pentacraft.auth.Commands;

import com.pentacraft.auth.Events.Eventslogin;
import com.pentacraft.auth.Mysql.verificarlogin;
import com.pentacraft.auth.Others.effects;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class login extends Eventslogin implements CommandExecutor {
    private String nick;
    private String senha;

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

        if(!(s instanceof Player)) return false;
        Player p = (Player) s;
        if(c.getName().equalsIgnoreCase("login")){
            if(args.length == 0){
                p.sendMessage("Cadê a senha?");
            }else{
                senha = args[0];
                nick = p.getName();
                verificarlogin verificar = new verificarlogin(nick, senha);
                Plugin plugin = Bukkit.getPluginManager().getPlugin("PentaCraftAuth");
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        verificar.verificar();
                        if(verificar.getResposta() ==true)

                        {
                            p.sendMessage("Logado com sucesso!");
                            p.sendTitle("§aBem-vindo(a)", "§4" + p.getName(), 40, 1, 1);
                            new effects(PotionEffectType.SLOW, p);
                            new effects(PotionEffectType.BLINDNESS, p);


                        }else

                        {
                            p.sendMessage("Login inválido!");
                        }
                    }

                }.runTaskAsynchronously(plugin);

            }

            return true;
        }
        return false;
    }
}
