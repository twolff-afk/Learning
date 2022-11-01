package main;

import game.Chess;
import game.Game;
import game.Soccer;

/*
This pattern is about a template. Here the abstract class game provides a template for how to use
the class game. every sports extending this abstract class can only be played by using the abstract final
method "play" which provides the indeted use.
Game at the end is abstract -> not possible to create a new instance of it
the method play is final -> cannot be overwritten.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Chess chessGame = new Chess();
        chessGame.play();

        Soccer soccerGame = new Soccer();
        soccerGame.play();

    }

}
