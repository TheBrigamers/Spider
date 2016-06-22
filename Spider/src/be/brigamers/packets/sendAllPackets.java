package be.brigamers.packets;

import org.inventivetalent.packetlistener.PacketListenerAPI;
import org.inventivetalent.packetlistener.handler.PacketHandler;
import org.inventivetalent.packetlistener.handler.ReceivedPacket;
import org.inventivetalent.packetlistener.handler.SentPacket;
import spider.Spider;

public class sendAllPackets {
	
	
	@SuppressWarnings("deprecation")
	public sendAllPackets(Spider spider){
		PacketListenerAPI.addPacketHandler(new PacketHandler() {

            @Override
            public void onSend(SentPacket packet) {
            	
            }

            @Override
            public void onReceive(ReceivedPacket packet) {
            	
            }

        });
	}
	
}
