package be.brigamers.punishement;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class muteCommand implements CommandExecutor, Listener {

	public ArrayList<Player> playerMute = new ArrayList<Player>() ;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) return false ;
		
		Player p = (Player) sender; 
		
		if(!p.hasPermission("salviaModeration.mute")){
			p.sendMessage(ChatColor.RED + "Vous n'avez pas la permission.");
			return false ;
		}
		
		if(!(args.length >= 2)){
			p.sendMessage(ChatColor.RED + "/mute <pseudo> <raison>");
			return false ;
		}
		Player pCible = Bukkit.getPlayer(args[0]) ;
		if(pCible == null){
			p.sendMessage(ChatColor.RED + "Le joueur n'est pas en ligne ou n'existe pas.");
			return false ;
		}
		
		String raison = "" ;
		for(int i=1;i<args.length;i++){
			raison += args[i] + " " ;
		}
		raison = raison.substring(0, raison.length()-1) ;
		
		playerMute.add(pCible) ;
		Bukkit.broadcastMessage(ChatColor.AQUA + pCible.getName() + ChatColor.GRAY + " a été mute par " + p.getName() + " pour " + ChatColor.AQUA + raison + ChatColor.GRAY + ".") ;
		
		return false;
	}
	
	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent e){
		for(Player player : playerMute){
			Bukkit.broadcastMessage(player.getName()) ;
		}
		if(playerMute.contains(e.getPlayer())){
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.RED + "Vous êtes mute");
		}
	}

}
