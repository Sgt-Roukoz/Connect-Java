/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.java;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author S347096083
 */
public class PU_DeletePiece extends PowerUps{
    int height = ConnectJava.height;
    int width = ConnectJava.width;
    int pointx = ConnectJava.pointx;
    int[][] Board; 
    public void highlight(Graphics g){ // base method for painting the board
        g.setColor(Color.gray);
        g.fillRect(pointx, 0, 100, height);
    }
    public void PU_DeletePiece(int[][] Board, Graphics g){
        System.out.println("You can delete one of your opponent's pieces!");
        
        int x = 2;
        int y = 3; //Using this position until I figure out a way to find which square they picked 
        if (Board[x][y] == 0 || Board[x][y] == 3 || Board[x][y] == 4 || Board[x][y] == 5) {
            System.out.println("You cannot pick a powerup to vanish");
        }
        else if (Board[x][y] == 2){ //Using 2 as opponent until I figure out a way to check whose turn it is
            System.out.println("You cannot pick your own piece");
        } else{
           
           g.setColor(Color.white);
           g.fillRect((100*x), (100*y), 100, 100);
        }
        
    }
    
}
