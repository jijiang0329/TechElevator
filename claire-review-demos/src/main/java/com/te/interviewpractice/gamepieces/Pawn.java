package com.te.interviewpractice.gamepieces;

// TODO why did we create a class for pawn
public class Pawn extends ChessPiece implements Moveable {

    @Override
    public void move() {

    }

    public void locate(String[][] chessBoard) {
        int moveCounter = 0;

        // TODO what does the first for cover in a 2D array
        for(int i = 0; i < chessBoard.length; i++) {
            // GET THE THING
            String[] row = chessBoard[i];

            // TODO what does the second for cover in a 2D array
            for(int j = 0; j < row.length; j++) {

                // GET THE THING
                String chessSpace = chessBoard[i][j];

                if(chessSpace.substring(0,1).equalsIgnoreCase("P")) {
                    // if the value equals P
                    checkAvailableSpaces(1,1);
                }

            }
        }
    }


    @Override
    public void checkAvailableSpaces(int row, int column) {
        // row plus one
        // column
        // column + 1
        // column - 1
    }

}
