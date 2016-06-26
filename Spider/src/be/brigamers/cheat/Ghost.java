package be.brigamers.cheat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerInteractEvent;

public class Ghost {

	public Ghost(PlayerInteractEvent e){
		List<Block> blocks = new ArrayList<Block>() ;
		blocks = e.getPlayer().getLineOfSight((Set<Material>)null, 10) ;
		for(Block block : blocks){
			if(block.getType().isOccluding()){
				boolean x = block.getLocation().getBlockX() != e.getClickedBlock().getLocation().getBlockX();
				boolean y = block.getLocation().getBlockY() != e.getClickedBlock().getLocation().getBlockY();
				boolean z = block.getLocation().getBlockZ() != e.getClickedBlock().getLocation().getBlockZ();
				boolean w = block.getLocation().getWorld() != e.getClickedBlock().getLocation().getWorld();
				int marge = 0 ;
				if(x) marge++ ;
				if(y) marge++ ;
				if(z) marge++ ;
				if(w) marge++ ;
				if(marge > 1){
					//Hack
				}
			}
		}
	}
	
}
