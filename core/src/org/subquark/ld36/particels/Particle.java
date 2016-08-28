package org.subquark.ld36.particels;

import com.badlogic.gdx.graphics.Texture;

public class Particle {
    public enum ParticleType {
        MONEY
    }
    public float energyLeft;
    public ParticleType type;
    
    public float x;
    public float y;
    
    public float velocityX;
    public float velocityY;
}
