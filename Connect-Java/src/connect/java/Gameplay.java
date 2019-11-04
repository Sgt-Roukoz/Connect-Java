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
    protected int[][] Board = new int[6][7];
    private int[] OverlapY = new int[5];
    private int[] OverlapX = new int[5];
    private int amtPowerups=0;
    private int row;
    private int column;
    private int Powerup;
    /*
    Empty squares have value 0
    Squares with red pieces have value 1
    Squares with yellow pieces have value 2
    Squares with powerups have value 3/4/5
    */
    public void Generate(){//Generating board values
        Random rand = new Random();
        //Setting all sqaures to empty
        for(int ro = 0; ro < 6; ro++){
            for(int co = 0; co < 7; co++){
                Board[ro][co]=0;
            }
        }
        //Setting 5 random squares(no overlap) to random powerups
        while(amtPowerups<5){
            while(true){
                row = rand.nextInt(6);
                column = rand.nextInt(7);
                for(int check = 0; check < 5; check++){
                    if(OverlapX[check] == column && OverlapY[check] == row)
                        continue;
                    else{
                    //Nothing
                    }
                }
                break;
            }
            Powerup = rand.nextInt(3);
            Board[row][column] = (Powerup+1);
            OverlapY[amtPowerups]=row;
            OverlapX[amtPowerups]=column;
            amtPowerups++;
        }
    }
    public void drawBoard(int[][]Board){
        int r;
        int c;
        for(r = 0; r < 6; r++){
            for(c = 0; c < 7; c++){
                switch(Board[r][c]){
                    case 0:
                        //set empty
                        break;
                    case 1:
                        //set to red piece
                        break;
                    case 2:
                        //set to black piece
                        break;
                    case 3:
                        //set to powerup1
                        break;
                    case 4:
                        //set to powerup2
                        break;
                    case 5:
                        //set to powerup3
                        break;
                }
            }
        }
    }
}
