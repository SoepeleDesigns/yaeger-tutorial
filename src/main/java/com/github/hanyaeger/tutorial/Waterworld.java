package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.YaegerGame;
import com.github.hanyaeger.tutorial.scenes.LevelOne;
import com.github.hanyaeger.tutorial.scenes.TitleScene;

public class Waterworld extends YaegerGame {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void setupGame() {
        setGameTitle("Waterworld");
        setSize(new Size(800, 600));
    }

    @Override
    protected void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new LevelOne());
    }

    @Override
    public void setActiveScene(int id) {
        super.setActiveScene(id);
    }
}