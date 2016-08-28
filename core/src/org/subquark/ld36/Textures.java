package org.subquark.ld36;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Textures {
    public Texture worker = new Texture(Gdx.files.internal("worker_1.png"));
    public Texture camp = new Texture(Gdx.files.internal("camp.png"));
    public Texture scanner = new Texture(Gdx.files.internal("prospector_camp.png"));
    public Texture digger = new Texture(Gdx.files.internal("digger_camp.png"));
    public Texture research = new Texture(Gdx.files.internal("research_camp.png"));

    public Texture sand = new Texture(Gdx.files.internal("sand.png"));
    public Texture treasure = new Texture(Gdx.files.internal("treasure.png"));
    
    public Texture buyCooldownPattern = new Texture(Gdx.files.internal("buy_cooldown_panel.png"));
    public Texture campBuyButton = new Texture(Gdx.files.internal("camp_buy_button.png"));
    public Texture diggerBuyButton = new Texture(Gdx.files.internal("digsite_buy_button.png"));
    public Texture prospectorBuyButton = new Texture(Gdx.files.internal("prospector_buy_button.png"));
    public Texture researchBuyButton = new Texture(Gdx.files.internal("research_buy_button.png"));

    public Texture campBuyButtonSelected = new Texture(Gdx.files.internal("camp_buy_button_selected.png"));
    public Texture diggerBuyButtonSelected = new Texture(Gdx.files.internal("digsite_buy_button_selected.png"));
    public Texture prospectorBuyButtonSelected  = new Texture(Gdx.files.internal("prospector_buy_button_selected.png"));
    public Texture researchBuyButtonSelected = new Texture(Gdx.files.internal("research_buy_button_selected.png"));

    public Texture totalArtifactHeader = new Texture(Gdx.files.internal("artifact_count_header.png"));
    public Texture researchedArtifactHeader = new Texture(Gdx.files.internal("researched_artifact_count_header.png"));
    public Texture timeLeftHeader = new Texture(Gdx.files.internal("time_left_header.png"));
    public Texture requiredArtifactHeader = new Texture(Gdx.files.internal("required_artifact_count_header.png"));
    
    public Texture victoryBanner = new Texture(Gdx.files.internal("victory_banner.png"));
    public Texture defeatBanner = new Texture(Gdx.files.internal("defeat_banner.png"));
    
    public Texture littleTreasureButton = new Texture(Gdx.files.internal("little_treasure_button.png"));
    public Texture someTreasureButton = new Texture(Gdx.files.internal("some_treasure_button.png"));
    public Texture lottaTreasureButton = new Texture(Gdx.files.internal("lotta_treasure_button.png"));
    
    public Texture littleTreasureButtonSelected = new Texture(Gdx.files.internal("little_treasure_button_selected.png"));
    public Texture someTreasureButtonSelected = new Texture(Gdx.files.internal("some_treasure_button_selected.png"));
    public Texture lottaTreasureButtonSelected = new Texture(Gdx.files.internal("lotta_treasure_button_selected.png"));    

    public Texture littleTimeButton = new Texture(Gdx.files.internal("little_time_button.png"));
    public Texture someTimeButton = new Texture(Gdx.files.internal("some_time_button.png"));
    public Texture lottaTimeButton = new Texture(Gdx.files.internal("lotta_time_button.png"));
    
    public Texture littleTimeButtonSelected = new Texture(Gdx.files.internal("little_time_button_selected.png"));
    public Texture someTimeButtonSelected = new Texture(Gdx.files.internal("some_time_button_selected.png"));
    public Texture lottaTimeButtonSelected = new Texture(Gdx.files.internal("lotta_time_button_selected.png"));    

    public Texture playButton = new Texture(Gdx.files.internal("play_button.png"));
    public Texture timePanel = new Texture(Gdx.files.internal("time_panel.png"));
    public Texture treasurePanel = new Texture(Gdx.files.internal("treasure_panel.png"));
    
    public Texture logo = new Texture(Gdx.files.internal("logo.png")); 
    public void dispose() {
        worker.dispose();
        camp.dispose();
        scanner.dispose();
        digger.dispose();
        sand.dispose();
        treasure.dispose();
        
        buyCooldownPattern.dispose();
        campBuyButton.dispose();
        diggerBuyButton.dispose();
        prospectorBuyButton.dispose();
        researchBuyButton.dispose();
        
        campBuyButtonSelected.dispose();
        diggerBuyButtonSelected.dispose();
        prospectorBuyButtonSelected.dispose();
        researchBuyButtonSelected.dispose();
        requiredArtifactHeader.dispose();
        
        victoryBanner.dispose();
        defeatBanner.dispose();
        
        littleTreasureButton.dispose();
        someTreasureButton.dispose();
        lottaTreasureButton.dispose();
        
        littleTreasureButtonSelected.dispose();
        someTreasureButtonSelected.dispose();
        lottaTreasureButtonSelected.dispose();
        
        littleTimeButton.dispose();
        someTimeButton.dispose();
        lottaTimeButton.dispose();
        
        littleTimeButtonSelected.dispose();
        someTimeButtonSelected.dispose();
        lottaTimeButtonSelected.dispose();
        
        playButton.dispose();
        timePanel.dispose();
        treasurePanel.dispose();
        
        logo.dispose();
    }
}
