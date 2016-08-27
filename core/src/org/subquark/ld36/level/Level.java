package org.subquark.ld36.level;

import java.util.Random;

public class Level {
    private final float treasureThreshold;
    
    private float[][] noiseMap;
    private boolean[][] isScanned;
    
    public Level(int width, int height, float[][] noiseMap, float treasureThreshold) {
        this.noiseMap = noiseMap;
        this.isScanned = new boolean[width][height];
        this.treasureThreshold = treasureThreshold;
    }
    
    public boolean hasVisibleTreasure(int x, int y) {
        if (isScanned[x][y]) {
            return noiseMap[x][y] > treasureThreshold;
        } else {
            return false;
        }
    }
    
    public static Level newLevel(Random r, int width, int height, float treasureThreshold) {
        float[][] whiteNoise = PerlinNoise.generateWhiteNoise(r, 60, 50);
        float[][] noiseMap = PerlinNoise.generatePerlinNoise(whiteNoise, 4);
        return new Level(width, height, noiseMap, treasureThreshold);
    }
}
