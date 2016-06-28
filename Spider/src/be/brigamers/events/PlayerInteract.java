package be.brigamers.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import be.brigamers.cheat.Ghost;
import be.brigamers.cheat.forcefield.Forcefield;

public class PlayerInteract implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		Player p = e.getPlayer() ;
		new Ghost(e) ;
		if (p.getInventory().getItemInHand().getType() == Material.BOW) {
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
				new Forcefield(p);
			}
            
        }
	}
	
}
