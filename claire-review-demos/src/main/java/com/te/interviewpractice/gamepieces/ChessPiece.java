package com.te.interviewpractice.gamepieces;

// TODO why did we make a chess piece abstract?
public abstract class ChessPiece {
    public abstract void move();
    public abstract void checkAvailableSpaces(int row, int column);
}
