package org.subquark.ld36.goals;

public enum TreasureDensity {
    LOTS(0.1f, 2, 0.75f),
    SOME(0.3f, 4, 0.8f),
    NONE(0.8f, 5, 0.90f);
    
    public final float persistence;
    public final int octaves;
    public final float treasureThreshold;
    
    private TreasureDensity(float persistence, int octaves, float treasureThreshold) {
        this.persistence = persistence;
        this.octaves = octaves;
        this.treasureThreshold = treasureThreshold;
    }
    
}
