package org.subquark.ld36.level;

import java.util.Random;

import org.subquark.ld36.goals.TreasureDensity;

public class Level {
    public static final int TILE_PIXELS = 10;
    public static final int WIDTH_TILES = 50;
    public static final int HEIGHT_TILES = 45;
    
    public final float treasureThreshold;
    
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
    
    public float getRawNoiseAt(int x, int y) {
        return noiseMap[x][y];
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
    
    public static Level newLevel(Random r, int width, int height, TreasureDensity density) {
        float[][] whiteNoise = PerlinNoise.generateWhiteNoise(r, 60, 50);
        float[][] noiseMap = PerlinNoise.generatePerlinNoise(whiteNoise, density.persistence,  density.octaves);
        return new Level(width, height, noiseMap, density.treasureThreshold);
    }

}
