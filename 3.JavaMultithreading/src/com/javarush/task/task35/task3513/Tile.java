package com.javarush.task.task35.task3513;

import java.awt.*;

/**
 * Created by v.usov on 13.12.2017.
 */
public class Tile {

    int value;

    public Tile(int value) {
        this.value = value;
    }

    public Tile() {
        value = 0;
    }

    public boolean isEmpty() {
        return value == 0;
    }

    public Color getFontColor(){
        if (value < 16) return new Color(0x776e65);
        return new Color(0xf9f6f2);
    }

    public Color getTileColor() {
        int color = 0;
        switch (value) {

            case 0: {
                color = (0xcdc1b4);
                break;
            }
            case 2: {
                color = (0xeee4da);
                break;
            }
            case 4: {
                color = (0xede0c8);
                break;
            }
            case 8: {
                color = (0xf2b179);
                break;
            }
            case 16: {
                color = (0xf59563);
                break;
            }
            case 32: {
                color = (0xf67c5f);
                break;
            }
            case 64: {
                color = (0xf65e3b);
                break;
            }
            case 128: {
                color = (0xedcf72);
                break;
            }
            case 256: {
                color = (0xedcc61);
                break;
            }
            case 512: {
                color = (0xedc850);
                break;
            }
            case 1024: {
                color = (0xedc53f);
                break;
            }
            case 2048: {
                color = (0xedc22e);
                break;
            }
            default: {
                color = (0xff0000);
                break;
            }

        }
        return new Color(color);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
