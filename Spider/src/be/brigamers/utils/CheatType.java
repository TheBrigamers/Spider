package be.brigamers.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public enum CheatType {

	AIMBOT("Aimbot","Aimbot"),
	ANTIPOTION("Anti-Potion","AntiPotion"),
	AUTOCLICK("AutoClick","AutoClick"),
	CHEAT("Cheat","Cheat"),
	CRITIALS("Criticals", "Criticals"),
	FAST_BOW("Fast-Bow","FastBow"),
	FAST_FOOD("Fast-Food","FastFood"),
	FAST_HEAL("Fast-Heal","FastHeal"),
	FLY("Fly","Fly"),
	FLYVANILLA("Fly-Vanilla", "FlyVanilla"),
	FORCEFIELD("Forcefield","Forcefield"),
	GLIDE("Glide","Glide"),
	HIGH_JUMP("High-Jump","HighJump"),
	JESUS("Jesus","Jesus"),
	KNOCKBACK("Anti-Knockback","AntiKnockback"),
	NO_FALL("No-Fall","NoFall"),
	NO_WEB("No-Web","NoWeb"),
	REGEN("Regen","Regen"),
	NUKER("Nuker","Nuker"),
	SNEAK("Sneak","Sneak"),
	SPEEDHACK("Speed-Hack","SpeedHack"),
	TIMER("Timer", "Timer");
	
	private String name, permission;
	
	private CheatType(String name, String permission){
		this.name = name ;
		this.permission = "SalviAntiCheat.ByPass." + permission ;
	}
	
	public String getName(){
		return name ;
	}
	
	public String getPermission(){
		return permission ;
	}
	
	public void alert(Player p){
		String playerName = p.getName() ;
		String msg = "§6[§b§lSpider§6] §c" + playerName + "§6: §c" + name + "§6."  ;

		for(Player pOnline : Bukkit.getOnlinePlayers()){
			if(pOnline.hasPermission("spider.alert")){
				pOnline.sendMessage(msg);
			}
		}
	}
	
}
