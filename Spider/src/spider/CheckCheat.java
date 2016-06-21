package spider;

import org.bukkit.Bukkit;

import be.brigamers.utils.CheatType;

public class CheckCheat {
	
	public CheckCheat(Spider spider){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(spider, new Runnable(){
			
			@Override
			public void run() {
				
				for(SpiderPlayer sp : Spider.getSpiderPlayer()){
					
					//Check
					
						if(sp.critials > 1){
							CheatType.CRITIALS.alert(sp.getPlayer());
						}else
						if(sp.noFall > 5){
							CheatType.NO_FALL.alert(sp.getPlayer());
						}else
						if(sp.jesus > 9){
							CheatType.JESUS.alert(sp.getPlayer());
						}else
						if(sp.NaturalRegen > 4){
							CheatType.REGEN.alert(sp.getPlayer());
						}else
						if(sp.projectile > 3){
							CheatType.FAST_BOW.alert(sp.getPlayer());
						}else
						if(sp.armAnimationPacket > 30){;
							CheatType.AUTOCLICK.alert(sp.getPlayer());
						}else
						if(sp.nuker > 50){
							CheatType.NUKER.alert(sp.getPlayer());
						}else
						if(sp.noWeb > 2){
							CheatType.NO_WEB.alert(sp.getPlayer());
						}else
						if(sp.sneak > 10){
							CheatType.SNEAK.alert(sp.getPlayer());
						}else
						if(sp.fly > 3){
							CheatType.FLY.alert(sp.getPlayer());
						}else
						if(sp.glide > 3){
							CheatType.GLIDE.alert(sp.getPlayer());
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
				}
					
				
				
				
			}
			
		}, 0, 20) ;
	}
	
}
