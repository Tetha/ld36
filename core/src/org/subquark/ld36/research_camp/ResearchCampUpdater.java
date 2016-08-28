package org.subquark.ld36.research_camp;

import java.util.Random;

import org.subquark.ld36.GameState;
import org.subquark.ld36.particels.Particle;

import com.badlogic.gdx.Gdx;

public class ResearchCampUpdater {
    private final Random otherRandom;
    private final GameState gameState;
        
    public ResearchCampUpdater(Random otherRandom, GameState gameState) {
        this.otherRandom = otherRandom;
        this.gameState = gameState;
    }
    
    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        for (ResearchCamp rs : gameState.researchCamps) {
            if (rs.workerPower <= 0) continue;
            
            rs.workerPower -= deltaTime;
            
            if (!rs.hasArtifact) {
                if (gameState.unresearchedArtifacts() > 0) {
                    gameState.researchedArtifacts ++;
                    rs.hasArtifact = true;
                }
            }
            if (rs.hasArtifact) {
                rs.researchProgress += deltaTime;
                if (rs.researchProgress >= ResearchCamp.SECONDS_PER_RESEARCH) {
                    rs.researchProgress -= ResearchCamp.SECONDS_PER_RESEARCH;
                    rs.hasArtifact = false;
                    
                    for (int i  = 0; i < 5; i++) {
                        Particle p = new Particle();
                        gameState.particles.add(p);
                        p.x = rs.x;
                        p.y = rs.y - 5;
                        p.velocityY = 100f + otherRandom.nextInt(40) - 20;
                        p.velocityX = otherRandom.nextInt(80) - 40;
                        p.energyLeft = 0.5f + otherRandom.nextInt(20) / 100f;
                        p.type = Particle.ParticleType.SCIENCE;
                    }
                }
            }
        }
    }
}
