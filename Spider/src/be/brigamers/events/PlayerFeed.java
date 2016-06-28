package be.brigamers.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class PlayerFeed implements Listener {
	
	@EventHandler
	public void onPlayerFeed(PlayerItemConsumeEvent e){
		//Bukkit.broadcastMessage("feed") ;
	}
	
}
