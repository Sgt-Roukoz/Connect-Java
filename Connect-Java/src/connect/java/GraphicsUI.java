
package connect.java;
import java.awt.Graphics;
import java.awt.EventQueue;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.awt.*;

public class GraphicsUI extends JPanel {
    int height = ConnectJava.height;
    int width = ConnectJava.width;
    int pointx = ConnectJava.pointx;
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        highlight(g);
        drawLines(g);
    }
    
    public void drawLines(Graphics g){ // Create Basic Board
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
        g.fillRect(pointx, 0, 100, height);
    }
    
    public void refresh(int point){
        pointx = point;
        repaint();
    }
    
    public GraphicsUI(){
        setPreferredSize(new Dimension(width, height));
    }
}