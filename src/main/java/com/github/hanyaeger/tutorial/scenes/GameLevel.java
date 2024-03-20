package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.entities.Shark;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.text.BubblesPoppedText;
import com.github.hanyaeger.tutorial.entities.map.CoralTileMap;
import com.github.hanyaeger.tutorial.entities.swordfish.Swordfish;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {

    private Waterworld waterworld;
    CoralTileMap coralTileMap = new CoralTileMap();

    public GameLevel(Waterworld waterworld){
        this.waterworld = waterworld;
    }
    @Override
    public void setupScene(){
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {
        Swordfish swordfish = new Swordfish(new Coordinate2D(500, 0));

        BubblesPoppedText bubblesPoppedText = new BubblesPoppedText(
                new Coordinate2D(200,500));

        Shark sharky = new Shark(
                new Coordinate2D(700, 250));

        HealthText healthText = new HealthText(
                new Coordinate2D(getWidth() / 2, 0));
        Hanny hanny = new Hanny(
                new Coordinate2D(0, 0), healthText, bubblesPoppedText, waterworld);




        addEntity(swordfish);
        addEntity(sharky);
        addEntity(hanny);
        addEntity(healthText);
        addEntity(bubblesPoppedText);
    }

    @Override
    public void setupEntitySpawners() {

    }

    @Override
    public void setupTileMaps() {
        addTileMap(coralTileMap);
    }
}
