package spider;

import org.bukkit.entity.Player;

public class utils {

	public static void initPlayer(Player p){
		Spider.getSpiderPlayer().add(new SpiderPlayer(p)) ;
	}
	
	public static void removePlayer(Player p){
		Spider.getSpiderPlayer().remove(new SpiderPlayer(p)) ;
	}
	
}
