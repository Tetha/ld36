package org.subquark.ld36.workers;

import java.util.Iterator;

import org.subquark.ld36.GameState;
import org.subquark.ld36.camp.Camp;
import org.subquark.ld36.digsite.DigSite;
import org.subquark.ld36.research_camp.ResearchCamp;
import org.subquark.ld36.scanner.Scanner;

import com.badlogic.gdx.Gdx;

public class WorkerUpdater {
    private final GameState gameState;
    
    public WorkerUpdater(GameState gameState) {
        this.gameState = gameState;
    }
    
    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        
        boolean removedAlready = false;
        Iterator<Worker> wIter = gameState.workers.iterator();
        while (wIter.hasNext()) {
            Worker w = wIter.next();
            w.lifetimeLeft -= deltaTime;
            if (w.lifetimeLeft <= 0) {
                if(!removedAlready) {
                    wIter.remove();
                    removedAlready = true;
                }
            }
            
            w.x += w.velocityX * deltaTime;
            w.y += w.velocityY * deltaTime;
            
            for (Camp c : gameState.camps) {
                if (c.x - Camp.CAMP_WIDTH / 2 <= w.x - Worker.WORKER_DIAMETER && w.x - Worker.WORKER_DIAMETER <= c.x + Camp.CAMP_WIDTH / 2) {
                    if (c.y - Camp.CAMP_HEIGHT / 2 <= w.y - Worker.WORKER_DIAMETER && w.y - Worker.WORKER_DIAMETER <= c.y + Camp.CAMP_HEIGHT / 2) {
                        if(!removedAlready) {
                            wIter.remove();
                            removedAlready = true;
                        }
                    }
                }
            }
            
            for (Scanner s : gameState.scanners) {
                if (s.x - Scanner.SCANNER_WIDTH / 2 <= w.x + Worker.WORKER_DIAMETER && w.x - Worker.WORKER_DIAMETER <= s.x + Scanner.SCANNER_WIDTH / 2) {
                    if (s.y - Scanner.SCANNER_HEIGHT / 2 <= w.y + Worker.WORKER_DIAMETER && w.y - Worker.WORKER_DIAMETER <= s.y + Scanner.SCANNER_HEIGHT / 2) {
                        s.workerPower = Scanner.POWER_FOR_ONE_WORKER;
                        if(!removedAlready) {
                            wIter.remove();
                            removedAlready = true;
                        }                    }
                }
            }
            
            for (DigSite ds : gameState.digSites) {
                if (ds.x - DigSite.WIDTH / 2 <= w.x + Worker.WORKER_DIAMETER && w.x - Worker.WORKER_DIAMETER <= ds.x + DigSite.WIDTH / 2) {
                    if (ds.y - DigSite.HEIGHT / 2 <= w.y + Worker.WORKER_DIAMETER && w.y - Worker.WORKER_DIAMETER <= ds.y + DigSite.HEIGHT / 2) {
                        ds.workerPower = DigSite.POWER_FOR_ONE_WORKER;
                        if(!removedAlready) {
                            wIter.remove();
                            removedAlready = true;
                        }                    
                    }
                }
            }
            
            for (ResearchCamp rs : gameState.researchCamps) {
                if (rs.x - ResearchCamp.WIDTH / 2 <= w.x + Worker.WORKER_DIAMETER && w.x - Worker.WORKER_DIAMETER <= rs.x + ResearchCamp.WIDTH / 2) {
                    if (rs.y - ResearchCamp.HEIGHT / 2 <= w.y + Worker.WORKER_DIAMETER && w.y - Worker.WORKER_DIAMETER <= rs.y + ResearchCamp.HEIGHT / 2) {
                        rs.workerPower = DigSite.POWER_FOR_ONE_WORKER;
                        if(!removedAlready) {
                            wIter.remove();
                            removedAlready = true;
                        }                    
                    }
                }
            }
        }
    }
}
