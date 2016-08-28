package org.subquark.ld36;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.subquark.ld36.camp.Camp;
import org.subquark.ld36.digsite.DigSite;
import org.subquark.ld36.goals.TreasureDensity;
import org.subquark.ld36.level.Level;
import org.subquark.ld36.research_camp.ResearchCamp;
import org.subquark.ld36.scanner.Scanner;
import org.subquark.ld36.workers.Worker;

public class GameState {
    public Level level;
    public List<Worker> workers = new ArrayList<Worker>();
    public List<Camp> camps = new ArrayList<Camp>();
    public List<Scanner> scanners = new ArrayList<Scanner>();
    public List<DigSite> digSites = new ArrayList<DigSite>();
    public List<ResearchCamp> researchCamps = new ArrayList<ResearchCamp>();
    
    public int artifacts = 0;
    public int researchedArtifacts = 0;
    public boolean debugging;
    
    public int artifactsRequired;
    public float timeLimit;
    public float timeSpent;
    
    public int unresearchedArtifacts() {
        return artifacts - researchedArtifacts;
    }

    public float remainingTime() {
        return timeLimit - timeSpent;
    }
    
    public void reset(Random levelGenRandom, TreasureDensity treasureDensity, int artifactsRequired, int timeLimit) {
        level = Level.newLevel(levelGenRandom,
                               Level.WIDTH_TILES, Level.HEIGHT_TILES,
                               treasureDensity);

        workers.clear();
        camps.clear();
        scanners.clear();
        digSites.clear();
        researchCamps.clear();
        
        artifacts = 0;
        researchedArtifacts = 0;
        debugging = false;
        
        this.artifactsRequired = artifactsRequired;
        this.timeLimit = timeLimit;
        this.timeSpent = 0;
    }
}