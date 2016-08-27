package org.subquark.ld36.digsite;

import org.subquark.ld36.level.Level;

public class DigSite {
    public static final float COOLDOWN = 5000;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    
    public static final int MINING_RANGE_RADIUS = 20;
    
    public static final float POWER_FOR_ONE_WORKER = 1;
    public static final float SECONDS_PER_PAYOUT = 2; 
    
    public int x;
    public int y;
    
    public float workerPower;
    
    public float depthMined;
    
    public int smallestXMinedTiles() {
        return smallestXMinedPixels() / Level.TILE_PIXELS;
    }
    
    public int smallestXMinedPixels() {
        return x - WIDTH / 2 - MINING_RANGE_RADIUS;
    }
    
    public int smallestYMinedTiles() {
        return smallestYMinedPixels() / Level.TILE_PIXELS;
    }
    
    public int smallestYMinedPixels() {
        return y - HEIGHT / 2 - MINING_RANGE_RADIUS;
    }
    
    public int totalMiningDiameterHorizontallyTiles() {
        return totalMiningDiameterHorizontallyPixels() / Level.TILE_PIXELS;
    }
    
    public int totalMiningDiameterVerticallyTiles() {
        return totalMiningDiameterVerticallyPixels() / Level.TILE_PIXELS;
    }
    
    public int totalMiningDiameterHorizontallyPixels() {
        return 2 * MINING_RANGE_RADIUS + WIDTH;
    }
    
    public int totalMiningDiameterVerticallyPixels() {
        return 2 * MINING_RANGE_RADIUS + WIDTH;
    }
}
