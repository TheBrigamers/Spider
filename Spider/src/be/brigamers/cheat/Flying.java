package be.brigamers.cheat;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import be.brigamers.utils.Fonction;
import spider.Spider;
import spider.SpiderPlayer;

public class Flying {

	public Flying(Player p, PlayerMoveEvent e){
		if(!(e.getFrom().getY() == e.getTo().getY())) return ;
		if(!new Fonction().isFlying(p)) return ;
		if(p.isFlying()) return ;
		SpiderPlayer sp = Spider.get(p) ;
		sp.fly++ ;
	}
	
}
