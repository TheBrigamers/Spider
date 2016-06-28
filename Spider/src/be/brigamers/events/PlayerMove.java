package be.brigamers.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import be.brigamers.cheat.AntiCactus;
import be.brigamers.cheat.Dolphine;
import be.brigamers.cheat.Flying;
import be.brigamers.cheat.Glide;
import be.brigamers.cheat.HighJump;
import be.brigamers.cheat.Jesus;
import be.brigamers.cheat.NoWeb;
import be.brigamers.cheat.Sneak;
import be.brigamers.cheat.SpeedHack;
import be.brigamers.cheat.SpiderCheat;
import be.brigamers.cheat.forcefield.MovePlayer;
import spider.Spider;
import spider.SpiderPlayer;

public class PlayerMove implements Listener{

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e){
		Player p = e.getPlayer() ;
		new Jesus(p) ;
		new Flying(p, e) ;
		new HighJump(p, e) ;
		new SpeedHack(p, e) ;
		new NoWeb(p, e) ;
		new Sneak(p, e) ;
		new Glide(p, e) ;
		new AntiCactus(p) ;
		new Dolphine(p, e) ;
		new SpiderCheat(p, e) ;
		new MovePlayer(p) ;
		if(p.getLocation().clone().add(0,-1,0).getBlock().getType() == Material.SLIME_BLOCK){
			SpiderPlayer sp = Spider.get(p) ;
			sp.join = 10 ;
		}
	}
	
}
