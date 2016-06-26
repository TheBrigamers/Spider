package be.brigamers.cheat;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import spider.Spider;
import spider.SpiderPlayer;

@SuppressWarnings("deprecation")
public class Flying {

	public Flying(Player p, PlayerMoveEvent e){
		if(MoveChecker(e) || VerticalMoveChecker(e)){
			SpiderPlayer sp = Spider.get(p) ;
			 sp.fly++ ;
		}
		
	    }
	    
	    public boolean MoveChecker(PlayerMoveEvent e){
	    	Player p = e.getPlayer() ;
	    	Block b1 = p.getLocation().clone().add(0.3, -0.3, -0.3).getBlock();
	        Block b2 = p.getLocation().clone().add(-0.3, -0.3, -0.3).getBlock();
	        Block b3 = p.getLocation().clone().add(0.3, -0.3, 0.3).getBlock();
	        Block b4 = p.getLocation().clone().add(-0.3, -0.3, +0.3).getBlock();
	        Block downBlock = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
	        
	        if (p.getVehicle() != null) {
	            return false;
	        }
	 
	        if (p.isFlying()) {
	            return false;
	        }
	 
	        if (p.getLocation().getBlock().getType() == Material.WATER || p.getLocation().getBlock().getType() == Material.STATIONARY_WATER) {
	            return false ;
	        }
	 
	        if (e.getTo().getY() > e.getFrom().getY()) {
	            return false ;
	        }
	 
	        if (e.getTo().getY() < e.getFrom().getY()) {
	            return false ;
	        }
	 
	        if (e.getTo().getY() != e.getFrom().getY() || e.getTo().getX() != e.getFrom().getX() || e.getTo().getZ() != e.getFrom().getZ()) {
	        	
	            if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
	                return false;
	            }
	 
	            if (!p.isOnGround()) {
	            	if (b1.getType() != Material.AIR || b2.getType() != Material.AIR || b3.getType() != Material.AIR || b4.getType() != Material.AIR || downBlock.getType().toString().contains("FENCE") || downBlock.toString().contains("WALL")) {
	            		return true ;
	    	        }
	            }
	        }
	        return false ;
		}
	    
	    public boolean VerticalMoveChecker(PlayerMoveEvent e){
	     
	            Player p = e.getPlayer();
	     
	            if (p.getVehicle() != null) return false;
	     
	            if (p.isFlying()) return false;
	            
	            if(p.hasPotionEffect(PotionEffectType.JUMP)) return false ;
	     
	            Vector vec = new Vector(e.getTo().getX(), e.getTo().getY(), e.getTo().getZ());
	     
	            double i = vec.distance(new Vector(e.getFrom().getX(), e.getFrom().getY(), e.getFrom().getZ()));
	     
	            if (e.getTo().getBlockY() > e.getFrom().getBlockY()) {
	     
	                if (i > 0.58) {
	                   return true ;
	                }
	            }
	    	return false ;
	    }
	    
	    /*public boolean flyLent(PlayerMoveEvent e){
	    	Player p = e.getPlayer() ;
	    	SpiderPlayer sp = Spider.get(p) ;
	    	if (p.getVehicle() != null) {
	            return false;
	        }
	 
	        if (p.getAllowFlight()) {
	            return false;
	        }
	 
	        if (!p.getLocation().getBlock().isEmpty()) {
	            return false;
	        }
	        
	        if(p.hasPotionEffect(PotionEffectType.JUMP)) return false ;
	 
	        Block b1 = p.getLocation().clone().add(0.3, -0.3, -0.3).getBlock();
	        Block b2 = p.getLocation().clone().add(-0.3, -0.3, -0.3).getBlock();
	        Block b3 = p.getLocation().clone().add(0.3, -0.3, 0.3).getBlock();
	        Block b4 = p.getLocation().clone().add(-0.3, -0.3, +0.3).getBlock();
	        Block downBlock = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
	        if (b1.getType() != Material.AIR || b2.getType() != Material.AIR || b3.getType() != Material.AIR || b4.getType() != Material.AIR || downBlock.getType().toString().contains("FENCE") || downBlock.toString().contains("WALL")) {
	            sp.deplaceBlock = 0 ;
	        }
	 
	       if (e.getTo().getY() > e.getFrom().getY()) {
	            sp.deplaceBlock += 1 ;
	       }
	 
	        if (sp.deplaceBlock > 5) {
	            sp.deplaceBlock = 0 ;
	            Bukkit.broadcastMessage("§4Fly(3)") ;
	            return true ;
	        }
	    	return false ;
	    }*/
}
