package org.subquark.ld36;

import java.util.ArrayList;
import java.util.List;

import org.subquark.ld36.camp.Camp;
import org.subquark.ld36.digsite.DigSite;
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
    public int money;
    
    public int unresearchedArtifacts() {
        return artifacts - researchedArtifacts;
    }
}