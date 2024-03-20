package com.github.hanyaeger.tutorial.entities.bubbles;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class AirBubble extends Bubble {

    protected AirBubble(Coordinate2D initialLocation, int speed) {
        super(initialLocation,speed);
        setFill(Color.RED);
    }
}
