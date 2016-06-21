package be.brigamers.cheat;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import be.brigamers.utils.Fonction;
import spider.Spider;
import spider.SpiderPlayer;

public class SpeedHack {

	public SpeedHack(Player p, PlayerMoveEvent e){
		if(e.getTo().getX() == e.getFrom().getX()
		&& e.getTo().getY() == e.getFrom().getY()
		&& e.getTo().getZ() == e.getFrom().getZ()) return ;
		double sup = 0.15 ;
		if(p.isSprinting()) sup += 0.1 ;
		if(p.isFlying()) sup += 1.5 ;
		if(new Fonction().isJumping(p, e)) sup += 0.2 ;
		double maxSpeed = 0.25 + sup ;
		double speed = e.getTo().distance(e.getFrom()) ;
		if(speed > maxSpeed){
			SpiderPlayer sp = Spider.get(p) ;
			sp.speedHack++ ;
		}
		
	}
	
}
