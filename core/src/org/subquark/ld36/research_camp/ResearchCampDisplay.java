package org.subquark.ld36.research_camp;

import org.subquark.ld36.GameState;
import org.subquark.ld36.Textures;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class ResearchCampDisplay {
    private static final SpriteBatch batch = new SpriteBatch();
    
    private final Textures textures;
    private final GameState gameState;
    
    public ResearchCampDisplay(Textures textures, GameState gameState) {
        this.textures = textures;
        this.gameState = gameState;
    }
    
    public void update() {
        batch.begin();
        for (ResearchCamp rs : gameState.researchCamps) {
            batch.draw(textures.research, rs.x - ResearchCamp.WIDTH/2, rs.y - ResearchCamp.HEIGHT/2, ResearchCamp.WIDTH, ResearchCamp.HEIGHT);
        }
        batch.end();
    }
}
