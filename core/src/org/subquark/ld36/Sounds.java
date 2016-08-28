package org.subquark.ld36;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Sounds {
    public Sound cooldownComplete = Gdx.audio.newSound(Gdx.files.internal("cooldown_complete.wav"));
    public Sound buildDenied = Gdx.audio.newSound(Gdx.files.internal("build_failed.wav"));
    public Sound resourceGained = Gdx.audio.newSound(Gdx.files.internal("resource.wav"));
    public Sound scienceGained = Gdx.audio.newSound(Gdx.files.internal("science.wav"));

    public Sound victorySound = Gdx.audio.newSound(Gdx.files.internal("victory.wav"));
    public Sound defeatSound = Gdx.audio.newSound(Gdx.files.internal("lose.wav"));
    
    public void dispose() {
        cooldownComplete.dispose();
        buildDenied.dispose();
        resourceGained.dispose();
        scienceGained.dispose();
        victorySound.dispose();
        defeatSound.dispose();
    }
}
