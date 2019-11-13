package connect.java;
import java.util.Random;
/**
 *
 * @author S347096083
 */
public class Gameplay {
    private int row = 0;
    private int column = 0;
    private int Powerup = 0;
    public static int turnnum = 1;
    private int breakout;
    private static int counter1 = 0;
    private static int counter2 = 0;
    public static int whichpowerup = 0;
    public static int winner = 0;
    public static UtilityWindow show = new UtilityWindow();
    public UtilityWindow util = new UtilityWindow();
    private static int drawcounter = 0;
    GraphicsUI gui;
    /*
    Empty squares have value 0
    Squares with red pieces have value 1
    Squares with yellow pieces have value 2
    Squares with powerups have value 3/4/5
    */
    public Gameplay(GraphicsUI gu){
        gui = gu;
    }
    
    public int[][] Generate(int[][]Board){//Generating board values
        show.setVisible(true);
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
            Powerup = rand.nextInt(3);
            Board[row][column] = (Powerup+3);
        }
        return Board;
    }
    
    public int[][] placePiece(int Column, int Row, int[][]Board){
        PU_DeletePiece use = new PU_DeletePiece();
        breakout = 0;
        whichpowerup = 0;
        show.pwrup();
        //Parsing through the column given bottom to top
        for(int checkrow = 5; checkrow>-1; checkrow--){
            //placing a piece or skipping over a square based on the value
            switch(Board[checkrow][Column]){
                case 0:
                    gui.startAnimate(Column, checkrow, turnnum);
                    ConnectJava.pause(350);
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
                    whichpowerup = 3;
                    show.pwrup();
                    gui.startAnimate(Column, checkrow, turnnum);
                    if(turnnum == 1){
                        turnnum = 2;
                    }
                    else{
                        turnnum = 1;
                    }
                    ConnectJava.powerUpSetup(1);
                    breakout = 1;
                    break;
                case 4:             
                    whichpowerup = 4;
                    show.pwrup();
                    gui.startAnimate(Column, checkrow, turnnum);
                    breakout = 1;
                    break;
                case 5:                   
                    whichpowerup = 5;
                    show.pwrup();
                    gui.startAnimate(Column, checkrow, turnnum);
                    ConnectJava.powerUpSetup(0);
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
        show.info(turnnum);
        return Board;
    }

    public static void checkWin(int[][]Board){
        winner = 0;
        for(int checkRow = 0; checkRow < 6; checkRow++){
            counter1 = 0;
            counter2 = 0;
            drawcounter = 0;
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
                    winner = 1;
                    show.ender(winner);
                    return;//stops method execution
                }
                else if (counter2>=4){
                    winner = 2;
                    show.ender(winner);
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
                    winner = 1;
                    show.ender(winner);
                    return;
                }
                else if (counter2>=4){
                    winner = 2;
                    show.ender(winner);
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
                    winner = 1;
                    show.ender(winner);
                    return;
                }
                else if (counter2>=4){
                    winner = 2;
                    show.ender(winner);
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
                    winner = 1;
                    show.ender(winner);
                    return;
                }
                else if (counter2>=4){
                    winner = 2;
                    show.ender(winner);
                    return;
                }   
                else{
                    //do nothing
                }  
            }
        }
        for(int checkdraw = 0; checkdraw<6; checkdraw++){
            for(int checkd = 0; checkd<7; checkd++){
                if (Board[checkdraw][checkd] == 1 || Board[checkdraw][checkd] == 2){
                    drawcounter++;
                }
                else{
                    drawcounter = 0;
                }
            }
        }
        if(drawcounter >=42){
            System.out.println("Draw!");
            winner = 3;
            show.ender(winner);
        }
        else{
        //do nothing
        }
    }
}