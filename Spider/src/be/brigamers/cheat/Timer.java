package be.brigamers.cheat;

import org.bukkit.entity.Player;

import spider.Spider;
import spider.SpiderPlayer;

public class Timer {

	public Timer(Player p){
		SpiderPlayer sp = Spider.get(p) ;
		sp.timer++ ;
	}
	
}
