package spider;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import be.brigamers.cheat.NoFall;
import be.brigamers.events.BlockBreak;
import be.brigamers.events.EntityDamageByBlock;
import be.brigamers.events.EntityDamageByEntity;
import be.brigamers.events.EntityRegainHealth;
import be.brigamers.events.InventoryOpen;
import be.brigamers.events.PlayerFeed;
import be.brigamers.events.PlayerInteract;
import be.brigamers.events.PlayerJoin;
import be.brigamers.events.PlayerMove;
import be.brigamers.events.PlayerVelocity;
import be.brigamers.events.projectileLaunch;
import be.brigamers.packets.EcoutePackets;
import be.brigamers.packets.sendAllPackets;
import be.brigamers.punishement.BanCommand;
import be.brigamers.punishement.EventListener;
import be.brigamers.punishement.kickCommand;
import be.brigamers.punishement.muteCommand;

public class Spider extends JavaPlugin{

	private static ArrayList<SpiderPlayer> sp = new ArrayList<SpiderPlayer>() ;
	
	public void onEnable(){
		for(Player pOnline : Bukkit.getOnlinePlayers()){
			utils.initPlayer(pOnline);
		}
		new EcoutePackets(this);
		new CheckCheat(this) ;
		new sendAllPackets(this);
		new Timer() ;
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
		Bukkit.getPluginManager().registerEvents(new EntityDamageByBlock(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryOpen(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerFeed(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
		Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerInteract(), this);
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
