package org.subquark.ld36.camp;

import java.util.List;

import org.subquark.ld36.workers.Worker;

import com.badlogic.gdx.Gdx;

public class CampUpdater {
    private final List<Worker> workers;
    private final List<Camp> camps;
    
    public CampUpdater(List<Worker> workers, List<Camp> camps) {
        this.workers = workers;
        this.camps = camps;
    }
    
    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime() * 1000;
        for (Camp c : camps) {
            c.cooldown -= deltaTime;
            if (c.cooldown <= 0) {
                c.cooldown = Camp.CAMP_COOLDOWN;
                
                Worker w1 = new Worker();
                workers.add(w1);
                w1.x = c.x - Camp.CAMP_WIDTH / 2 - 20;
                w1.y = c.y;
                w1.velocityX = - Worker.STRAIGHT_VELOCITY;
                
                Gdx.app.debug("camp_updater", "put worker at : " + w1.x + "/" + w1.y);
                Worker w2 = new Worker();
                workers.add(w2);
                w2.x = c.x + Camp.CAMP_WIDTH / 2 + 20;
                w2.y = c.y;
                w2.velocityX = Worker.STRAIGHT_VELOCITY;
                
                Worker w3 = new Worker();
                workers.add(w3);
                w3.x = c.x;
                w3.y = c.y - Camp.CAMP_HEIGHT / 2 - 20;
                w3.velocityY = - Worker.STRAIGHT_VELOCITY;

                Worker w4 = new Worker();
                workers.add(w4);
                w4.x = c.x;
                w4.y = c.y + Camp.CAMP_HEIGHT / 2 + 20;
                w4.velocityY = Worker.STRAIGHT_VELOCITY;

            }
        }
    }
}
