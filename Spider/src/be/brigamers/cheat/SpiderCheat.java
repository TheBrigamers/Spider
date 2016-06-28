package be.brigamers.cheat;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import spider.SpiderPlayer;
import spider.Spider;

public class SpiderCheat {

	public SpiderCheat(Player p, PlayerMoveEvent e){
		if(p.isFlying()) return ;
		if(p.getVehicle() != null) return ;
		if(e.getTo().getY() > e.getFrom().getY()){
			if(p.getLocation().clone().add(0,1,1).getBlock().getType().isOccluding()
			||p.getLocation().clone().add(0,1,-1).getBlock().getType().isOccluding()
			||p.getLocation().clone().add(1,1,0).getBlock().getType().isOccluding()
			||p.getLocation().clone().add(-1,1,0).getBlock().getType().isOccluding()){
				if(!p.getLocation().getBlock().isLiquid()
				&& !p.getLocation().clone().add(1,0,1).getBlock().isLiquid()
				&& !p.getLocation().clone().add(1,0,0).getBlock().isLiquid()
				&& !p.getLocation().clone().add(1,0,-1).getBlock().isLiquid()
				&& !p.getLocation().clone().add(0,0,1).getBlock().isLiquid()
				&& !p.getLocation().clone().add(0,0,-1).getBlock().isLiquid()
				&& !p.getLocation().clone().add(-1,0,1).getBlock().isLiquid()
				&& !p.getLocation().clone().add(-1,0,0).getBlock().isLiquid()
				&& !p.getLocation().clone().add(-1,0,-1).getBlock().isLiquid()){
					if(p.getLocation().clone().add(0,-1,0).getBlock().getType().isSolid()) return ;
					if(p.getLocation().clone().add(0,-2,0).getBlock().getType().isSolid()) return ;
					if(p.getLocation().clone().add(0,-1,0).getBlock().isLiquid()) return ;
					if(p.getLocation().clone().add(0,-2,0).getBlock().isLiquid()) return ;
					if(p.getLocation().clone().getBlock().getType() == Material.LADDER) return ;
					SpiderPlayer sp = Spider.get(p) ;
					sp.spider++ ;
				}
				
			}
			
		}
	}
	
}
