/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.java;

/**
 *
 * @author S347096083
 */
public class PU_DeletePiece extends PowerUps{
    int[][] Board; 
    public void DeletePiece(int click_y, int click_x, int[][] Board){
        if (Board[click_x][click_y] == 0 || Board[click_x][click_y] == 3 || Board[click_x][click_y] == 4 || Board[click_x][click_y] == 5) {
            System.out.println("You cannot pick a powerup/empty square to delete");
            ConnectJava.powerUpSetup(1);
        }
        else if(click_x == 0){
            Board[click_x][click_y] = 0;
        }
        else if(Board[click_x-1][click_y]==0 || Board[click_x-1][click_y] == 3 || Board[click_x-1][click_y] == 4 || Board[click_x-1][click_y] == 5){
            Board[click_x][click_y] = 0;
        }
        else{
           click_x--;
           for(int somevar = click_x; somevar > -1; somevar--){
                switch(Board[somevar][click_y]){
                    case 0:
                        continue;                 
                    case 1:
                        Board[somevar + 1][click_y] = 1; //red pieces
                        Board[somevar][click_y] = 0; //temporarily sets space above the space modified to white
                        continue;
                    case 2:
                        Board[somevar + 1][click_y] = 2; //yellow pieces
                        Board[somevar][click_y] = 0; //temporarily sets space above the space modified to white
                        continue;
                }
            }
        }        
    }
    public void switchPiece(int click_y, int click_x, int[][] Board){
        if (Board[click_x][click_y] == 0 || Board[click_x][click_y] == 3 || Board[click_x][click_y] == 4 || Board[click_x][click_y] == 5) {
            System.out.println("You cannot pick a powerup/empty square to switch");
            ConnectJava.powerUpSetup(0);
        }
        else if(Board[click_x][click_y] == 1){
            Board[click_x][click_y] = 2;
        }else{
            Board[click_x][click_y] = 1;
        }
            }   
        }        
    

