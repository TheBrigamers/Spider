package be.brigamers.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import be.brigamers.cheat.Freecam;

public class BlockBreak implements Listener{

	@EventHandler
	public void onPlayer(BlockBreakEvent e){
		new Freecam(e) ;
	}
	
}
