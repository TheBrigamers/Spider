package spider;

import org.bukkit.Bukkit;

import be.brigamers.utils.CheatType;

public class CheckCheat {
	
	public CheckCheat(Spider spider){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(spider, new Runnable(){
			
			@Override
			public void run() {
				
				for(SpiderPlayer sp : Spider.getSpiderPlayer()){
					
					int pourcentage = 0;
					Bukkit.getLogger().info(sp.getPlayer().getName() + ": " + sp.critials);
					
					//V2
					
					
						if(sp.critials > 1){
							sp.critialsViolation++ ;
							CheatType.CRITIALS.alert(sp.getPlayer(), 0, sp.critialsViolation);
						}else
						if(sp.noFall > 5){
							sp.noFallViolation++ ;
							CheatType.NO_FALL.alert(sp.getPlayer(),sp.noFall*50,sp.noFallViolation);
						}else
						if(sp.jesus > 9){
							sp.jesusViolation++ ;
							CheatType.JESUS.alert(sp.getPlayer(),0,sp.jesusViolation);
						}else
						if(sp.NaturalRegen > 4){
							pourcentage = sp.NaturalRegen*50 ;
							sp.regenViolation++ ;
							CheatType.REGEN.alert(sp.getPlayer(),pourcentage,sp.regenViolation);
						}else
						if(sp.projectile > 3){
							pourcentage = sp.projectile*50 ;
							sp.fastBowViolation++ ;
							CheatType.FAST_BOW.alert(sp.getPlayer(),pourcentage,sp.fastBowViolation);
						}
					
					//V1
					
					else
					if(sp.flyingPacket > 50){
						pourcentage = sp.flyingPacket*5 ;
						sp.antiPotionViolation++ ;
						CheatType.ANTIPOTION.alert(sp.getPlayer(),pourcentage,sp.antiPotionViolation);
					}else
					if(sp.armAnimationPacket > 30){
						pourcentage = sp.armAnimationPacket*14 ;
						sp.autoClickViolation++ ;
						CheatType.AUTOCLICK.alert(sp.getPlayer(),pourcentage,sp.autoClickViolation);
					}else
					if(sp.abilitiesPacket > 10){
						sp.flyVanillaViolation++ ;
						CheatType.FLYVANILLA.alert(sp.getPlayer(),0,sp.flyVanillaViolation);
					}else
					if(sp.highJump > 2){
						sp.highJumpViolation++ ;
						CheatType.HIGH_JUMP.alert(sp.getPlayer(), 0,sp.highJumpViolation);
					}else
					if(sp.fly > 5){
						sp.flyViolation++ ;
						CheatType.FLY.alert(sp.getPlayer(), 0,sp.flyViolation);
					}else
					if(sp.nuker > 50){
						sp.nukerViolation++ ;
						CheatType.NUKER.alert(sp.getPlayer(), 0,sp.nukerViolation);
					}else
						if(sp.forcefield > 0 && (sp.closeWindow > 0 || sp.chat > 0 || sp.windowClick > 0)){
							sp.forcefieldViolation++ ;
							CheatType.FORCEFIELD.alert(sp.getPlayer(), 0, sp.forcefieldViolation);
						}
					
					sp.flyingPacket = 0 ;
					sp.positionLookPacket = 0 ;
					sp.positionPacket = 0 ;
					sp.lookPacket = 0 ;
					sp.armAnimationPacket = 0 ;
					sp.NaturalRegen = 0 ;
					sp.projectile = 0 ;
					sp.abilitiesPacket = 0 ;
					sp.jesus = 0 ;
					sp.forcefield = 0 ;
					sp.highJump = 0 ;
					sp.fly = 0 ;
					sp.speedHack = 0 ;
					sp.nuker = 0 ;
					sp.critials = 0 ;
					sp.closeWindow = 0 ;
					sp.chat = 0 ;
					sp.windowClick = 0 ;
					sp.noFall = 0 ;
				}
					
				
				
				
			}
			
		}, 0, 20) ;
	}
	
}
