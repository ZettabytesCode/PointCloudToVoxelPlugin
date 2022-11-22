package me.zettabytes.scanplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.material.TexturedMaterial;

import java.awt.image.BufferedImage;


public class Create3 implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            int bottomY = Integer.parseInt(args[0]);
            Player player = (Player) sender;
            Location playerLoc = player.getLocation();
            int xLoc = playerLoc.getBlockX();
            int zLoc = playerLoc.getBlockZ();
            System.out.println(inBetween(2, 1, 3));

            createScan(xLoc, zLoc, bottomY, player.getWorld(), player);
        }

        return false;
    }

    private void createScan(int xLoc, int zLoc, int bottomY, World world, Player player) {
        for(Vertex v : ScanPlugin.points){
            Block block = world.getBlockAt((int)(v.x + xLoc), (int)(v.y + bottomY), (int)(v.z + zLoc));
            String materialName = getMaterialColor(v.r, v.g, v.b);
            block.setType(getMaterialFromName(materialName));
            if(getDataFromName(materialName) != -1){
                block.setData(getDataFromName(materialName));
            }
        }
    }

    private String getMaterialColor(int r, int b, int g) {
        if(r == 0 && b == 0 && g == 0){
            return "stone";
        }else{
            BufferedImage image = null;
            return null;

        }
    }

    private Material getMaterialFromName(String name){
        return null;
    }

    private byte getDataFromName(String name){
        return 0;
    }

    private boolean inBetween(double val, int start, int end){
        return(val <= end && val >= start);
    }
}
