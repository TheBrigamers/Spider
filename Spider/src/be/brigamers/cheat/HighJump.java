package be.brigamers.cheat;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import spider.Spider;
import spider.SpiderPlayer;

public class HighJump {

	public HighJump(Player p,PlayerMoveEvent e){
		 if (e.getTo().getBlockY() == e.getFrom().getBlockY() + 1 && e.getTo().getWorld().getBlockAt(e.getTo()).getRelative(BlockFace.DOWN).getType() == Material.AIR) {
			 if(p.hasPotionEffect(PotionEffectType.JUMP)) return ;
				if(p.isFlying()) return ;
				for(int i=-1;i>-100;i--){
					if(p.getLocation().add(0,i,0).getBlock().getType() == Material.SLIME_BLOCK) return ;
				}
				SpiderPlayer sp = Spider.get(p) ;
				sp.highJump++ ;
		 }
	}
	
}
