package spider;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class SpiderPlayer {
	
	private Player player ;
	private Location lastLocation ;
	
	public int nbPacket = 0 ;
	public int deplaceBlock = 0 ;
	public int jumping = 0 ;
	public int prendDegats = 0;
	public int feedNbItemInHand = 0 ;
	public Material feedLastMaterialInHand = null ;
	public String kickRaison = "";
	
	ArrayList<String> cheatDetect = new ArrayList<String>() ;
	public int nbCheatDetect = 0 ;
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
	public int knockback = 0;
	public int timer = 0;
	public int positionLook = 0;
	public int antiCactus = 0;
	public int dolphine = 0;
	public int autoSteal = 0;
	public int fastEat = 0;
	public int join = 0;
	public int fastPlace = 0;
	public int freecam = 0;
	public int blink = 0;
	public int spider = 0;
	
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
