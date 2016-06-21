package be.brigamers.command;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RandomTp implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(!(sender instanceof Player)) return false;
		
		Player p = (Player) sender ;
		
		if(!p.hasPermission("spider.randomTp")) return false;
		
		int max = Bukkit.getOnlinePlayers().size() ;
		int min = 0 ;
		int nombreAleatoire = new Random().nextInt(max - min + 1) + min;
		
		p.sendMessage(nombreAleatoire + "");

		return false;
	}

}
