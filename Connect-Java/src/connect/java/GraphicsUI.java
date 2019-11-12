package connect.java;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;

public class GraphicsUI extends JPanel {
    int height = ConnectJava.height;
    int width = ConnectJava.width;
    int pointx, pointy = 909000;
    int[][]Board = new int[6][7];
            
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        highlight(g);
        drawBoard(g);
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
    
    public void refresh(int pointX, int pointY, int[][] board){
        pointx = pointX;
        pointy = pointY;
        Board = board;
        repaint();
    }
    
    
    public void drawBoard(Graphics g){
        int c;
        for(int r = 0; r < 6; r++){
            for(c = 0; c < 7; c++){
                
                switch(Board[r][c]){
                    
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


