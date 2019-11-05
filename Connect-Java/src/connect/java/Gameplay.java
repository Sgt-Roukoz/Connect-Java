/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.java;
import java.util.Random;
/**
 *
 * @author S347096083
 */
public class Gameplay {
    //protected int[][] Board = new int[6][7];
    private int row = 0;
    private int column = 0;
    private int Powerup = 0;
    /*
    Empty squares have value 0
    Squares with red pieces have value 1
    Squares with yellow pieces have value 2
    Squares with powerups have value 3/4/5
    */
    public int[][] Generate(int[][]Board){//Generating board values
        Random rand = new Random();
        //Setting all sqaures to empty
        for(int ro = 0; ro < 6; ro++){
            for(int co = 0; co < 7; co++){
                Board[ro][co]=0;
            }
        }
        //Setting 5 random squares(no overlap) to random powerups
        for(int numpowerups = 0; numpowerups<5;numpowerups++){
            while(true){
                row = rand.nextInt(6);
                column = rand.nextInt(7);
                if(Board[row][column] == 3 || Board[row][column] == 4 ||Board[row][column] == 5){
                    //nothing
                }
                else{
                    break;
                }
            }
            System.out.println("Row:"+row);
            System.out.println("column"+column);
            Powerup = rand.nextInt(3);
            Board[row][column] = (Powerup+3);
        }
        return Board;
    }
}