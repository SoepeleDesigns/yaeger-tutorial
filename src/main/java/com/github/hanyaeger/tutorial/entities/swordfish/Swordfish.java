package com.github.hanyaeger.tutorial.entities.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Swordfish extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {


    public Swordfish(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(2, 270d);
    }

    @Override
    protected void setupEntities() {

        SwordfishSprite swordfishSprite = new SwordfishSprite(
                new Coordinate2D(0, 0)
        );
        HitBox hitBox = new HitBox(
                new Coordinate2D(0, 0 + 38));
        addEntity(swordfishSprite);
        addEntity(hitBox);

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border){
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
    }

}
