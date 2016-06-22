package be.brigamers.utils;

import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

public class Fonction {

	public boolean isFlying(Player p){
		
		if(p.hasPotionEffect(PotionEffectType.JUMP)) return false ;
		for(int i=0;i>-3;i--){
			if(p.getLocation().add(0,i,0).getBlock().getRelative(BlockFace.DOWN).getType().isSolid()
					|| p.getLocation().add(1,i,0).getBlock().getRelative(BlockFace.DOWN).getType().isSolid()
					|| p.getLocation().add(1,i,1).getBlock().getRelative(BlockFace.DOWN).getType().isSolid()
					|| p.getLocation().add(1,i,-1).getBlock().getRelative(BlockFace.DOWN).getType().isSolid()
					|| p.getLocation().add(-1,i,0).getBlock().getRelative(BlockFace.DOWN).getType().isSolid()
					|| p.getLocation().add(-1,i,1).getBlock().getRelative(BlockFace.DOWN).getType().isSolid()
					|| p.getLocation().add(-1,i,-1).getBlock().getRelative(BlockFace.DOWN).getType().isSolid()
					|| p.getLocation().add(0,i,1).getBlock().getRelative(BlockFace.DOWN).getType().isSolid()
					|| p.getLocation().add(0,i,-1).getBlock().getRelative(BlockFace.DOWN).getType().isSolid()
					|| p.getLocation().add(0,i,0).getBlock().isLiquid()
					|| p.getLocation().add(1,i,0).getBlock().isLiquid()
					|| p.getLocation().add(1,i,1).getBlock().isLiquid()
					|| p.getLocation().add(1,i,-1).getBlock().isLiquid()
					|| p.getLocation().add(-1,i,0).getBlock().isLiquid()
					|| p.getLocation().add(-1,i,1).getBlock().isLiquid()
					|| p.getLocation().add(-1,i,-1).getBlock().isLiquid()
					|| p.getLocation().add(0,i,1).getBlock().isLiquid()
					|| p.getLocation().add(0,i,-1).getBlock().isLiquid()){
						return false ;
					}
		}
		
		return true ;
	}

	public boolean isJumping(Player p, PlayerMoveEvent e) {
		if (e.getTo().getBlockY() > e.getFrom().getBlockY()
			|| e.getTo().getBlockY() < e.getFrom().getBlockY()) {
			if(p.isFlying()) return false ;
			return true ;
		}
		return false;
	}
	
	public boolean hasMoved(Player p, Location from, Location to){
		if(from.getX() != to.getX()) return true ;
		if(from.getY() != to.getY()) return true ;
		if(from.getZ() != to.getZ()) return true ;
		return false ;
	}
	
}
