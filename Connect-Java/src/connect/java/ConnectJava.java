//Main ConectJava class

package connect.java;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.JFrame;
import java.util.concurrent.TimeUnit;
import java.awt.*;

public class ConnectJava extends Canvas{

static int width = 1080;
static int height = 720;
static int pointx = 990000;

static Canvas can = new ConnectJava();

    public static void main(String[] args){
        
        EventQueue.invokeLater(() -> {
            ConnectJava cj = new ConnectJava();
            cj.setVisible(true);
        });
        
        JFrame frame = new JFrame("Connect Java");
        
        can.setSize(width, height);
        can.setBackground(Color.white);
        frame.add(can);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        while (true){ // Get Mouse Position
            
            int mouse_x=MouseInfo.getPointerInfo().getLocation().x-can.getLocationOnScreen().x;
            int mouse_y=MouseInfo.getPointerInfo().getLocation().y-can.getLocationOnScreen().y;
            if (mouse_y >= 0 && mouse_y <= height){
                if (mouse_x >=0 && mouse_x<= 135){
                    pointx = 0;
                } 
                else if (mouse_x >135 && mouse_x<= 270){
                    pointx = 135;
                } 
                else if(mouse_x >270 && mouse_x<= 405){
                    pointx = 270;
                }
                else if(mouse_x >405 && mouse_x<= 540){
                    pointx = 405;
                }
                else if(mouse_x >540 && mouse_x<= 675){
                    pointx = 540;
                }
                else if(mouse_x < 0 || mouse_x > width){
                    pointx = 90090;
                }
            }
            else {
                pointx = 90090;
            }
            highLight();
        }
        
    }
    
    public static void highLight(){
        can.repaint();
    }
    
    public void paint(Graphics g){ // base method for painting the board
        g.setColor(Color.gray);
        g.fillRect(pointx, 0, 135, height);
        drawLines(g);    
    }   
    
    
    public static void drawLines(Graphics g){ // Create Basic Board
        int ypos = 0;
        int xpos = 0;
        
        g.setColor(Color.black); 
        while (ypos <= height){
        g.drawLine(0, ypos, width, ypos);
        ypos += (720/8);
        }
        
        while (xpos <= width){
        g.drawLine(xpos, 0, xpos, height);
        xpos+=(width/8);
        }
    }
    }
    

    /*
    public ConnectJava(){
        initUI();
    }
    
    private void initUI(){
        add(new UI());
        setSize(1080, 720);
        
        setTitle("Connect Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
      
    }
*/
