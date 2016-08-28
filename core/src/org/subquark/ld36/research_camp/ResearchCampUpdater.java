package org.subquark.ld36.research_camp;

import org.subquark.ld36.GameState;

import com.badlogic.gdx.Gdx;

public class ResearchCampUpdater {
    private final GameState gameState;
        
    public ResearchCampUpdater(GameState gameState) {
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
                    rs.researchTicksForThisArtifact++;
                    if (rs.researchTicksForThisArtifact >= ResearchCamp.MAX_TICKS_PER_ARTIFACT) {
                        rs.hasArtifact = false;
                    }
                }
            }
        }
    }
}
