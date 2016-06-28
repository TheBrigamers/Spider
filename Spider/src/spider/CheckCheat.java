package spider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;

import be.brigamers.utils.CheatType;

public class CheckCheat {
	
	public CheckCheat(Spider spider){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(spider, new Runnable(){
			
			@Override
			public void run() {
				
				for(SpiderPlayer sp : Spider.getSpiderPlayer()){
					boolean isCheating = false ;
					CheatType cheat = null;
					
					//sp.getPlayer().sendMessage("§2" + sp.forcefield);
					
					//Check
					
					if(sp.join == 0){
						
						if(sp.critials > 1){
							isCheating = true ;
							cheat = CheatType.CRITIALS ;
						}else
						if(sp.noFall > 3){
							isCheating = true ;
							cheat = CheatType.NO_FALL ;
						}else
						if(sp.jesus > 9){
							isCheating = true ;
							cheat = CheatType.JESUS ;
						}else
						if(sp.NaturalRegen > 4){
							isCheating = true ;
							cheat = CheatType.REGEN ;
						}else
						if(sp.projectile > 7){
							isCheating = true ;
							cheat = CheatType.FAST_BOW ;
						}else
						if(sp.armAnimationPacket > 40){
							isCheating = true ;
							cheat = CheatType.AUTOCLICK ;
						}else
						if(sp.nuker > 50){
							isCheating = true ;
							cheat = CheatType.NUKER ;
						}else
						if(sp.noWeb > 2){
							isCheating = true ;
							cheat = CheatType.NO_WEB ;
						}else
						if(sp.sneak > 10){
							isCheating = true ;
							cheat = CheatType.SNEAK ;
						}else
						if(sp.glide > 3){
							isCheating = true ;
							cheat = CheatType.GLIDE ;
						}else
						if(sp.antiCactus > 12){
							isCheating = true ;
							cheat = CheatType.ANTICACTUS ;
						}else
						if(sp.dolphine > 1){
							isCheating = true ;
							cheat = CheatType.DOLPHINE ;
						}else
						if(sp.autoSteal > 0){
							isCheating = true ;
							cheat = CheatType.AUTOSTEAL ;
						}else
						if(sp.fastEat > 3){
							isCheating = true ;
							cheat = CheatType.FAST_FOOD ;
						}else
						if(sp.fastPlace > 10){
								isCheating = true ;
								cheat = CheatType.FAST_PLACE ;
						}else
						if(sp.freecam > 0){
								isCheating = true ;
								cheat = CheatType.FREECAM ;
						}else
						if(sp.blink > 100){
								isCheating = true ;
								cheat = CheatType.BLINK ;
						}else
						if(sp.timer > 100){
								isCheating = true ;
								cheat = CheatType.TIMER ;
						}else
						if(sp.fly > 3){
							isCheating = true ;
							cheat = CheatType.FLY_HIGHJUMP ;
						}else
						if(sp.spider > 10){
							isCheating = true ;
							cheat = CheatType.SPIDER ;
						}else
						if(sp.forcefield > 15){
							isCheating = true ;
							cheat = CheatType.FORCEFIELD ;
						}
						
						if(isCheating){
							sp.nbCheatDetect++ ;
							cheat.alert(sp);
							sp.cheatDetect.add(cheat.getName()) ;
							if(sp.nbCheatDetect >= 3){
								sp.getPlayer().getLocation().getWorld().strikeLightningEffect(sp.getPlayer().getLocation()) ;
								sp.getPlayer().getLocation().getWorld().strikeLightningEffect(sp.getPlayer().getLocation()) ;
								sp.getPlayer().getLocation().getWorld().strikeLightningEffect(sp.getPlayer().getLocation()) ;
								
								nbArray(sp.cheatDetect, sp) ;
								
								sp.getPlayer().kickPlayer("§6[§b§lSpider§6] §b vous §favez été kick pour §c" + sp.kickRaison + "§f.");
								Bukkit.broadcastMessage("§6[§b§lSpider§6] §b " + sp.getPlayer().getName() + " §fa été kick pour §c" + sp.kickRaison + "§f.") ;
								sp.nbCheatDetect = 0 ;
								sp.cheatDetect.clear();
							}
						}
						
					}else{
						sp.join-- ;
					}
						
					sp.armAnimationPacket = 0 ;
					sp.NaturalRegen = 0 ;
					sp.projectile = 0 ;
					sp.jesus = 0 ;
					sp.speedHack = 0 ;
					sp.nuker = 0 ;
					sp.critials = 0 ;
					sp.noFall = 0 ;
					sp.noWeb = 0 ;
					sp.sneak = 0 ;
					sp.fly = 0 ;
					sp.glide = 0;
					sp.knockback = 0 ;
					sp.timer = 0 ;
					sp.antiCactus = 0 ;
					sp.dolphine = 0 ;
					sp.autoSteal = 0 ;
					sp.fastEat = 0 ;
					sp.fastPlace = 0 ;
					sp.freecam = 0 ;
					sp.nbPacket = 0 ;
					sp.blink = 0 ;
					sp.spider = 0 ;
					sp.moveAir = 0 ;
					sp.moveWater = 0 ;
					sp.forcefield = 0 ;
				}
					
				
				
				
			}
			
		}, 0, 20) ;
	}

	public static void nbArray(ArrayList<String> array, SpiderPlayer sp) {

		Set<String> mySet = new HashSet<String>(array);
		for(String s: mySet){
		 sp.kickRaison += s + "[x" +Collections.frequency(array,s) + "] " ;
		}

	}

	
}
