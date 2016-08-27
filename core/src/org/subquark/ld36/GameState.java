package org.subquark.ld36;

import java.util.ArrayList;
import java.util.List;

import org.subquark.ld36.camp.Camp;
import org.subquark.ld36.digsite.DigSite;
import org.subquark.ld36.level.Level;
import org.subquark.ld36.scanner.Scanner;
import org.subquark.ld36.workers.Worker;

public class GameState {
    public Level level;
    public List<Worker> workers = new ArrayList<Worker>();
    public List<Camp> camps = new ArrayList<Camp>();
    public List<Scanner> scanners = new ArrayList<Scanner>();
    public List<DigSite> digSites = new ArrayList<DigSite>();
}