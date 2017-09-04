package me.liamheisler.grouper.events;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.liamheisler.grouper.commands.Grouper;

public class ChatFormatEvent implements Listener {
	
	/*private Grouper grouper = new Grouper();
	private ArrayList<Player> admins = grouper.getAdmins();
	private ArrayList<Player> moderators = grouper.getModerators();
	private ArrayList<Player> members = grouper.getMembers(); */
	
	//»
	@EventHandler
	public void formatChat(AsyncPlayerChatEvent e) {
		//e.getFormat();
		Player p = e.getPlayer();
		
		if(p.hasPermission("chat.format.member") && !p.isOp()) { 
			e.setFormat(ChatColor.GRAY + "MEMBER" + ChatColor.DARK_GRAY + " | "
					+ ChatColor.GRAY + p.getDisplayName() + ChatColor.DARK_GRAY + " » "
					+ ChatColor.WHITE + e.getMessage());
		}
		else if(p.hasPermission("chat.format.moderator") && !p.isOp()) {
			e.setFormat(ChatColor.DARK_PURPLE + "MODERATOR" + ChatColor.DARK_GRAY + " | "
					+ ChatColor.DARK_PURPLE + p.getDisplayName() + ChatColor.DARK_GRAY + " » "
					+ ChatColor.WHITE + e.getMessage());
		}
		else if(p.hasPermission("chat.format.admin") && !p.isOp()) {
			e.setFormat(ChatColor.RED + "ADMIN" + ChatColor.DARK_GRAY + " | "
					+ ChatColor.RED + p.getDisplayName() + ChatColor.DARK_GRAY + " » "
					+ ChatColor.WHITE + e.getMessage()); 
		}
		else if(p.isOp()) {
			e.setFormat(ChatColor.DARK_RED + "OP" + ChatColor.DARK_GRAY + " | "
					+ ChatColor.DARK_RED + p.getDisplayName() + ChatColor.DARK_GRAY + " » "
					+ ChatColor.WHITE + ChatColor.ITALIC + e.getMessage());
		}
		
		/*for(Player player : members) {
			e.setFormat(ChatColor.GRAY + "MEMBER" + ChatColor.DARK_GRAY + " | "
					+ ChatColor.GRAY + player.getDisplayName() + ChatColor.DARK_GRAY + " » "
					+ e.getMessage());
		}
		for(Player player : moderators) {
			e.setFormat(ChatColor.DARK_PURPLE + "MODERATOR" + ChatColor.DARK_GRAY + " | "
					+ ChatColor.DARK_PURPLE + player.getDisplayName() + ChatColor.DARK_GRAY + " » "
					+ e.getMessage());
		}
		for(Player player : admins) {
			e.setFormat(ChatColor.RED + "ADMIN" + ChatColor.DARK_GRAY + " | "
					+ ChatColor.RED + player.getDisplayName() + ChatColor.DARK_GRAY + " » "
					+ e.getMessage()); */
		}
}
