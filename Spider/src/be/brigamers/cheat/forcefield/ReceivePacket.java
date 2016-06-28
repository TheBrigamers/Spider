package be.brigamers.cheat.forcefield;

import org.inventivetalent.packetlistener.PacketListenerAPI;
import org.inventivetalent.packetlistener.handler.PacketHandler;
import org.inventivetalent.packetlistener.handler.ReceivedPacket;
import org.inventivetalent.packetlistener.handler.SentPacket;

import net.minecraft.server.v1_8_R3.PacketPlayInUseEntity;
import net.minecraft.server.v1_8_R3.PacketPlayInUseEntity.EnumEntityUseAction;
import spider.Spider;
import spider.SpiderPlayer;

public class ReceivePacket {

	@SuppressWarnings("deprecation")
	public ReceivePacket(){
		PacketListenerAPI.addPacketHandler(new PacketHandler() {

            @Override
            public void onSend(SentPacket packet) {}

            @Override
            public void onReceive(ReceivedPacket packet) {
            	if(packet == null) return ;
            	if(packet.getPacket() instanceof PacketPlayInUseEntity){
            		SpiderPlayer sp = Spider.get(packet.getPlayer()) ; 
            		if(sp == null) return ;
            		if(sp.npc == null) return ;
            		if(packet.getPacketValue(1) == EnumEntityUseAction.ATTACK){
            			if(packet.getPacketValue(0) == (Object)sp.npc.getId()) ;
            				sp.forcefield++ ;
            		}
            	}
            }

        });
	}
	
}
