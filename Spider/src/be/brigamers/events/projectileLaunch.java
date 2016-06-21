package be.brigamers.events;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import spider.Spider;
import spider.SpiderPlayer;

public class projectileLaunch implements Listener{

	@EventHandler
	public void ProjectileLaunch(ProjectileLaunchEvent e){
		 if(!(e.getEntity() instanceof Arrow)) return;
		 if(!(e.getEntity().getShooter() instanceof Player)) return;
		 Player p = (Player) e.getEntity().getShooter(); 
		SpiderPlayer sp = Spider.get(p) ;
		sp.projectile++ ;
	}
	
}
