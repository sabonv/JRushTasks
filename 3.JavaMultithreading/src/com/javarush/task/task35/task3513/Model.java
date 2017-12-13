package com.javarush.task.task35.task3513;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by v.usov on 12.12.2017.
 */
public class Model {

    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    public int score;
    public int maxTile;

    public Model() {

        resetGameTiles();
        score = 0;
        maxTile = 2;

    }

    public void resetGameTiles() {

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }

        }
        addTile();
        addTile();

    }

    private void addTile() {
        List<Tile> temp = getEmptyTiles();
        if (!temp.isEmpty())
        temp.get((int) (temp.size() * Math.random())).value = Math.random() < 0.9 ? 2 : 4;

    }

    private List<Tile> getEmptyTiles() {

        List<Tile> result = new ArrayList<>();

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) result.add(gameTiles[i][j]);
            }

        }

        return result;

    }

    private boolean compressTiles(Tile[] tiles) {
        boolean result = false;
        for (int i = 0; i < tiles.length-1; i++) {
            for (int j = i+1; j < tiles.length; j++) {

                if (tiles[i].value == 0 && tiles[j].value > 0) {
                    tiles[i].value = tiles[j].value;
                    tiles[j].value = 0;
                    result = true;
                    break;
                }

            }
        }
        return result;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean flag = false;
        for (int i = 0; i < tiles.length-1; i++) {

            if (tiles[i].value != 0 && tiles[i].value == tiles[i+1].value){
                tiles[i].value = tiles[i].value * 2;
                tiles[i+1].value = 0;
                maxTile = tiles[i].value > maxTile ? tiles[i].value : maxTile;
                score += tiles[i].value;
                flag = true;
            }

        }

        if (flag) compressTiles(tiles);
        return flag;
    }

    private void rotate() {




    }

    public void left() {

        boolean flag = false;

        for (int i = 0; i < gameTiles.length; i++) {
            flag = compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i]);
        }
        if (flag) addTile();
    }




}
