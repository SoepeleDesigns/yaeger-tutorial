package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.entities.map.Coral;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.bubbles.AirBubble;
import com.github.hanyaeger.tutorial.entities.text.BubblesPoppedText;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided, Collider {
    private HealthText healthText;
    private BubblesPoppedText bubblesPoppedText;
    private Waterworld waterworld;

    private int health = 10;
    private int bubblesPopped = 0;

    public Hanny(Coordinate2D location, HealthText healthText, BubblesPoppedText bubblesPoppedText, Waterworld waterworld){
        super("sprites/hanny.png", location, new Size(20,40), 1, 2);
        this.healthText = healthText;
        this.waterworld = waterworld;
        this.bubblesPoppedText = bubblesPoppedText;
        healthText.setHealthText(health);
        bubblesPoppedText.setBubblesPoppedText(bubblesPopped);
        setGravityConstant(0.005);
        setFrictionConstant(0.04);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.LEFT)){
            setMotion(3,270d);
            setCurrentFrameIndex(0);
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(3,90d);
            setCurrentFrameIndex(1);
        } else if(pressedKeys.contains(KeyCode.UP)){
            setMotion(3,180d);
        } else if(pressedKeys.contains(KeyCode.DOWN)){
            setMotion(3,0d);
        } else if(pressedKeys.isEmpty()){
           // setSpeed(0);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border){
        setSpeed(0);

        switch(border){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        var airBubbleCollision = false;
        var enemyCollision = false;
        Coral collidedCoral;

        for (Collider collider : collidingObject) {
            if (collider instanceof AirBubble) {
                airBubbleCollision = true;
            }
            if (collider instanceof Coral)
            {
                collidedCoral = (Coral)collider;

                setSpeed(0);
                switch ((int)getDirection())
                {
                    case 90: // van links
                        setAnchorLocationX(collidedCoral.getBoundingBox().getMinX() - getWidth() - 10);
                        break;

                    case 180:
                        setAnchorLocationY(collidedCoral.getBoundingBox().getMaxY() + 10);
                        break;

                    case 270:
                        setAnchorLocationX(collidedCoral.getBoundingBox().getMaxX() + 10);
                        break;

                    case 0:
                        setAnchorLocationY(collidedCoral.getBoundingBox().getMinY() - getHeight() - 10);
                        break;
                }
            }
            else {
                enemyCollision = true;
            }
        }

        if (airBubbleCollision) {
            bubblesPoppedText.setBubblesPoppedText(++bubblesPopped);
        }
        if (enemyCollision) {
            healthText.setHealthText(--health);

            if (health == 0) {
                this.waterworld.setActiveScene(2);
            } else {
                setAnchorLocation(new Coordinate2D(
                        new Random().nextInt((int) (getSceneWidth() - getWidth())),
                        new Random().nextInt((int) (getSceneHeight() - getHeight() - 400))));
            }
        }
    }


}
