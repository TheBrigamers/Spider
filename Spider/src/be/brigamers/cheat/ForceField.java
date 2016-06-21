package be.brigamers.cheat;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import spider.Spider;
import spider.SpiderPlayer;

public class ForceField {

	public ForceField(Player p){
		Location loc = p.getLocation() ;
		boolean trouvé = false ;
		loc.setY(loc.getY() + 1.5);
		for(int i=7;i>0;i--){
			loc = loc.add(loc.getDirection());
			for(Player pOnline : Bukkit.getOnlinePlayers()){
				Location pOnlineLoc = pOnline.getLocation() ;
				Boolean ifX = pOnlineLoc.getBlockX() == loc.getBlockX() ;
				Boolean ifY = (pOnlineLoc.getBlockY() == loc.getBlockY()) || (pOnlineLoc.getBlockY()+1 == loc.getBlockY());
				Boolean ifZ = pOnlineLoc.getBlockZ() == loc.getBlockZ() ;
				if(ifX && ifY && ifZ){
					if(pOnline.getName() != p.getName()){
						trouvé = true ;
					}
				}
			}
		}
		
		if(trouvé == false){
			SpiderPlayer sp = Spider.get(p) ;
			sp.forcefield++ ;
		}
	}
	
}
