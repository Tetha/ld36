package org.subquark.ld36.camp;

import org.subquark.ld36.GameState;
import org.subquark.ld36.workers.Worker;

import com.badlogic.gdx.Gdx;

public class CampUpdater {
    private final GameState gameState;
    
    public CampUpdater(GameState gameState) {
        this.gameState = gameState;
    }
    
    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime() * 1000;
        for (Camp c : gameState.camps) {
            c.cooldown -= deltaTime;
            if (c.cooldown <= 0) {
                c.cooldown = Camp.CAMP_COOLDOWN;
                
                Worker wEast = new Worker();
                gameState.workers.add(wEast);
                wEast.x = c.x - Camp.CAMP_WIDTH / 2 - 20;
                wEast.y = c.y;
                wEast.velocityX = - Worker.STRAIGHT_VELOCITY;
                
                Worker wWest = new Worker();
                gameState.workers.add(wWest);
                wWest.x = c.x + Camp.CAMP_WIDTH / 2 + 20;
                wWest.y = c.y;
                wWest.velocityX = Worker.STRAIGHT_VELOCITY;
                
                Worker wNorth = new Worker();
                gameState.workers.add(wNorth);
                wNorth.x = c.x;
                wNorth.y = c.y - Camp.CAMP_HEIGHT / 2 - 20;
                wNorth.velocityY = - Worker.STRAIGHT_VELOCITY;

                Worker wSouth = new Worker();
                gameState.workers.add(wSouth);
                wSouth.x = c.x;
                wSouth.y = c.y + Camp.CAMP_HEIGHT / 2 + 20;
                wSouth.velocityY = Worker.STRAIGHT_VELOCITY;

                Worker wNorthEast = new Worker();
                gameState.workers.add(wNorthEast);
                wNorthEast.x = wEast.x;
                wNorthEast.y = wNorth.y;
                wNorthEast.velocityX = wEast.velocityX;
                wNorthEast.velocityY = wNorth.velocityY;
                
                Worker wNorthWest = new Worker();
                gameState.workers.add(wNorthWest);
                wNorthWest.x = wWest.x;
                wNorthWest.y = wNorth.y;
                wNorthWest.velocityX = wWest.velocityX;
                wNorthWest.velocityY = wNorth.velocityY;

                Worker wSouthEast = new Worker();
                gameState.workers.add(wSouthEast);
                wSouthEast.x = wEast.x;
                wSouthEast.y = wSouth.y;
                wSouthEast.velocityX = wEast.velocityX;
                wSouthEast.velocityY = wSouth.velocityY;
                
                Worker wSouthWest = new Worker();
                gameState.workers.add(wSouthWest);
                wSouthWest.x = wWest.x;
                wSouthWest.y = wSouth.y;
                wSouthWest.velocityX = wWest.velocityX;
                wSouthWest.velocityY = wSouth.velocityY;
            }
        }
    }
}
