package org.subquark.ld36.research_camp;

import org.subquark.ld36.GameState;
import org.subquark.ld36.digsite.DigSite;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class ResearchCampDisplay {
    private static final ShapeRenderer blockRenderer = new ShapeRenderer();
    
    private final GameState gameState;
    
    public ResearchCampDisplay(GameState gameState) {
        this.gameState = gameState;
    }
    
    public void update() {
        blockRenderer.begin(ShapeType.Filled);
        for (ResearchCamp rs : gameState.researchCamps) {
            if (rs.workerPower > 0) {
                blockRenderer.setColor(Color.CYAN);
            } else {
                blockRenderer.setColor(Color.BLUE);
            }
            blockRenderer.rect(rs.x - ResearchCamp.WIDTH/2, rs.y - ResearchCamp.HEIGHT/2, ResearchCamp.WIDTH, ResearchCamp.HEIGHT);
            
        }
        blockRenderer.end();
    }
}
