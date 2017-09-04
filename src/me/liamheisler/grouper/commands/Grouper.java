package me.liamheisler.grouper.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Grouper implements CommandExecutor {
	
	public ArrayList<Player> admins = new ArrayList<Player>();
	public ArrayList<Player> moderators = new ArrayList<Player>();
	public ArrayList<Player> members = new ArrayList<Player>();
	//public String assignedGroup; 
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("group")) {
			if(args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Proper syntax: /group <name> <group>");
				sender.sendMessage(ChatColor.RED + "Possible groups: admins, moderators, members");
				return true;
			}
			else if(args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				if(args[1].equalsIgnoreCase("admin")) {
					admins.add(target); 
					sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.BLUE + "Grouper"
							+ ChatColor.GRAY + "]" + ChatColor.AQUA + " You've made "
							+ ChatColor.RED + target.getName() + ChatColor.AQUA + " an admin!"); 
					target.sendMessage(ChatColor.GRAY + "[" + ChatColor.BLUE + "Grouper"
							+ ChatColor.GRAY + "]" + ChatColor.AQUA + " You've been made an admin"
							+ " by " + ChatColor.RED + sender.getName() + ChatColor.AQUA + "!");
				}
				else if(args[1].equalsIgnoreCase("moderator")) {
					moderators.add(target); 
					sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.BLUE + "Grouper"
							+ ChatColor.GRAY + "]" + ChatColor.AQUA + " You've made "
							+ ChatColor.RED + target.getName() + ChatColor.AQUA + " a moderator!"); 
					target.sendMessage(ChatColor.GRAY + "[" + ChatColor.BLUE + "Grouper"
							+ ChatColor.GRAY + "]" + ChatColor.AQUA + " You've been made a moderator"
							+ " by " + ChatColor.RED + sender.getName() + ChatColor.AQUA + "!"); 
				}
				else if(args[1].equalsIgnoreCase("members")) {
					members.add(target); 
					sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.BLUE + "Grouper"
							+ ChatColor.GRAY + "]" + ChatColor.AQUA + " You've made "
							+ ChatColor.RED + target.getName() + ChatColor.AQUA + " a member!"); 
					target.sendMessage(ChatColor.GRAY + "[" + ChatColor.BLUE + "Grouper"
							+ ChatColor.GRAY + "]" + ChatColor.AQUA + " You've been made a member"
							+ " by " + ChatColor.RED + sender.getName() + ChatColor.AQUA + "!"); 
				} else {
					sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.BLUE + "Grouper"
							+ ChatColor.GRAY + "]" + ChatColor.AQUA + " Something went wrong!"); 
				}
			}
		}
		return false;
	}
	
	public ArrayList<Player> getAdmins() {
		return admins;
	}
	public ArrayList<Player> getModerators() {
		return moderators;
	}
	public ArrayList<Player> getMembers() {
		return members;
	}
}