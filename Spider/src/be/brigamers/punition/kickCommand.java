package be.brigamers.punition;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class kickCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) return false ;
		
		Player p = (Player) sender ;
		
		if(!p.hasPermission("salviaModeration.kick")){
			p.sendMessage(ChatColor.RED + "Vous n'avez pas la permission.");
			return false ;
		}
		
		if(!(args.length >= 2)){
			p.sendMessage(ChatColor.RED + "/kick <pseudo> <raison>");
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
		
		pCible.kickPlayer(ChatColor.GOLD + "vous avez été kick par " + ChatColor.DARK_RED + p.getName() + ChatColor.GOLD + " pour " + ChatColor.DARK_RED + raison + ChatColor.GOLD + ".");
		Bukkit.broadcastMessage(ChatColor.AQUA + pCible.getName() + ChatColor.GRAY + " a été kick par " + p.getName() + " pour " + ChatColor.AQUA + raison + ChatColor.GRAY + ".") ;
		
		return false;
	}

}
