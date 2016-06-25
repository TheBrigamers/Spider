package be.brigamers.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import spider.Spider;
import spider.SpiderPlayer;

public class InventoryOpen implements Listener {

	@SuppressWarnings("unused")
	@EventHandler
	public static void onInventoryOpen(InventoryOpenEvent e){
		Inventory inv = e.getInventory() ;
		int nbItem = 0 ;
		if(inv.getType() == InventoryType.CHEST){
			Material lastType = inv.getItem(1).getType() ;
			boolean deuxType = false ;
			for( int i = 0; i < inv.getSize(); i++ ) {
				if(inv.getItem(i) != null){
					nbItem++ ;
					if(!(inv.getItem(i).getType() == lastType)) deuxType = true ;
				}
				
			}
			final boolean finalDeuxType = deuxType; 
			final int finalNbItem = nbItem ;
			Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("Spider"), new Runnable(){

				@Override
				public void run() {
					int nbItemPlus = 0 ;
					for( int i = 0; i < inv.getSize(); i++ ) {
						if(inv.getItem(i) != null) nbItemPlus++ ;
					}
					
					if(nbItemPlus == 0 && finalNbItem > 5){
						SpiderPlayer sp = Spider.get((Player)e.getPlayer()) ;
						sp.autoSteal++ ;
						return ;
					}else return ;
					
				}
				
			}, 10) ;
			
		}
	}
	
}
