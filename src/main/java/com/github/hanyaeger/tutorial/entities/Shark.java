package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Shark extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider {
    public Shark(Coordinate2D initialLocation) {
        super("sprites/sharky.png", initialLocation, new Size(100, 100), 1, 19);
        setMotion(2, 90d);
        setAutoCycle(100, -1);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border){
        setAnchorLocationX(0);
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 400));
    }
}
