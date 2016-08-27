package org.subquark.ld36.workers;

import java.util.Iterator;
import java.util.List;

import org.subquark.ld36.camp.Camp;
import org.subquark.ld36.scanner.Scanner;

import com.badlogic.gdx.Gdx;

public class WorkerUpdater {
    private final List<Worker> workers;
    
    private final List<Camp> camps;
    private final List<Scanner> scanners;
    
    public WorkerUpdater(List<Camp> camps, List<Scanner> scanners, List<Worker> workers) {
        this.camps = camps;
        this.scanners = scanners;
        this.workers = workers;
    }
    
    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        
        boolean removedAlready = false;
        Iterator<Worker> wIter = workers.iterator();
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
            
            for (Camp c : camps) {
                if (c.x - Camp.CAMP_WIDTH / 2 <= w.x - Worker.WORKER_DIAMETER && w.x - Worker.WORKER_DIAMETER <= c.x + Camp.CAMP_WIDTH / 2) {
                    if (c.y - Camp.CAMP_HEIGHT / 2 <= w.y - Worker.WORKER_DIAMETER && w.y - Worker.WORKER_DIAMETER <= c.y + Camp.CAMP_HEIGHT / 2) {
                        if(!removedAlready) {
                            wIter.remove();
                            removedAlready = true;
                        }
                    }
                }
            }
            
            for (Scanner s : scanners) {
                if (s.x - Scanner.SCANNER_WIDTH / 2 <= w.x + Worker.WORKER_DIAMETER && w.x - Worker.WORKER_DIAMETER <= s.x + Scanner.SCANNER_WIDTH / 2) {
                    if (s.y - Scanner.SCANNER_HEIGHT / 2 <= w.y + Worker.WORKER_DIAMETER && w.y - Worker.WORKER_DIAMETER <= s.y + Scanner.SCANNER_HEIGHT / 2) {
                        s.workerPower = Scanner.POWER_FOR_ONE_WORKER;
                        if(!removedAlready) {
                            wIter.remove();
                            removedAlready = true;
                        }                    }
                }
            }

        }
    }
}
