package be.brigamers.cheat.forcefield;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.mojang.authlib.GameProfile;

import be.brigamers.cheat.Tracer;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.minecraft.server.v1_8_R3.PlayerInteractManager;
import spider.Spider;
import spider.SpiderPlayer;

public class Forcefield {

	//TODO Version Beta ! Bug possible !
	
	public Forcefield(Player p){
		SpiderPlayer sp = Spider.get(p) ;
		if(!(sp.npc == null)) return ;
        PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
        
        sp.npc =
        	new EntityPlayer(((CraftServer) Bukkit.getServer()).getServer(), 
        	((CraftWorld) Bukkit.getWorlds().get(0)).getHandle(),
        	new GameProfile(UUID.randomUUID(), ChatColor.RED + Tracer.newName()), new PlayerInteractManager(((CraftWorld) Bukkit.getWorlds().get(0)).getHandle()));
        
        Location loc = p.getLocation() ;
        Location card = Cardinal.getCardinal(p).blockBehind(loc, 1) ;
        
        sp.npc.setLocation(card.getX(),card.getY() + 3,card.getZ(),card.getYaw(), card.getPitch());
        
        sp.npc.setSneaking(true);
        sp.npc.setInvisible(true);
        
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, sp.npc));
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(sp.npc));
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, sp.npc));
	
        new BukkitRunnable() {
            public void run() {

                connection.sendPacket(new PacketPlayOutEntityDestroy(sp.npc.getId()));
                connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, sp.npc));
                sp.npc = null ;
                
            }
        }.runTaskLater(Bukkit.getPluginManager().getPlugin("Spider"), 200);
        
	}
	
}
