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
    
    public Texture campBuyButton = new Texture(Gdx.files.internal("camp_buy_button.png"));
    public Texture diggerBuyButton = new Texture(Gdx.files.internal("digsite_buy_button.png"));
    public Texture prospectorBuyButton = new Texture(Gdx.files.internal("prospector_buy_button.png"));
    public Texture researchBuyButton = new Texture(Gdx.files.internal("research_buy_button.png"));

    public Texture campBuyButtonSelected = new Texture(Gdx.files.internal("camp_buy_button_selected.png"));
    public Texture diggerBuyButtonSelected = new Texture(Gdx.files.internal("digsite_buy_button_selected.png"));
    public Texture prospectorBuyButtonSelected  = new Texture(Gdx.files.internal("prospector_buy_button_selected.png"));
    public Texture researchBuyButtonSelected = new Texture(Gdx.files.internal("research_buy_button_selected.png"));

    public void dispose() {
        worker.dispose();
        camp.dispose();
        scanner.dispose();
        digger.dispose();
        sand.dispose();
        treasure.dispose();
        
        campBuyButton.dispose();
        diggerBuyButton.dispose();
        prospectorBuyButton.dispose();
        researchBuyButton.dispose();
        
        campBuyButtonSelected.dispose();
        diggerBuyButtonSelected.dispose();
        prospectorBuyButtonSelected.dispose();
        researchBuyButtonSelected.dispose();
    }
}
