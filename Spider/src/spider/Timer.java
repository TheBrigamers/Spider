package spider;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import be.brigamers.cheat.Tracer;

public class Timer implements Runnable{

	public Timer(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("Spider"), this, 0, 20) ;
	}
	
	@Override
	public void run() {
		
		for(Player p : Bukkit.getOnlinePlayers()){
			new Tracer(p) ;
		}
		
		
	}

	
	
}
