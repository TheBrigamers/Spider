package spider;

import org.bukkit.Bukkit;

import be.brigamers.utils.CheatType;

public class CheckCheat {
	
	public CheckCheat(Spider spider){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(spider, new Runnable(){
			
			@Override
			public void run() {
				
				for(SpiderPlayer sp : Spider.getSpiderPlayer()){
					//Bukkit.broadcastMessage("§2" + sp.nbPacket);
					sp.nbPacket = 0 ;
					boolean isCheating = false ;
					CheatType cheat = null;
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
						if(sp.projectile > 3){
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
						if(sp.fly > 1){
							//isCheating = true ;
							Bukkit.broadcastMessage("§4Cheat ?") ;
						}else
						if(sp.timer > 100){
							//isCheating = true ;
							Bukkit.broadcastMessage("§4Timer ?") ;
						}
						
						if(isCheating){
							sp.nbCheatDetect++ ;
							cheat.alert(sp);
							if(sp.nbCheatDetect >= 3){
								sp.getPlayer().kickPlayer("§6[§b§lSpider§6] §b vous §favez été kick pour §c" + cheat.getName() + "§f.");
								sp.nbCheatDetect = 0 ;
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
					
				}
					
				
				
				
			}
			
		}, 0, 20) ;
	}
	
}
