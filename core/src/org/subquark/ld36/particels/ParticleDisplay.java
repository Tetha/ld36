package org.subquark.ld36.particels;

import org.subquark.ld36.GameState;
import org.subquark.ld36.Textures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ParticleDisplay {
    private static final SpriteBatch batch = new SpriteBatch();
    
    private final Textures textures;
    private final GameState gameState;
    
    public ParticleDisplay(Textures textures, GameState gameState) {
        this.textures = textures;
        this.gameState = gameState;
    }
    
    public void update() {
        batch.begin();
        for (Particle p : gameState.particles) {
            Texture t;
            switch (p.type) {
                case MONEY :
                    t = textures.treasure;
                    break;
                default :
                    t = null;
                    break;
                
            }
            batch.draw(t, p.x, p.y);
        }
        batch.end();
    }
}
