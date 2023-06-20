package com.te.interviewpractice;

import com.te.interviewpractice.gamepieces.ChessPiece;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandLineInterview {

    // TODO Today
    //   Get caught up on chess
    //   Unit testing Spys - putting the D in SOLID
    //   Maybe Christopher will take your pulse
    //   Pair project

    private static final String KNIGHT = "K";
    private static final String PAWN = "P";
    private static final String ROOK = "R";
    private static final String EMPTY = "0";

    // TODO do the inheritence thing WHOA
    static ChessPiece[][] chessBoard = new ChessPiece[8][8];

    public static void main(String[] args) {
        ChessGame runningGame = new ChessGame();
        File chessFile = new File("chess-board.csv");
        Scanner chessFileScanner = null;
        try {
            chessFileScanner = new Scanner(chessFile);
            chessBoard = runningGame.createBoardFromFile(chessFileScanner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static void pawn() {

    }

    public static void knight() {

    }
}
