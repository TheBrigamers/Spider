package spider;

import org.bukkit.Bukkit;

import be.brigamers.utils.CheatType;

public class CheckCheat {
	
	public CheckCheat(Spider spider){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(spider, new Runnable(){
			
			@Override
			public void run() {
				
				for(SpiderPlayer sp : Spider.getSpiderPlayer()){
					Bukkit.broadcastMessage(sp.armAnimationPacket + "") ;
					sp.nbPacket = 0 ;
					boolean isCheating = false ;
					//Check
						if(sp.critials > 1){
							isCheating = true ;
							CheatType.CRITIALS.alert(sp.getPlayer());
						}else
						if(sp.noFall > 3){
							isCheating = true ;
							CheatType.NO_FALL.alert(sp.getPlayer());
						}else
						if(sp.jesus > 9){
							isCheating = true ;
							CheatType.JESUS.alert(sp.getPlayer());
						}else
						if(sp.NaturalRegen > 4){
							isCheating = true ;
							CheatType.REGEN.alert(sp.getPlayer());
						}else
						if(sp.projectile > 3){
							isCheating = true ;
							CheatType.FAST_BOW.alert(sp.getPlayer());
						}else
						if(sp.armAnimationPacket > 40){
							isCheating = true ;
							CheatType.AUTOCLICK.alert(sp.getPlayer());
						}else
						if(sp.nuker > 50){
							isCheating = true ;
							CheatType.NUKER.alert(sp.getPlayer());
						}else
						if(sp.noWeb > 2){
							isCheating = true ;
							CheatType.NO_WEB.alert(sp.getPlayer());
						}else
						if(sp.sneak > 10){
							isCheating = true ;
							CheatType.SNEAK.alert(sp.getPlayer());
						}else
						if(sp.glide > 3){
							isCheating = true ;
							CheatType.GLIDE.alert(sp.getPlayer());
						}else
						if(sp.knockback > 1){
							isCheating = true ;
							CheatType.KNOCKBACK.alert(sp.getPlayer()) ;
						}else
						if(sp.fly > 1){
							isCheating = true ;
							CheatType.CHEAT.alert(sp.getPlayer());
						}
						if(isCheating){
							sp.nbCheatDetect++ ;
							if(sp.nbCheatDetect >= 3){
								sp.getPlayer().kickPlayer("§6[§b§lSpider§6] §b vous §favez été kick pour §cCheat§f.");
								sp.nbCheatDetect = 0 ;
							}
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
				}
					
				
				
				
			}
			
		}, 0, 20) ;
	}
	
}
