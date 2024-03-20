package com.github.hanyaeger.tutorial.entities.bubbles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public class Bubble extends DynamicCircleEntity implements Collided, SceneBorderCrossingWatcher, Collider {

    private int speed;
    public Bubble(Coordinate2D initialLocation, int speed) {
        super(initialLocation);
        this.speed = speed;
        setRadius(10);
        setOpacity(1);
        setMotion(speed, 180);
    }

    @Override
    public void onCollision(List<Collider> collidingObject){
        var popSound = new SoundClip("audio/pop.mp3");
        popSound.play();

        remove();
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}
