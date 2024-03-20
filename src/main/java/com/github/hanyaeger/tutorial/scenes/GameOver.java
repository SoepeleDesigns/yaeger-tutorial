package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.buttons.PlayAgainButton;
import com.github.hanyaeger.tutorial.entities.buttons.QuitGameButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOver extends StaticScene {

    private Waterworld waterworld;

    public GameOver(Waterworld waterworld){
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background3.jpg");
    }

    @Override
    public void setupEntities() {
        var gameOverText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Game over"
        );
        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverText.setFill(Color.WHITE);
        gameOverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        PlayAgainButton playAgainButton = new PlayAgainButton(
                new Coordinate2D(getWidth() / 2 - 100, getHeight() / 2 + 100), waterworld);

        QuitGameButton quitGameButton = new QuitGameButton(
                new Coordinate2D(getWidth() / 2 - 100, getHeight() / 2 + 150), waterworld);
        addEntity(gameOverText);
        addEntity(playAgainButton);
        addEntity(quitGameButton);
    }
}
