package org.subquark.ld36.workers;

public class Worker {
    // s
    public static final float START_LIFETIME = 2;

    // pixels / s
    public static final float STRAIGHT_VELOCITY = 75;
    
    public static final float WORKER_DIAMETER = 5;
    
    public float lifetimeLeft = START_LIFETIME;
    public float x;
    public float y;
    
    public float velocityX;
    public float velocityY;
}
