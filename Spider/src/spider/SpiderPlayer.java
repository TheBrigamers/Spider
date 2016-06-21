package spider;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SpiderPlayer {
	
	private Player player ;
	private Location lastLocation ;
	
	public int packets = 0 ;
	public int flyingPacket = 0 ;
	public int positionPacket = 0;
	public int positionLookPacket = 0;
	public int lookPacket = 0;
	public int armAnimationPacket = 0;
	public int NaturalRegen = 0;
	public int projectile = 0;
	public int abilitiesPacket = 0;
	public int jesus = 0;
	public int forcefield = 0;
	public int highJump = 0;
	public int fly = 0;
	public int speedHack = 0;
	public int nuker = 0;
	public int critials = 0;
	public int closeWindow = 0;
	public int chat = 0;
	public int windowClick = 0;
	public int noFall = 0;
	
	public int regenViolation = 0 ;
	public int fastBowViolation = 0 ;
	public int antiPotionViolation = 0;
	public int noFallViolation = 0;
	public int autoClickViolation = 0;
	public int flyVanillaViolation = 0;
	public int jesusViolation = 0;
	public int highJumpViolation = 0;
	public int flyViolation = 0;
	public int speedHackViolation = 0 ;
	public int nukerViolation = 0 ;
	public int critialsViolation = 0;
	public int forcefieldViolation = 0;
	
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
