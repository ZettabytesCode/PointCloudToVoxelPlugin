package me.zettabytes.scanplugin;

import java.util.ArrayList;

public class Face {

    public Vertex vertex1, vertex2, vertex3;
    public double maxX, maxY, maxZ, minX, minY, minZ;
    public ArrayList<Vertex> vertexArrayList = new ArrayList<>();

    public Face( Vertex vertex1, Vertex vertex2, Vertex vertex3){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;

        vertexArrayList.add(vertex1);
        vertexArrayList.add(vertex2);
        vertexArrayList.add(vertex3);

        maxX = Math.max(Math.max(vertex1.x, vertex2.x), vertex3.x);
        maxY = Math.max(Math.max(vertex1.y, vertex2.y), vertex3.y);
        maxZ = Math.max(Math.max(vertex1.z, vertex2.z), vertex3.z);

        minX = Math.min(Math.min(vertex1.x, vertex2.x), vertex3.x);
        minY = Math.min(Math.min(vertex1.y, vertex2.y), vertex3.y);
        minZ = Math.min(Math.min(vertex1.z, vertex2.z), vertex3.z);


    }

    @Override
    public String toString() {
        return "Face{" +
                "vertex1=" + vertex1 +
                ", vertex2=" + vertex2 +
                ", vertex3=" + vertex3 +
                ", maxX=" + maxX +
                ", maxY=" + maxY +
                ", maxZ=" + maxZ +
                ", minX=" + minX +
                ", minY=" + minY +
                ", minZ=" + minZ +
                '}';
    }
}
