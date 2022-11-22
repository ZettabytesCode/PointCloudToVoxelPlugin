package me.zettabytes.scanplugin;

import java.io.*;
import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

public final class ScanPlugin extends JavaPlugin {

    public static ScanPlugin instance;
    public static ArrayList<Vertex> points;

    @Override
    public void onEnable() {
        System.out.println("scan plugin start");
        instance = this;
        getCommand("scan").setExecutor(new Create3());
        getCommand("parse").setExecutor(new Parse());

    }


    @Override
    public void onDisable() {
        System.out.println("scan plugin close");
    }

}
