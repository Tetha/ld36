package org.subquark.ld36.digsite;

import java.util.Random;

import org.subquark.ld36.GameState;
import org.subquark.ld36.level.Level;
import org.subquark.ld36.particels.Particle;

import com.badlogic.gdx.Gdx;

public class DigSiteUpdater {
    private final GameState gameState;
    private final Random otherRandom;
    
    public DigSiteUpdater(Random otherRandom, GameState gameState) {
        this.otherRandom = otherRandom;
        this.gameState = gameState;
    }
    
    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        for (DigSite ds : gameState.digSites) {
            if (ds.workerPower <= 0) continue;
            
            ds.workerPower -= deltaTime;
            
            ds.depthMined += deltaTime;
            if (ds.depthMined >= DigSite.SECONDS_PER_PAYOUT) {
                ds.depthMined -= DigSite.SECONDS_PER_PAYOUT;
                
                for (int xO = 0; xO < ds.totalMiningDiameterHorizontallyTiles(); xO++) {
                    for (int yO = 0; yO < ds.totalMiningDiameterVerticallyTiles(); yO++) {
                        if (gameState.level.hasVisibleTreasure(ds.smallestXMinedTiles() + xO, ds.smallestYMinedTiles() + yO)) {
                            gameState.artifacts += 1;
                            
                            Particle p = new Particle();
                            gameState.particles.add(p);
                            p.x = ds.x;
                            p.y = ds.y - 5;
                            p.velocityY = 100f + otherRandom.nextInt(40) - 20;
                            p.velocityX = otherRandom.nextInt(80) - 40;
                            p.energyLeft = 0.5f + otherRandom.nextInt(20) / 100f;
                            p.type = Particle.ParticleType.MONEY;
                        }
                    }
                }
            }
        }
    }
}
