package be.brigamers.cheat;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;

import be.brigamers.utils.CheatType;

public class HighJump {
	
	public HighJump(Player p, PlayerMoveEvent e){
	 
		 HashMap<Player, Double> playerHeight = new HashMap<Player, Double>();
		 HashMap<String, Location> backLoc = new HashMap<String, Location>();
		
	        if (p.getVehicle() != null) {
	            return;
	        }
	 
	        if (p.getAllowFlight()) {
	            return;
	        }
	 
	        if (!p.getLocation().getBlock().isEmpty()) {
	            return;
	        }
	 
	        if (!playerHeight.containsKey(p)) {
	            playerHeight.put(p, 0.0D);
	        }
	 
	        Block b1 = p.getLocation().clone().add(0.3, -0.3, -0.3).getBlock();
	        Block b2 = p.getLocation().clone().add(-0.3, -0.3, -0.3).getBlock();
	        Block b3 = p.getLocation().clone().add(0.3, -0.3, 0.3).getBlock();
	        Block b4 = p.getLocation().clone().add(-0.3, -0.3, +0.3).getBlock();
	        Block downBlock = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
	        if (b1.getType() != Material.AIR || b2.getType() != Material.AIR || b3.getType() != Material.AIR || b4.getType() != Material.AIR || downBlock.getType().toString().contains("FENCE") || downBlock.toString().contains("WALL")) {
	            backLoc.put(p.getName(), p.getLocation());
	            playerHeight.put(p, 0.0D);
	        }
	 
	       if (e.getTo().getY() > e.getFrom().getY()) {
	            playerHeight.put(p, playerHeight.get(p) + 1);
	       }
	 
	 
	        for (PotionEffect pe : p.getActivePotionEffects()) {
	            if (pe.getType().toString().contains("JUMP")) {
	                int result = 8 + pe.getAmplifier();
	                if (playerHeight.get(p) > result) {
	                    if (backLoc.containsKey(p.getName())) {
	                        backLoc.get(p.getName()).setYaw(p.getLocation().getYaw());
	                        backLoc.get(p.getName()).setPitch(p.getLocation().getPitch());
	                        p.teleport(backLoc.get(p.getName()));
	                        playerHeight.put(p, 0.0D);
	                    }
	                }
	                return;
	            }
	        }
	 
	        if (playerHeight.get(p) > 6) {
	            if (backLoc.containsKey(p.getName())) {
	                backLoc.get(p.getName()).setYaw(p.getLocation().getYaw());
	                backLoc.get(p.getName()).setPitch(p.getLocation().getPitch());
	               	CheatType.HIGH_JUMP.alert(p, 0, 0);
	                playerHeight.put(p, 0.0D);
	            }
	        }
	    }
	
}
