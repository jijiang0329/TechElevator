package com.te.interviewpractice;

import com.te.interviewpractice.gamepieces.ChessPiece;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CommandLineInterviewTest {

    // TODO contents of test file?!?!
    // TODO confirm nextLine() is called
    @Test
    void readFile() throws FileNotFoundException {

        // Arrange
        // where is the instance!?!?!?
        ChessGame testGame = new ChessGame();
        File file = new File("chess-board.csv");
        Scanner chessFileScanner = new Scanner(file);

        Scanner spyChessFileScanner = Mockito.spy(chessFileScanner);



        // Act
        ChessPiece[][] chessBoard = testGame.createBoardFromFile(spyChessFileScanner);

        // Assert
        // you could hardcode the chess board
        // it passes but not in the spirit of the game
        // how do we confirm that you actually looked at the file

        // TODO assert the array is the right size

        verify(spyChessFileScanner, times(6)).nextLine();
    }








    public void mockito() {
        File mockedFile = Mockito.mock(File.class);
        Mockito.when(mockedFile.exists()).thenReturn(true);
    }
}