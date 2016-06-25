package be.brigamers.cheat;

import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.mojang.authlib.GameProfile;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.minecraft.server.v1_8_R3.PlayerInteractManager;
import net.minecraft.server.v1_8_R3.WorldServer;

public class Tracer {

	public Tracer(Player p){
		MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer nmsWorld = ((CraftWorld) Bukkit.getWorlds().get(0)).getHandle();
        final EntityPlayer npc = new EntityPlayer(nmsServer, nmsWorld, new GameProfile(UUID.randomUUID(), ChatColor.RED + newName()), new PlayerInteractManager(nmsWorld));

        
        PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;

        npc.setLocation(p.getLocation().getX() + randomNombre(100,250), p.getLocation().getY() + randomNombre(1,20), p.getLocation().getZ() + randomNombre(100,250), 0.0F, 0.0F);
        
        npc.setSneaking(true);

        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));
        new BukkitRunnable() {
            public void run() {
                PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;

                connection.sendPacket(new PacketPlayOutEntityDestroy(npc.getId()));
                connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));

            }
        }.runTaskLater(Bukkit.getPluginManager().getPlugin("Spider"), 40);
	
	}
	 
    public static String newName() {
        int size = 3 + new Random().nextInt(2);
        return RandomStringUtils.randomAlphabetic(size);
    }
    
    public int randomNombre(int min, int max){
    	int aleatoire ;
    	if(Math.random() < 0.5){
    		aleatoire = min + (int)(Math.random() * ((max - min) + 1));
    	}else{
    		aleatoire = -min + (int)(Math.random() * ((-max - -min) + 1));
    	}
    	
    	return aleatoire ;
    }
	
}
