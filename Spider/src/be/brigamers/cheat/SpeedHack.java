package be.brigamers.cheat;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import spider.Spider;
import spider.SpiderPlayer;

@SuppressWarnings("deprecation")
public class SpeedHack {
	
	public SpeedHack(Player p, PlayerMoveEvent e){
		
		
		
		/*
		if(p.isFlying()) return ;
		if(!p.isOnGround()) return ;
		if(checkJump(p)) return ;
		if(!new Fonction().hasMoved(p, e.getFrom(), e.getTo())) return ;
		double walkSpeed = p.getWalkSpeed() ;
		double vitesseMax = walkSpeed * 1.2 ;
		double vitesse = e.getFrom().distance(e.getTo()) ;
		if(p.isSprinting()) vitesseMax *= 1.3 ;
		//Bukkit.broadcastMessage(String.format("%.2f", vitesse) + " / " + String.format("%.2f", vitesseMax)) ;*/
	}
	
	public boolean checkJump(Player p){
		SpiderPlayer sp = Spider.get(p) ;
		if(!p.isOnGround())  sp.jumping++ ;
		if(sp.jumping > 0){
			return true ;
		}
		return false ;
	}
	
}
