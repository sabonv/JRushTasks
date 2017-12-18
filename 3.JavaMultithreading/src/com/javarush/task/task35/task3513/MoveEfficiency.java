package com.javarush.task.task35.task3513;

/**
 * Created by v.usov on 18.12.2017.
 */
public class MoveEfficiency implements Comparable<MoveEfficiency> {

    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    @Override
    public int compareTo(MoveEfficiency that) {

        if (this == that) return 0;

        if(this.numberOfEmptyTiles > that.numberOfEmptyTiles) return 1;
        if(this.numberOfEmptyTiles < that.numberOfEmptyTiles) return -1;

        if(this.numberOfEmptyTiles == that.numberOfEmptyTiles) {
            if (this.score > that.score) return 1;
            if (this.score < that.score) return -1;
        }
        return 0;
    }

    public Move getMove() {
        return move;
    }
}
