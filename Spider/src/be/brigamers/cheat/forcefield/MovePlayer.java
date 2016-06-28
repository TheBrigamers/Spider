package be.brigamers.cheat.forcefield;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import spider.Spider;
import spider.SpiderPlayer;

public class MovePlayer {

	public MovePlayer(Player p){
		SpiderPlayer sp = Spider.get(p) ;
		Location loc = p.getLocation() ;
		if(sp.npc == null) return ;
        Location card = Cardinal.getCardinal(p).blockBehind(loc, 1) ;
        
        sp.npc.setLocation(card.getX(),card.getY() + 3,card.getZ(),card.getYaw(), card.getPitch());
        
        PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
        connection.sendPacket(new PacketPlayOutEntityTeleport(sp.npc));
	}
	
}
