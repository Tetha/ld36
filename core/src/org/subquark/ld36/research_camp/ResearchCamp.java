package org.subquark.ld36.research_camp;

public class ResearchCamp {
    public static final float COOLDOWN = 5000;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    
    public static final int MINING_RANGE_RADIUS = 20;
    
    public static final float POWER_FOR_ONE_WORKER = 1;
    
    public static final float SECONDS_PER_RESEARCH = 5;
    public static final float MONEY_PER_RESEARCH = 1;
    
    public int x;
    public int y;
    
    public float workerPower;
    
    public float researchProgress;
    public int researchTicksForThisArtifact;
    public boolean hasArtifact;
}
