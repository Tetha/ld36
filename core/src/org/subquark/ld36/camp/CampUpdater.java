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
                
                Worker wEast = new Worker();
                workers.add(wEast);
                wEast.x = c.x - Camp.CAMP_WIDTH / 2 - 20;
                wEast.y = c.y;
                wEast.velocityX = - Worker.STRAIGHT_VELOCITY;
                
                Worker wWest = new Worker();
                workers.add(wWest);
                wWest.x = c.x + Camp.CAMP_WIDTH / 2 + 20;
                wWest.y = c.y;
                wWest.velocityX = Worker.STRAIGHT_VELOCITY;
                
                Worker wNorth = new Worker();
                workers.add(wNorth);
                wNorth.x = c.x;
                wNorth.y = c.y - Camp.CAMP_HEIGHT / 2 - 20;
                wNorth.velocityY = - Worker.STRAIGHT_VELOCITY;

                Worker wSouth = new Worker();
                workers.add(wSouth);
                wSouth.x = c.x;
                wSouth.y = c.y + Camp.CAMP_HEIGHT / 2 + 20;
                wSouth.velocityY = Worker.STRAIGHT_VELOCITY;

                Worker wNorthEast = new Worker();
                workers.add(wNorthEast);
                wNorthEast.x = wEast.x;
                wNorthEast.y = wNorth.y;
                wNorthEast.velocityX = wEast.velocityX;
                wNorthEast.velocityY = wNorth.velocityY;
                
                Worker wNorthWest = new Worker();
                workers.add(wNorthWest);
                wNorthWest.x = wWest.x;
                wNorthWest.y = wNorth.y;
                wNorthWest.velocityX = wWest.velocityX;
                wNorthWest.velocityY = wNorth.velocityY;

                Worker wSouthEast = new Worker();
                workers.add(wSouthEast);
                wSouthEast.x = wEast.x;
                wSouthEast.y = wSouth.y;
                wSouthEast.velocityX = wEast.velocityX;
                wSouthEast.velocityY = wSouth.velocityY;
                
                Worker wSouthWest = new Worker();
                workers.add(wSouthWest);
                wSouthWest.x = wWest.x;
                wSouthWest.y = wSouth.y;
                wSouthWest.velocityX = wWest.velocityX;
                wSouthWest.velocityY = wSouth.velocityY;

            }
        }
    }
}
