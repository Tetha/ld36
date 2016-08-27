package org.subquark.ld36.workers;

import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;

public class WorkerUpdater {
    private final List<Worker> workers;
    
    public WorkerUpdater(List<Worker> workers) {
        this.workers = workers;
    }
    
    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        
        Iterator<Worker> wIter = workers.iterator();
        while (wIter.hasNext()) {
            Worker w = wIter.next();
            w.lifetimeLeft -= deltaTime;
            Gdx.app.log("worker_updater", "worker now has lifetime " + w.lifetimeLeft);
            if (w.lifetimeLeft <= 0) {
                wIter.remove();
            }
            
            w.x += w.velocityX * deltaTime;
            w.y += w.velocityY * deltaTime;
        }
    }
}
