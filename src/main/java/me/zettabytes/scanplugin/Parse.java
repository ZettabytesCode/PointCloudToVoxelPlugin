package me.zettabytes.scanplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.*;
import java.util.ArrayList;

public class Parse implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            String file = args[0];
            int parseType = 0;
            try {
                parseType = Integer.parseInt(args[1]);
            }catch (Exception ignored){

            }
            try {
                String data = loadData(file);
                ArrayList<Vertex> points = parse(data, parseType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private ArrayList<Vertex> parse(String data, int parseType) {
        String[] splitted = data.split("\n");
        ArrayList<Vertex> vertexArrayList = new ArrayList<>();
        boolean runFlag = false;
        for (int i = 0; i < splitted.length; i++) {
//            System.out.println(splitted[i]);
            String[] lineData = splitted[i].split(" ");
            if(parseType == 0) {
                if (lineData[0].equals("v")) {
                    vertexArrayList.add(new Vertex(Double.parseDouble(lineData[1]) * 20, Double.parseDouble(lineData[2]) * 20, Double.parseDouble(lineData[3]) * 20, 0, 0, 0));
                }
            }else if(parseType == 1){
                if(splitted[0].equals("end_header")){
                    runFlag = true;
                }else if(runFlag){
                    vertexArrayList.add(new Vertex(Double.parseDouble(lineData[0]) * 20, Double.parseDouble(lineData[1]) * 20, Double.parseDouble(lineData[2]) * 20, Integer.parseInt(lineData[6]), Integer.parseInt(lineData[7]), Integer.parseInt(lineData[8])));
                }
            }
        }
        return vertexArrayList;
    }

    private String loadData(String fileName) throws IOException {
        File file = new File("C:\\Users\\Varun\\Desktop\\" + fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));

        int counter = 0;
        String output = "";
        String st;
        while ((st = br.readLine()) != null) {
            if(counter == 0){
                output += st;
                counter++;
            }else{
                output += "\n" + st;
            }
        }
        return output;
    }


}
