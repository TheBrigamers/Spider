package be.brigamers.cheat;

import org.bukkit.Location;
import org.bukkit.event.block.BlockBreakEvent;

import spider.Spider;
import spider.SpiderPlayer;

public class Freecam {

	public Freecam(BlockBreakEvent e){
		
		Location locBlockBreak = e.getBlock().getLocation() ;
		Location loc = e.getPlayer().getLocation() ;
		boolean isEgale = false ;
		
		if(locBlockBreak.distance(loc) > 10){
			SpiderPlayer sp = Spider.get(e.getPlayer()) ;
			sp.freecam++ ;
		}
		
		loc.setY(loc.getY() + 1.35);
		loc = loc.add(loc.getDirection());
		for(int i=10;i>0;i--){
			if((loc.getBlockX() == locBlockBreak.getBlockX() && loc.getBlockY() == locBlockBreak.getBlockY() && loc.getBlockZ() == locBlockBreak.getBlockZ())
			|| (loc.getBlockX()+1 == locBlockBreak.getBlockX() && loc.getBlockY() == locBlockBreak.getBlockY() && loc.getBlockZ() == locBlockBreak.getBlockZ()-1)
			|| (loc.getBlockX()+1 == locBlockBreak.getBlockX() && loc.getBlockY() == locBlockBreak.getBlockY() && loc.getBlockZ() == locBlockBreak.getBlockZ()
			|| (loc.getBlockX()+1 == locBlockBreak.getBlockX() && loc.getBlockY() == locBlockBreak.getBlockY() && loc.getBlockZ() == locBlockBreak.getBlockZ()+1))
			|| (loc.getBlockX()-1 == locBlockBreak.getBlockX() && loc.getBlockY() == locBlockBreak.getBlockY() && loc.getBlockZ() == locBlockBreak.getBlockZ()-1)
			|| (loc.getBlockX()-1 == locBlockBreak.getBlockX() && loc.getBlockY() == locBlockBreak.getBlockY() && loc.getBlockZ() == locBlockBreak.getBlockZ())
			|| (loc.getBlockX()-1 == locBlockBreak.getBlockX() && loc.getBlockY() == locBlockBreak.getBlockY() && loc.getBlockZ() == locBlockBreak.getBlockZ()+1)
			|| (loc.getBlockX() == locBlockBreak.getBlockX() && loc.getBlockY() == locBlockBreak.getBlockY() && loc.getBlockZ() == locBlockBreak.getBlockZ()-1)
			|| (loc.getBlockX() == locBlockBreak.getBlockX() && loc.getBlockY() == locBlockBreak.getBlockY() && loc.getBlockZ() == locBlockBreak.getBlockZ()+1)
			|| (loc.getBlockX() == locBlockBreak.getBlockX() && loc.getBlockY()-1 == locBlockBreak.getBlockY() && loc.getBlockZ() == locBlockBreak.getBlockZ())
			|| (loc.getBlockX() == locBlockBreak.getBlockX() && loc.getBlockY()+1 == locBlockBreak.getBlockY() && loc.getBlockZ() == locBlockBreak.getBlockZ())){
				isEgale = true ;
			}
			loc = loc.add(loc.getDirection());
		}
		
		if(!isEgale){
			SpiderPlayer sp = Spider.get(e.getPlayer()) ;
			sp.freecam++ ;
		}
		
	}
	
}
