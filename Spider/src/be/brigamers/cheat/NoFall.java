package be.brigamers.cheat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import spider.Spider;
import spider.SpiderPlayer;

public class NoFall implements Listener {
 
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        SpiderPlayer sp = Spider.get(p) ;
 
        if (e.getTo().getBlockY() < e.getFrom().getBlockY()) {
           
            if(p.getFallDistance() % 1 == 0){
            	sp.noFall++ ;
            }
        }
    }
	
}
