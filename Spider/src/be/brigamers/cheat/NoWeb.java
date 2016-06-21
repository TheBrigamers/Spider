package be.brigamers.cheat;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import spider.Spider;
import spider.SpiderPlayer;

public class NoWeb {

	public NoWeb(Player p, PlayerMoveEvent e){
		if(p.isFlying()) return ;
		if(p.getLocation().getBlock().getType() != Material.WEB) return ;
		if (e.getFrom().distance(e.getTo()) > 0.2) {
			SpiderPlayer sp = Spider.get(p) ;
			sp.noWeb++ ;
		}
		
	}
	
}
