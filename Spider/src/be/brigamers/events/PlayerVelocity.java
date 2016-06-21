package be.brigamers.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerVelocityEvent;

import be.brigamers.cheat.AntiKnockback;

public class PlayerVelocity implements Listener{

	@EventHandler
	public void onPlayerVelocity(PlayerVelocityEvent e){
		new AntiKnockback(e.getPlayer(), e) ;
	}
	
}
