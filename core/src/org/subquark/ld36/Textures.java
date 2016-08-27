package org.subquark.ld36;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Textures {
    public Texture worker = new Texture(Gdx.files.internal("worker_1.png"));
    public Texture camp = new Texture(Gdx.files.internal("camp.png"));
    public Texture scanner = new Texture(Gdx.files.internal("prospector_camp.png"));
    
    public void dispose() {
        worker.dispose();
        camp.dispose();
        scanner.dispose();
    }
}
