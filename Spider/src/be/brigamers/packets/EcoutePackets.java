package be.brigamers.packets;

import org.inventivetalent.packetlistener.PacketListenerAPI;
import org.inventivetalent.packetlistener.handler.PacketHandler;
import org.inventivetalent.packetlistener.handler.ReceivedPacket;
import org.inventivetalent.packetlistener.handler.SentPacket;

import spider.Spider;

public class EcoutePackets {
	
	@SuppressWarnings("deprecation")
	public EcoutePackets(Spider spider){
		
		PacketListenerAPI.addPacketHandler(new PacketHandler() {

            @Override
            public void onSend(SentPacket e) {
            	
            }

            @Override
            public void onReceive(ReceivedPacket e) {
            	/*if(e.getPlayer() == null)return ;
				SpiderPlayer sp = Spider.get(e.getPlayer()) ;
				if(sp == null) return ;
            	if(e.getPacket() instanceof PacketPlayInFlying){
    				sp.flyingPacket++ ;
            	}
            	if(e.getPacket() instanceof PacketPlayInPosition){
    				sp.positionPacket++ ;
            	}
            	if(e.getPacket() instanceof PacketPlayInPositionLook){
    				sp.positionLookPacket++ ;
            	}
            	if(e.getPacket() instanceof PacketPlayInLook){
    				sp.lookPacket++ ;
            	}
            	if(e.getPacket() instanceof PacketPlayInArmAnimation){
    				sp.armAnimationPacket++ ;
            	}
            	if(e.getPacket() instanceof PacketPlayInAbilities){
    				sp.abilitiesPacket++ ;
            	}
            	if(e.getPacket() instanceof PacketPlayInBlockDig){
            		sp.nuker++ ;
            	}
            	if(e.getPacket() instanceof PacketPlayInCloseWindow){
            		sp.closeWindow++ ;
            	}
            	if(e.getPacket() instanceof PacketPlayInChat){
            		sp.chat++ ;
            	}
            	if(e.getPacket() instanceof PacketPlayInWindowClick){
            		sp.windowClick++ ;
            	}*/
            }

        });

	}
}
