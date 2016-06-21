package be.brigamers.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import be.brigamers.cheat.Criticals;

public class EntityDamageByEntity implements Listener {
	
	@EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
        	final Player p = (Player) e.getDamager();
            new Criticals(p) ;
        }
    }
	
}
