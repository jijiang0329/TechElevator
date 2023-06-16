package com.te.interviewpractice;

import com.te.interviewpractice.gamepieces.ChessPiece;
import com.te.interviewpractice.gamepieces.Pawn;

import java.util.Scanner;

public class ChessGame {
    private int exceptedRows = 8;


    public ChessPiece[][] createBoardFromFile(Scanner chessFileScanner) {
        ChessPiece[][] chessBoard = new ChessPiece[8][8];

        int row = 0;
        while (chessFileScanner.hasNextLine()) {
            String lineOfFile = chessFileScanner.nextLine();
            String[] lineCharacters = lineOfFile.split(",");

            for(int column = 0; column < lineCharacters.length; column++) {
                chessBoard[row][column] = lookUpChessPiece(lineCharacters[column]);
            }

            row++;
        }

        // TODO
        for(String[] line : chessBoard) {
            System.out.println(Arrays.toString(line));
        }

        return chessBoard;
    }

    public ChessPiece lookUpChessPiece(String characterAtLocation) {

        // Do this with an enum

        ChessPiece chessPieceAtLocation = null;

        switch(characterAtLocation) {
            case "P":
                chessPieceAtLocation = new Pawn();
                break;
            case "K":
                //chessPieceAtLocation = new King();
                break;
            case "R":
                // TODO the rook
                break;
        }

        return chessPieceAtLocation;
    }
}
