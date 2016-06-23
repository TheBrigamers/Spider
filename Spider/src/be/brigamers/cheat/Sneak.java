package be.brigamers.cheat;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import spider.Spider;
import spider.SpiderPlayer;

public class Sneak {

	@SuppressWarnings("deprecation")
	public Sneak(Player p, PlayerMoveEvent e){
		if(!p.isSneaking()) return ;
		if (!p.isOnGround()) return ;
		if(p.isFlying()) return ;
		if (e.getFrom().distance(e.getTo()) + 0.2 > p.getWalkSpeed() + 0.2){
			SpiderPlayer sp = Spider.get(p) ;
			sp.sneak++ ;
		}
	}
	
}
