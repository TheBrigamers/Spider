package be.brigamers.punishement;

import java.util.Date;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor {
	
	long duree ;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		//Si c'est un joueur
		if(!(sender instanceof Player)) return false;
		
		//Definition
		Player p = (Player) sender ;
		
		//Si il a la permission
		if(p.hasPermission("salviaModeration.ban")){
			
			//Si + de 2 arguments
			if(args.length >= 3){
				
				//Joueur cible
				Player pCible = Bukkit.getPlayer(args[0]) ;
				if(pCible == null){
					p.sendMessage("Le joueur n'est pas en ligne ou n'existe pas.");
					return false ;
				}
				
				//Raison
				String raisonMul = "" ;
				for(int i=2;i<args.length;i++){
					raisonMul += args[i] + " " ;
				}
				final String raison = raisonMul.substring(0, raisonMul.length()-1) ;
				
				//Si ban def
				if(args[1].equalsIgnoreCase("DEF") || args[1].equalsIgnoreCase("DEFINITIF")){
					Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(pCible.getName(), raison, null, p.getName()) ;
					Bukkit.broadcastMessage(ChatColor.AQUA + pCible.getName() + ChatColor.GRAY + " a été banni définitivement par " + p.getName() + " pour " + ChatColor.AQUA + raison + ChatColor.GRAY + ".") ;
					pCible.kickPlayer(ChatColor.AQUA + "vous" + ChatColor.DARK_GRAY + " avez été banni définitivement par " + ChatColor.AQUA + p.getName() + ChatColor.DARK_GRAY + " pour " + ChatColor.AQUA + raison + ChatColor.DARK_GRAY + ".");
				}else{
					//Si durré valide
					if(!TimeUtils.isDuree(args[1])){
						p.sendMessage(ChatColor.RED + "Durée invalide. [0-99][sdhm]");
						return false;
					}
					//ban temporaire
					long dureeBan = TimeUtils.stringToTime(args[1]) + System.currentTimeMillis() ;
					Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(pCible.getName(), raison, new Date(dureeBan), p.getName()) ;
					Bukkit.broadcastMessage(ChatColor.AQUA + pCible.getName() + ChatColor.DARK_GRAY + " a été banni temporairement par " + ChatColor.AQUA + p.getName() + ChatColor.DARK_GRAY + " pour " + ChatColor.AQUA + raison + ChatColor.DARK_GRAY + ".") ;
					pCible.kickPlayer(ChatColor.AQUA + "vous" + ChatColor.DARK_GRAY + " avez été banni temporairement par " + ChatColor.AQUA + p.getName() + ChatColor.DARK_GRAY + " pour " + ChatColor.AQUA + raison + ChatColor.DARK_GRAY + ".");
				}
			}else{
				p.sendMessage(ChatColor.RED + "/ban <temps> <joueur> <raison>");
			}
		}else{
			p.sendMessage(ChatColor.RED + "Vous n'avez pas la permission.");
			return false ;
		}

		return false;
	}

}
