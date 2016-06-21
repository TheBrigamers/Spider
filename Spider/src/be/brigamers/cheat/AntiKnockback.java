package be.brigamers.cheat;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerVelocityEvent;

import spider.Spider;
import spider.SpiderPlayer;

public class AntiKnockback {

	public AntiKnockback(Player p, PlayerVelocityEvent e){
		Location loc = p.getLocation() ;
		Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("Spider"), new Runnable(){

			@Override
			public void run() {
				if(!p.isOnline() || !p.isValid() || p==null) return ;
				if(p.getVehicle() != null) return ;
				if(p.getLocation().add(0,2,0).getBlock().getType() != Material.AIR) return ;
				if(p.getLocation().distanceSquared(loc) == 0){
					SpiderPlayer sp = Spider.get(p) ;
					sp.knockback++ ;
				};
				
			}
			
		}, 3) ;
		
	}
	
}
