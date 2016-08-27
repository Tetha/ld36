package org.subquark.ld36.level;

import java.util.Random;

public class Level {
    public static final int TILE_PIXELS = 10;

    private final float treasureThreshold;
    
    private final int width;
    private final int height;
    
    private float[][] noiseMap;
    private boolean[][] isScanned;
    
    public Level(int width, int height, float[][] noiseMap, float treasureThreshold) {
        this.width = width;
        this.height = height;
        this.noiseMap = noiseMap;
        this.isScanned = new boolean[width][height];
        this.treasureThreshold = treasureThreshold;
    }
    
    public boolean hasVisibleTreasure(int x, int y) {
        if (wasScanned(x, y)) {
            return noiseMap[x][y] > treasureThreshold;
        } else {
            return false;
        }
    }
    
    public boolean wasScanned(int x, int y) {
        return isScanned[x][y];
    }

    public void markScanned(int x, int y) {
        if (0 <= x && x < width) {
            if (0 <= y && y < height) {
                isScanned[x][y] = true;
            }
        }
    }
    
    public static Level newLevel(Random r, int width, int height, float treasureThreshold) {
        float[][] whiteNoise = PerlinNoise.generateWhiteNoise(r, 60, 50);
        float[][] noiseMap = PerlinNoise.generatePerlinNoise(whiteNoise, 4);
        return new Level(width, height, noiseMap, treasureThreshold);
    }

}
