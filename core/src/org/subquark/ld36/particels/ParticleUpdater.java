package org.subquark.ld36.particels;

import java.util.Iterator;

import org.subquark.ld36.GameState;
import org.subquark.ld36.workers.Worker;

import com.badlogic.gdx.Gdx;

public class ParticleUpdater {
    private final GameState gameState;
    
    public ParticleUpdater(GameState gameState) {
        this.gameState = gameState;
    }
    
    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        
        boolean removedAlready = false;
        Iterator<Particle> pIter = gameState.particles.iterator();
        while (pIter.hasNext()) {
            Particle p = pIter.next();
            p.energyLeft -= deltaTime;
            if (p.energyLeft <= 0) {
                if(!removedAlready) {
                    pIter.remove();
                    removedAlready = true;
                }
            }
            p.x += deltaTime * p.velocityX;
            p.y += deltaTime * p.velocityY;
        }
    }
}
