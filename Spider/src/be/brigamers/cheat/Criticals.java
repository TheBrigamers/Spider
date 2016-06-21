package be.brigamers.cheat;

import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

import spider.Spider;
import spider.SpiderPlayer;

public class Criticals {

	@SuppressWarnings("deprecation")
	public Criticals(Player p){
		if (!p.isOnGround() && !p.getAllowFlight()) {
            if (p.getLocation().getY() % 1 == 0) {
                if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().isSolid()) {
                    SpiderPlayer sp = Spider.get(p) ;
                    sp.critials++ ;
                }
            }
        }
	}
	
}
