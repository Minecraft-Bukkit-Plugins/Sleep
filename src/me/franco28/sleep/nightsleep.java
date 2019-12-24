package me.franco28.sleep;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class nightsleep extends JavaPlugin implements Listener {

	public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin Buenas Noches Activado!");
		getServer().getPluginManager().registerEvents(this, this);
	}
    public void onDisable() {
    	getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin Buenas Noches Desactivado!");
    }
    
    public boolean day() {
        Server server = getServer();
        long time = server.getWorld("Mundo").getTime();
        			 
        return time < 12300 || time > 23850;  
    }
        
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSleep(PlayerBedEnterEvent event) {	

		Player p = (Player) event.getPlayer();

		if (day() == false) {
			    Bukkit.broadcastMessage(ChatColor.RED + "" + p.getName() + " está durmiendo...");
				p.sendTitle(ChatColor.BOLD + "Buenas Noches,", ChatColor.translateAlternateColorCodes('&', "&6&l" + p.getName() + ""));	
		
		} else {
			p.sendTitle(ChatColor.RED + "Solo puedes dormir de noche, ", ChatColor.translateAlternateColorCodes('&', "o en una tormenta!" ));	
		}
		
	}
	
	@EventHandler
	public void onWakeUp(PlayerBedLeaveEvent event) {
		if (day() == true) {
		      for (int i = 0; i < 100; i++) {
		          Bukkit.broadcastMessage("");
		      } 
		      Bukkit.broadcastMessage(ChatColor.GOLD + "|-----------------------------------------|");
		      Bukkit.broadcastMessage(ChatColor.BOLD + " Buenos dias dormilones! Son las 12:30hs   ");
		      Bukkit.broadcastMessage(ChatColor.GOLD + "|-----------------------------------------|");
	    } 
	}
		
}
