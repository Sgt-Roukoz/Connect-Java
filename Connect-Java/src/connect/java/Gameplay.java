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
    private int turnnum = 1;
    private int breakout;
    private static int counter1 = 0;
    private static int counter2 = 0;
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
    
    public int[][] placePiece(int Column, int Row, int[][]Board){
        PU_DeletePiece use = new PU_DeletePiece();
        breakout = 0;
        System.out.println(Column);
        //Parsing through the column given bottom to top
        for(int checkrow = 5; checkrow>-1; checkrow--){
            //placing a piece or skipping over a square based on the value
            switch(Board[checkrow][Column]){
                case 0:
                    Board[checkrow][Column] = turnnum;
                    if(turnnum == 1){
                        turnnum = 2;
                    }
                    else{
                        turnnum = 1;
                    }
                    breakout = 1;
                    break;
                case 1:
                    //already filled square
                    break;
                case 2:
                    //already filled square
                    break;
                case 3:
                    Board[checkrow][Column] = turnnum;
                    if(turnnum == 1){
                        turnnum = 2;
                    }
                    else{
                        turnnum = 1;
                    }
                    ConnectJava.deletePieceSetup();
                    breakout = 1;
                    break;
                case 4:
                    Board[checkrow][Column] = turnnum;
                    breakout = 1;
                    break;
                case 5:
                    Board[checkrow][Column] = turnnum;
                    //Call switch piece setup method
                    //use.switchPiece(Column, Row, turnnum, Board);
                    if(turnnum == 1){
                        turnnum = 2;
                    }
                    else{
                        turnnum = 1;
                    }
                    breakout = 1;
                    break;
            }
            if (breakout == 1){
                break;
            }
        }
        checkWin(Board);
        return Board;
    }
    public static void checkWin(int[][]Board){
        for(int checkRow = 0; checkRow < 6; checkRow++){
            counter1 = 0;
            counter2 = 0;
            for(int checkColumn = 0; checkColumn < 7; checkColumn++){
                if (Board[checkRow][checkColumn] == 1){
                    counter1++;
                }
                else{
                    counter1 = 0;
                }             
                if (Board[checkRow][checkColumn] == 2){
                    counter2++;
                }
                else{
                    counter2 = 0;
                }
                if (counter1>=4){
                    //This is a placeholder for what will actually happen should someone win
                    System.out.println("Red wins!");
                    return;//stops method execution
                }
                else if (counter2>=4){
                    //This is a placeholder for what will actually happen should someone win
                    System.out.println("Yellow wins!");
                    return;
                }   
                else{
                    //do nothing
                }
            }
        }
        for(int checkColumn2 = 0; checkColumn2 < 7; checkColumn2++){
            counter1 = 0;
            counter2 = 0;
            for(int checkRow2 = 0; checkRow2 < 6; checkRow2++){
                if (Board[checkRow2][checkColumn2] == 1){
                    counter1++;
                }
                else{
                    counter1 = 0;
                }             
                if (Board[checkRow2][checkColumn2] == 2){
                    counter2++;
                }
                else{
                    counter2 = 0;
                }
                if (counter1>=4){
                    //This is a placeholder for what will actually happen should someone win
                    System.out.println("Red wins!");
                    return;
                }
                else if (counter2>=4){
                    //This is a placeholder for what will actually happen should someone win
                    System.out.println("Yellow wins!");
                    return;
                }   
                else{
                    //do nothing
                }
            }
        }
        //front diagonal
        for(int rows = 0; rows < 3; rows++){
            for(int columns = 0; columns < 4; columns++){
                counter1 = 0;
                counter2 = 0;
                for(int cycle = 0; cycle < 4; cycle++){
                    if (Board[rows+cycle][columns+cycle] == 1){
                        counter1++;
                    }
                    else{
                        counter1 = 0;
                    }
                    if (Board[rows+cycle][columns+cycle] == 2){
                        counter2++;
                    }
                    else{
                        counter2 = 0;
                    }
                }
                if (counter1>=4){
                    //This is a placeholder for what will actually happen should someone win
                    System.out.println("Red wins!");
                    return;
                }
                else if (counter2>=4){
                    //This is a placeholder for what will actually happen should someone win
                    System.out.println("Yellow wins!");
                    return;
                }   
                else{
                    //do nothing
                }  
            }
        }
        //back diagonal 
        for(int rows = 0; rows < 3; rows++){
            for(int columns = 6; columns > 2; columns--){
                counter1 = 0;
                counter2 = 0;
                for(int cycle = 0; cycle < 4; cycle++){
                    if (Board[rows+cycle][columns-cycle] == 1){
                        counter1++;
                    }
                    else{
                        counter1 = 0;
                    }
                    if (Board[rows+cycle][columns-cycle] == 2){
                        counter2++;
                    }
                    else{
                        counter2 = 0;
                    }
                }
                if (counter1>=4){
                    //This is a placeholder for what will actually happen should someone win
                    System.out.println("Red wins!");
                    return;
                }
                else if (counter2>=4){
                    //This is a placeholder for what will actually happen should someone win
                    System.out.println("Yellow wins!");
                    return;
                }   
                else{
                    //do nothing
                }  
            }
        }
    }
}