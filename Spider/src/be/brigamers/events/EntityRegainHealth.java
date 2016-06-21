package be.brigamers.events;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;

import spider.Spider;
import spider.SpiderPlayer;

public class EntityRegainHealth implements Listener {

	Spider spider ;
	
	int regainSec ;
	
	public EntityRegainHealth(Spider spider) {
		this.spider = spider ;
	}
	
	@EventHandler
	public void onEntityRegainHealth(EntityRegainHealthEvent e){
		if(!(e.getEntity() instanceof Player)) return ;
		if(e.getRegainReason() == RegainReason.SATIATED){
			SpiderPlayer sp = Spider.get((Player) e.getEntity()) ;
			sp.NaturalRegen++ ;
		}
	}
	
}
