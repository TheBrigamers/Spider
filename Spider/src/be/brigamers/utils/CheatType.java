package be.brigamers.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public enum CheatType {

	AIMBOT("Aimbot","Aimbot"),
	ANTIPOTION("Anti-Potion","AntiPotion"),
	AUTOCLICK("AutoClick","AutoClick"),
	CRITIALS("Criticals", "Criticals"),
	FAST_BOW("Fast-Bow","FastBow"),
	FAST_FOOD("Fast-Food","FastFood"),
	FAST_HEAL("Fast-Heal","FastHeal"),
	FLY("Fly","Fly"),
	FLYVANILLA("Fly-Vanilla", "FlyVanilla"),
	FORCEFIELD("Forcefield","Forcefield"),
	HIGH_JUMP("High-Jump","HighJump"),
	JESUS("Jesus","Jesus"),
	KNOCKBACK("Anti-Knockback","AntiKnockback"),
	NO_FALL("No-Fall","NoFall"),
	NUKER("Nuker","Nuker"),
	SPEEDHACK("Speed-Hack","SpeedHack"),
	REGEN("Regen","Regen");
	
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
	
	public void alert(Player p, int pourcentage, int violation){
		String playerName = p.getName() ;
		String msg ;
		if(pourcentage == 0){
			msg = "§6[§b§lSpider§6] §c" + playerName + "§6: §c" + name + "§6 (Violation: §c" + violation + "§6)." ;
		}else{
			msg = "§6[§b§lSpider§6] §c" + playerName + "§6: §c" + name + "§6 (Intensité: §c" + pourcentage + "%§6, Violation: §c" + violation + "§6)."  ;
		}
		for(Player pOnline : Bukkit.getOnlinePlayers()){
			if(pOnline.hasPermission("spider.alert")){
				pOnline.sendMessage(msg);
			}
		}
	}
	
	public void kick(Player p){
		String msg ;
		msg = "§6[§b§lSpider§6] §c" + p.getName() + "§6: §c" + name + "§6 (Kick pour 20 violations)." ;
		p.kickPlayer("§6[§b§lSpider§6] §cvous§6 avez été kick pour §c" + name + "§6 (20 violations).");
		for(Player pOnline : Bukkit.getOnlinePlayers()){
			if(pOnline.hasPermission("spider.alert")){
				pOnline.sendMessage(msg);
			}
		}
	}
	
}
