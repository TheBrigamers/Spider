package be.brigamers.cheat;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import spider.Spider;
import spider.SpiderPlayer;

public class AntiCactus {

	public AntiCactus(Player p){
		SpiderPlayer sp = Spider.get(p) ;
		if(p.isFlying()) return ;
		if(p.getGameMode() != GameMode.SURVIVAL) return ;
		if(!(p.getLocation().getBlock().getType() == Material.CACTUS)){
			if(p.getLocation().add(0,-1,0).getBlock().getType() == Material.CACTUS){
				sp.antiCactus++ ;
			}
			
		}
	}
	
}
