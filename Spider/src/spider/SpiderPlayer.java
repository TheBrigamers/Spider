package spider;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SpiderPlayer {
	
	private Player player ;
	private Location lastLocation ;
	
	public int deplaceBlock = 0 ;
	
	public int armAnimationPacket = 0 ;
	public int NaturalRegen = 0 ;
	public int projectile = 0 ;
	public int jesus = 0 ;
	public int speedHack = 0 ;
	public int nuker = 0 ;
	public int critials = 0 ;
	public int noFall = 0 ;
	public int noWeb = 0 ;
	public int sneak = 0 ;
	public int fly = 0;
	public int glide = 0;
	
	public SpiderPlayer(Player player){
		this.player = player ;
	}
	
	public Location getLastLocation(){
		return lastLocation ;
	}
	
	public Location setLastLocation(Location lastLocation){
		this.lastLocation = lastLocation;
		return lastLocation ;
	}
	
	public Player getPlayer(){
		return player ;
	}
	
}
