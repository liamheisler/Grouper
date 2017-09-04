package me.liamheisler.grouper.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.liamheisler.grouper.events.ChatFormatEvent;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getLogger().info("Grouper enabled.");
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new ChatFormatEvent(), this);
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Grouper disabled.");
	}
}
