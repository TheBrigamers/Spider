package be.brigamers.cheat;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import spider.Spider;
import spider.SpiderPlayer;

public class Dolphine {

	public Dolphine(Player p, PlayerMoveEvent e){
		
		SpiderPlayer sp = Spider.get(p) ;
		
		Material m = p.getLocation().getBlock().getType() ;
		Material mMoins = p.getLocation().add(0,-1,0).getBlock().getType() ;
		Material mMoinsMoins = p.getLocation().add(0,-2,0).getBlock().getType() ;
		
		if(m == Material.AIR) sp.moveAir++ ;
		if(m == Material.WATER || m == Material.STATIONARY_WATER) sp.moveWater++ ;
		if(m == Material.WATER || m == Material.STATIONARY_WATER || mMoins == Material.WATER || mMoins == Material.STATIONARY_WATER || mMoinsMoins == Material.WATER || mMoinsMoins == Material.STATIONARY_WATER) sp.timeWater++ ;
		else sp.timeWater = 0 ;

		if(p.isFlying()) return ;
		if(p.getLocation().clone().add(1,0,0).getBlock().getType().isSolid()) return ;
		if(p.getLocation().clone().add(-1,0,0).getBlock().getType().isSolid()) return ;
		if(p.getLocation().clone().add(0,0,1).getBlock().getType().isSolid()) return ;
		if(p.getLocation().clone().add(0,0,-1).getBlock().getType().isSolid()) return ;
		
		if(sp.moveAir < 5 && sp.moveAir > 1){
			if(sp.moveWater < 20 && sp.moveWater > 15){
				if(sp.timeWater > 100){
					sp.dolphine++ ;
				}
			}
		}
		
	} 
	
}
