package be.brigamers.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import spider.SpiderPlayer;

public enum CheatType {

	AIMBOT("Aimbot","Aimbot"),
	ANTICACTUS("Anti-Cactus","AntiCactus"),
	ANTIPOTION("Anti-Potion","AntiPotion"),
	AUTOCLICK("AutoClick","AutoClick"),
	AUTOSTEAL("AutoSteal","AutoSteal"),
	BLINK("Blink","Blink"),
	CHEAT("Cheat","Cheat"),
	CRITIALS("Criticals", "Criticals"),
	DOLPHINE("Dolphine","Dolphine"),
	FAST_BOW("Fast-Bow","FastBow"),
	FAST_FOOD("Fast-Food","FastFood"),
	FAST_HEAL("Fast-Heal","FastHeal"),
	FAST_PLACE("Fast-Place","FastPlace"),
	FLY_HIGHJUMP("Fly/HighJump","FlyHighJump"),
	FLYVANILLA("Fly-Vanilla", "FlyVanilla"),
	FORCEFIELD("Forcefield","Forcefield"),
	FREECAM("Freecam/Derp","Freecam"),
	GLIDE("Glide","Glide"),
	JESUS("Jesus","Jesus"),
	KNOCKBACK("Anti-Knockback","AntiKnockback"),
	NO_FALL("No-Fall","NoFall"),
	NO_WEB("No-Web","NoWeb"),
	REGEN("Regen","Regen"),
	NUKER("Nuker/ClickBreak","Nuker"),
	SNEAK("Sneak","Sneak"),
	SPEEDHACK("Speed-Hack","SpeedHack"),
	TIMER("Timer", "Timer");
	
	private String name, permission;
	
	private CheatType(String name, String permission){
		this.name = name ;
		this.permission = "Spider.ByPass." + permission ;
	}
	
	public String getName(){
		return name ;
	}
	
	public String getPermission(){
		return permission ;
	}
	
	public void alert(SpiderPlayer sp){
		String playerName = sp.getPlayer().getName() ;
		String msg = "§6[§b§lSpider§6] §c" + playerName + "§6: §c" + name + "§6."  ;

		for(Player pOnline : Bukkit.getOnlinePlayers()){
			if(pOnline.hasPermission("spider.alert")){
				pOnline.sendMessage(msg);
			}
		}
	}
	
}
