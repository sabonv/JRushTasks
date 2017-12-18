package com.javarush.task.task35.task3513;


import java.util.*;


/**
 * Created by v.usov on 12.12.2017.
 */
public class Model {

    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    public int score;
    public int maxTile;
    private boolean isSaveNeeded = true;
    private Stack<Tile[][]> previousStates = new Stack();
    private Stack<Integer> previousScores = new Stack();

    public Model() {

        resetGameTiles();
        score = 0;
        maxTile = 2;

    }

    public void autoMove() {

        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4, Collections.reverseOrder());

        priorityQueue.add(getMoveEfficiency(this::left));
        priorityQueue.add(getMoveEfficiency(this::right));
        priorityQueue.add(getMoveEfficiency(this::up));
        priorityQueue.add(getMoveEfficiency(this::down));

        Move move = priorityQueue.peek().getMove();
        move.move();

    }

    public MoveEfficiency getMoveEfficiency(Move move) {

        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged()) moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else moveEfficiency = new MoveEfficiency(-1, 0, move);

        rollback();
        return moveEfficiency;

    }


    public boolean hasBoardChanged() {

        int sum = 0;
//        int cGameTiles = 0;
//        int cPreviousStates = 0;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                sum += gameTiles[i][j].value - previousStates.peek()[i][j].value;
            }
        }

//        for (int i = 0; i < FIELD_WIDTH; i++) {
//            for (int j = 0; j < FIELD_WIDTH; j++) {
//                cGameTiles += gameTiles[i][j].value;
//                cGameTiles += previousStates.peek()[i][j].value;
//            }
//        }
        return sum != 0;
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;

        switch (n) {
            case 0: { left(); break; }
            case 1: { right(); break; }
            case 2: { up(); break; }
            case 3: { down(); break; }
        }

    }

    private void saveState(Tile[][] gameTilesForS) {

        Tile[][] temp = new Tile[FIELD_WIDTH][FIELD_WIDTH];


        for (int i = 0; i < gameTilesForS.length; i++) {
            for (int j = 0; j < gameTilesForS[0].length; j++) {
                temp[i][j] = new Tile(gameTilesForS[i][j].getValue());
            }
        }

        //temp = gameTilesForS.clone();

        previousStates.push(temp);
        previousScores.push(score);
        isSaveNeeded = false;

    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
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

    private void rotate(int n) {
        if (n<0) n=0;
        for (int i = 0; i < n; i++) {


            int len = FIELD_WIDTH;
            for (int k = 0; k < len / 2; k++) // border -> center
            {
                for (int j = k; j < len - 1 - k; j++) // left -> right
                {

                    Tile tmp = gameTiles[k][j];
                    gameTiles[k][j] = gameTiles[j][len - 1 - k];
                    gameTiles[j][len - 1 - k] = gameTiles[len - 1 - k][len - 1 - j];
                    gameTiles[len - 1 - k][len - 1 - j] = gameTiles[len - 1 - j][k];
                    gameTiles[len - 1 - j][k] = tmp;
                }
            }

        }

    }

    public void left() {

        if(isSaveNeeded) saveState(this.gameTiles);

        boolean flag = false;

        for (int i = 0; i < gameTiles.length; i++) {
            flag = compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i]);
        }
        if (flag) {
            addTile();
            isSaveNeeded = true;
        }


    }

    public void down() {
        saveState(this.gameTiles);
        rotate(3);
        left();
        rotate(1);
    }

    public void right(){
        saveState(this.gameTiles);
        rotate(2);
        left();
        rotate(2);
    }

    public void up(){
        saveState(this.gameTiles);
        rotate(1);
        left();
        rotate(3);
    }

    public boolean canMove() {

        if (!getEmptyTiles().isEmpty())
            return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
            }
        }
        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles.length; i++) {
                if (gameTiles[i][j].value == gameTiles[i - 1][j].value)
                    return true;
            }
        }
        return false;

    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }


}
