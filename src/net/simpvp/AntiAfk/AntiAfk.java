package net.simpvp.AntiAfk;

import java.util.List;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

public class AntiAfk extends JavaPlugin {
	
	public static JavaPlugin instance;
	
	static GetTps gettps = new GetTps();
	static Double min_tps;
	static Integer afk_secs;
	static List<?> kick_players;
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		instance = this;
		min_tps = AntiAfk.instance.getConfig().getDouble("Minimum_tps");	
		afk_secs = AntiAfk.instance.getConfig().getInt("Afk_seconds");
		kick_players = AntiAfk.instance.getConfig().getStringList("Kick_players").stream().map(UUID::fromString).collect(java.util.stream.Collectors.toList());
		gettps.variables();	
		GetAfkPlayers.setPlayersAfk();
		getServer().getPluginManager().registerEvents(new EventListener(), this);
	}
}
