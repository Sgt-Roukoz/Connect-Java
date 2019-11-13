package connect.java;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;

public class GraphicsUI extends JPanel {
    int height = ConnectJava.height;
    int width = ConnectJava.width;
    int pointx, pointy = 909000;
    int pieceX, pieceY, placePiece, color = 0;
    int[][]Board = new int[6][7];
    public Boolean animating = false;
            
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        highlight(g);
        drawBoard(g);
        if (animating){
            pieceAnimate(g, color);
        } 
        drawLines(g);
    }
    
    public void drawLines(Graphics g){ //Create Basic Board
        int ypos = 0;
        int xpos = 0;
    
        g.setColor(Color.black); 
        while (ypos <= height){
        g.drawLine(0, ypos, width, ypos);
        ypos += (height/6);
        }
        
        while (xpos <= width){
        g.drawLine(xpos, 0, xpos, height);
        xpos+=(width/7);
        }
    }
    
    public void highlight(Graphics g){ // base method for painting the board
        g.setColor(Color.gray);
        g.fillRect(0, pointy, width, 100);
        g.fillRect(pointx, 0, 100, height);
    }
    
    public void startAnimate(int x, int y, int piece){ // setting up data for animation
        pieceX = x*100;
        pieceY = y*100;
        color = piece;
        animating = true;
        placePiece = -100;
        repaint();
    }
    
    public void pieceAnimate(Graphics g, int col){ // animating piece drop
        
        if (placePiece >= pieceY){
            ConnectJava.Board[(pieceY/100)][(pieceX/100)] = color;
            animating = false;
        }
        
        pause(5);
        placePiece += 25;
        
        if (col == 1){g.setColor(Color.red);}
        else if (col == 2){g.setColor(Color.yellow);}
            
        g.fillOval(pieceX, placePiece, 100, 100);
        repaint();
        
    }
    
    public void refresh(int pointX, int pointY, int[][] board){ // repaints whole board
        pointx = pointX;
        pointy = pointY;
        Board = board;
        repaint();
    }
    
    public static void pause(int time){ // create short delay for certain actions
        try{
            Thread.sleep(time);
        }catch(InterruptedException e){
            //do nothing
        }
    }
    
    public void drawBoard(Graphics g){
        int c;
        for(int r = 0; r < 6; r++){
            for(c = 0; c < 7; c++){ // drawing board based on array values
                
                switch(ConnectJava.Board[r][c]){
                    
                    case 1:
                        g.setColor(Color.red);
                        g.fillOval((100*c), (100*r), 100, 100);
                        break;
                    case 2:
                        g.setColor(Color.yellow);
                        g.fillOval((100*c), (100*r), 100, 100);
                        break;
                    case 3:
                        g.setColor(Color.green);
                        g.fillOval((100*c + 15), (100*r + 15), 70, 70);
                        g.setColor(Color.BLACK);
                        g.drawString("Del Piece",(100*c + 25) , (100*r + 50));
                        break;
                    case 4:
                        g.setColor(Color.cyan);
                        g.fillOval((100*c + 15), (100*r + 15), 70, 70);
                        g.setColor(Color.BLACK);
                        g.drawString("+1 Turn",(100*c + 30) , (100*r + 50));
                        break;
                    case 5:
                        g.setColor(Color.ORANGE);
                        g.fillOval((100*c + 15), (100*r + 15), 70, 70);
                        g.setColor(Color.BLACK);
                        g.drawString("Switch",(100*c + 33) , (100*r + 45));
                        g.drawString("Piece",(100*c + 35) , (100*r + 60));
                        break;
                }
            }
        }
    }
    
    public GraphicsUI(){
        setPreferredSize(new Dimension(width, height));
    }
}