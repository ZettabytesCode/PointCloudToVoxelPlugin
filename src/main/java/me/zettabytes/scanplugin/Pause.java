package me.zettabytes.scanplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;

import java.util.List;

public class Pause implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Bukkit.getPluginManager().disablePlugin(ScanPlugin.instance);
            Bukkit.getPluginManager().enablePlugin(ScanPlugin.instance);
        }
        return false;
    }
}
