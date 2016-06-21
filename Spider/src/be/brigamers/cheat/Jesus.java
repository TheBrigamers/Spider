package be.brigamers.cheat;

import org.bukkit.Material;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;

import spider.Spider;
import spider.SpiderPlayer;

public class Jesus {

	public Jesus(Player p){
		Material sw = Material.STATIONARY_WATER ;
		Material w = Material.WATER ;
		if(p.isFlying()) return ;
		if(p.getVehicle() instanceof Boat) return ;
		if(p.getLocation().add(0,-1,0).getBlock().getType() == sw
				|| p.getLocation().add(0,-1,0).getBlock().getType() == w){
			if(p.getLocation().add(1,-1,0).getBlock().getType() == sw
					&& p.getLocation().add(-1,-1,0).getBlock().getType() == sw
					&& p.getLocation().add(0,-1,1).getBlock().getType() == sw
					&& p.getLocation().add(0,-1,-1).getBlock().getType() == sw
					&& p.getLocation().add(-1,-1,1).getBlock().getType() == sw
					&& p.getLocation().add(-1,-1,-1).getBlock().getType() == sw
					&& p.getLocation().add(1,-1,-1).getBlock().getType() == sw
					&& p.getLocation().add(1,-1,1).getBlock().getType() == sw){
				if(p.getLocation().getBlock().getType() == Material.AIR){
					SpiderPlayer sp = Spider.get(p) ;
					if(sp==null)return ;
					sp.jesus++ ;
				}
				
			}
			
		}
	}
	
}
