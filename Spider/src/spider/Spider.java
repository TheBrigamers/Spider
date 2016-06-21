package spider;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import be.brigamers.cheat.NoFall;
import be.brigamers.events.EntityDamageByEntity;
import be.brigamers.events.EntityRegainHealth;
import be.brigamers.events.PlayerMove;
import be.brigamers.events.PlayerVelocity;
import be.brigamers.events.projectileLaunch;
import be.brigamers.packets.EcoutePackets;
import be.brigamers.packets.sendAllPackets;
import be.brigamers.punition.BanCommand;
import be.brigamers.punition.EventListener;
import be.brigamers.punition.kickCommand;
import be.brigamers.punition.muteCommand;

public class Spider extends JavaPlugin{

	private static ArrayList<SpiderPlayer> sp = new ArrayList<SpiderPlayer>() ;
	
	public void onEnable(){
		for(Player pOnline : Bukkit.getOnlinePlayers()){
			utils.initPlayer(pOnline);
		}
		new EcoutePackets(this);
		new CheckCheat(this) ;
		new sendAllPackets(this);
		getCommand("ban").setExecutor(new BanCommand());
		getCommand("kick").setExecutor(new kickCommand());
		getCommand("mute").setExecutor(new muteCommand());
		Bukkit.getPluginManager().registerEvents(new EventListener(), this);
		Bukkit.getPluginManager().registerEvents(new muteCommand(), this);
		Bukkit.getPluginManager().registerEvents(new EntityRegainHealth(this), this);
		Bukkit.getPluginManager().registerEvents(new projectileLaunch(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerMove(), this);
		Bukkit.getPluginManager().registerEvents(new EntityDamageByEntity(), this);
		Bukkit.getPluginManager().registerEvents(new NoFall(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerVelocity(), this);
	}
	
	public void onDisable(){
		
	}
	
	public Plugin getInstance(){
		return Bukkit.getPluginManager().getPlugin("Spider") ;
	}
	
	public static ArrayList<SpiderPlayer> getSpiderPlayer(){
		return sp ;
	}
	
	public static SpiderPlayer get(Player Player){
		SpiderPlayer s = null ;
		for(SpiderPlayer gps : sp){
			if(gps.getPlayer() == Player){
				s = gps ;
				break ;
			}
		}
		return s ;
	}
	
}
