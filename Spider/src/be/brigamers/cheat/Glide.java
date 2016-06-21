package be.brigamers.cheat;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import spider.Spider;
import spider.SpiderPlayer;

public class Glide {

	public Glide(Player p, PlayerMoveEvent e){
		Location to = e.getTo();
        Location from = e.getFrom();
        if (to.getY() - from.getY() == -0.125D && (to.clone().subtract(0.0D, 1.0D, 0.0D).getBlock().getType().equals(Material.AIR))) {
        	SpiderPlayer sp = Spider.get(p) ;
        	sp.glide++ ;
        }
	}
	
}
