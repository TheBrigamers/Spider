package be.brigamers.cheat;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import spider.Spider;
import spider.SpiderPlayer;

public class Dolphine {

	public Dolphine(Player p, PlayerMoveEvent e){
		if(p.isFlying()) return ;
		if(e.getFrom().getBlockX() == e.getTo().getBlockX()
		&& e.getFrom().getBlockZ() == e.getTo().getBlockZ()) return ;
		
		int rayon = 6 ;
		
		if(!(p.getLocation().getBlock().getType() == Material.STATIONARY_WATER) && !(p.getLocation().getBlock().getType() == Material.WATER)) return ;
		Double x = Math.abs(e.getFrom().getX() - e.getTo().getX()) ;
		Double z = Math.abs(e.getFrom().getZ() - e.getTo().getZ()) ;
		if(z > 0.15 || x > 0.15){
			for(int i=rayon;i>rayon*-1;i--){
				for(int j=rayon;j>rayon*-1;j--){
					if(p.getLocation().add(i,0,j).getBlock().getType() != Material.WATER
					&& p.getLocation().add(i,0,j).getBlock().getType() != Material.STATIONARY_WATER){
						p.sendMessage("Sauf");
						return ;
					}
				}
				
			}
			SpiderPlayer sp = Spider.get(p) ;
			sp.dolphine++ ;
		}
		
	} 
	
}
