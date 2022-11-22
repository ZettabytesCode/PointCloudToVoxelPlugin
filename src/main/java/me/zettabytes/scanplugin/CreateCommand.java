package me.zettabytes.scanplugin;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class CreateCommand {
//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//        if(sender instanceof Player){
//            int bottomY = Integer.parseInt(args[0]);
//            Player player = (Player) sender;
//            Location playerLoc = player.getLocation();
//            int xLoc = playerLoc.getBlockX();
//            int zLoc = playerLoc.getBlockZ();
//
//            createScan(xLoc, zLoc, bottomY, player.getWorld(), player);
//        }
//        return false;
//    }
//
//    private void createScan(int xLoc, int zLoc, int bottomY, World world, Player player) {
//        for(int i = xLoc - 20; i < xLoc + 20; i++){
//            for(int j = bottomY; j < 40 + bottomY; j++){
//                for(int k = zLoc - 20; k < zLoc + 20; k++){
//                    Block block = world.getBlockAt(i, j, k);
//                    player.sendMessage(i + " "+ j+ " "+k);
////                    block.setType(Material.STONE);
//                    boolean value = testBlock(block, xLoc, bottomY, zLoc);
//                    player.sendMessage(String.valueOf(value));
//                    if(value){
//                        block.setType(Material.STONE);
//                    }
//                }
//            }
//        }
//    }
//
//    private boolean testBlock(Block block, int x, int y, int z) {
//        ArrayList<Vertex> blockVertices = new ArrayList<>();
//        for(int i = 0; i < 2; i++){
//            for(int j = 0; j < 2; j++){
//                for(int k = 0; k < 2; k++){
//                    blockVertices.add(new Vertex(block.getX() + i, block.getY() + j, block.getZ() + k ));
//                }
//            }
//        }
//
//        for(Face f : ScanPlugin.faceArray){
//            System.out.println(f.vertex1.x);
//            if(checkIntersecting(f, blockVertices, x, y, z)){
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    private boolean checkIntersecting(Face f, ArrayList<Vertex> blockVertices, int x, int y, int z) {
////        System.out.println(f.vertex1.x + x);
//        Vector v1 = new Vector(f.vertex2.x + x, f.vertex2.y + y, f.vertex2.z + z);
//        Vector v0 = new Vector(f.vertex1.x + x, f.vertex1.y + y, f.vertex1.z + z);
//        Vector v2 = new Vector(f.vertex3.x + x, f.vertex3.y + y, f.vertex3.z + z);
//
//        Vector c = getCenter(blockVertices);
//        Vector e = new Vector (0.5, 0.5, 0.5);
//
//        v0 = v0.add(c.multiply(-1));
//        v1 = v1.add(c.multiply(-1));
//        v2 = v2.add(c.multiply(-1));
//
//        Vector f1 = v1.add(v0.multiply(-1));
//        Vector f2 = v2.add(v1.multiply(-1));
//        Vector f0 = v0.add(v2.multiply(-1));
//
//        Vector u0 = new Vector(1.0f, 0.0f, 0.0f);
//        Vector u1 = new Vector(0.0f, 1.0f, 0.0f);
//        Vector u2 = new Vector(0.0f, 0.0f, 1.0f);
//
//        Vector axis_u0_f0 = u0.crossProduct(f0);
//        Vector axis_u0_f1 = u0.crossProduct(f1);
//        Vector axis_u0_f2 = u0.crossProduct(f2);
//
//        Vector axis_u1_f0 = u1.crossProduct(f0);
//        Vector axis_u1_f1 = u1.crossProduct(f1);
//        Vector axis_u1_f2 = u2.crossProduct(f2);
//
//        Vector axis_u2_f0 = u2.crossProduct(f0);
//        Vector axis_u2_f1 = u2.crossProduct(f1);
//        Vector axis_u2_f2 = u2.crossProduct(f2);
//
//        if(checkAxis(v0, v1, v2, axis_u0_f0, e, u0, u1, u2)){
//            System.out.printf("a");
//            return false;
//        }
//        if(checkAxis(v0, v1, v2, axis_u0_f1, e, u0, u1, u2)){
//            System.out.printf("b");
//            return false;
//        }
//        if(checkAxis(v0, v1, v2, axis_u0_f2, e, u0, u1, u2)){
//            System.out.printf("c");
//            return false;
//        }
//        if(checkAxis(v0, v1, v2, axis_u1_f0, e, u0, u1, u2)){
//            System.out.println("d");
//            return false;
//        }
//        if(checkAxis(v0, v1, v2, axis_u1_f1, e, u0, u1, u2)){
//            System.out.printf("e");
//            return false;
//        }
//        if(checkAxis(v0, v1, v2, axis_u1_f2, e, u0, u1, u2)){
//            System.out.printf("f");
//            return false;
//        }
//        if(checkAxis(v0, v1, v2, axis_u2_f0, e, u0, u1, u2)){
//            System.out.printf("g");
//            return false;
//        }
//        if(checkAxis(v0, v1, v2, axis_u2_f1, e, u0, u1, u2)){
//            System.out.printf("h");
//            return false;
//        }
//        if(checkAxis(v0, v1, v2, axis_u2_f2, e, u0, u1, u2)){
//            System.out.printf("i");
//            return false;
//        }
//
//        if(checkAxis(v0, v1, v2, new Vector(1,0,0), e, u0, u1, u2)){
//            System.out.printf("j");
//            return false;
//        }
//        if(checkAxis(v0, v1, v2, new Vector(0,1,0), e, u0, u1, u2)){
//            System.out.printf("k");
//            return false;
//        }
//        if(checkAxis(v0, v1, v2, new Vector(0,0,1), e, u0, u1, u2)){
//            System.out.printf("l");
//            return false;
//        }
//
//        if(checkAxis(v0, v1, v2, f0.crossProduct(f1), e, u0, u1, u2)){
//            System.out.printf("m");
//            return false;
//        }
//
//        return true;
//    }
//
//    private boolean checkAxis(Vector v0, Vector v1, Vector v2, Vector axis, Vector e, Vector u0, Vector u1, Vector u2) {
//        double p0 = v0.dot(axis);
//        double p1 = v1.dot(axis);
//        double p2 = v2.dot(axis);
//
//        double r = e.getX() * Math.abs(u0.dot(axis)) +
//                e.getY() * Math.abs(u1.dot(axis)) +
//                e.getZ() * Math.abs(u2.dot(axis));
//
//        return (Math.max(-1 * Math.max(Math.max(p0, p1), p2), Math.min(Math.min(p0, p1), p2)) > r);
//
//    }
//
//    private Vector getCenter(ArrayList<Vertex> vertices){
//        double x = 0,y = 0,z = 0;
//        for (Vertex v: vertices){
//            x+= v.x;
//            y+= v.y;
//            z+= v.z;
//        }
//        return new Vector(x/8.0, y/8.0, z/8.0);
//    }
}
