package be.brigamers.cheat;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.GameMode;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import spider.Spider;
import spider.SpiderPlayer;

public class NoFall implements Listener {

	HashMap<String, Integer> numberBlock = new HashMap<String, Integer>();
    ArrayList<String> allowScheduler = new ArrayList<String>();
 
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
 
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
 
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        final Player p = e.getPlayer();
 
        if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().isSolid()) {
            numberBlock.put(p.getName(), 0);
        }
 
        if (e.getTo().getBlockY() < e.getFrom().getBlockY()) {
            numberBlock.put(p.getName(), numberBlock.get(p.getName()) + 1);
            if (numberBlock.get(p.getName()) != round(p.getFallDistance() + 1, 0)) {
            	if(p.isFlying()) return ;
            	if(!(p.getGameMode() == GameMode.SURVIVAL)) return ;

            	SpiderPlayer sp = Spider.get(p) ;
            	sp.noFall++ ;
 
            }
        }
    }
	
}
