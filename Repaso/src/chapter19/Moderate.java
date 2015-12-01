/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chapter19;

/**
 *
 * @author jose.villagrana
 */
public class Moderate {
    
    //Design an algorithm to figure out if someone has won in a game of tic-tac-toe.
    /*
    * [x o x]
    * [x x o]
    * [o x o]
    
    * [(0,0) (0,1) (0,2)]
    * [(1,0) (1,1) (1,2)]
    * [(2,0) (2,1) (2,2)]
    
    *[1,2,3,4]
    *4*1 = 4 / 1 = 4
    *4*1 = 4 / 4 = 1
    *2*3 = 6 /2 = 3
    *2*3 = 6 /3 = 2
    *
    */
    public String determineWinner(int[][] ticTacToeBoard){
        String result = "draw";
        
        return result;
    }
    
    public boolean checkRow(int[][] board, int pieceIndexX, int pieceRepresentation){
        for(int y = 0; y < board.length; y++){
            if(board[pieceIndexX][y] != pieceRepresentation)
                return false;
        }
        return true;
    }
    
}
