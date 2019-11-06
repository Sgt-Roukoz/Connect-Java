//Main ConectJava class

package connect.java;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.event.*;

public class ConnectJava extends JFrame{

public static int width = 700;
public static int height = 600;
public static int pointx = 90999;
protected static int[][] Board = new int[6][7];
static boolean mouseClicked = false;
static boolean onColCl = false;
static int mx, my;

public static GraphicsUI gui = new GraphicsUI();

    public ConnectJava(){
        initUI();
    }

    private void initUI(){
        add(gui);
        addMouseListener(new MouseListener() {
        public void mousePressed(MouseEvent me) { }
        public void mouseReleased(MouseEvent me) { }
        public void mouseEntered(MouseEvent me) { }
        public void mouseExited(MouseEvent me) { }
        public void mouseClicked(MouseEvent me) { 
          if(me.getButton() == MouseEvent.BUTTON1) {
            mouseClicked = true;
          }
        }
    });
        setResizable(false);
        setSize(width, height);
        pack();

        setTitle("Connect Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public static void checkMouseInfo(ConnectJava cj){
        
        int mouse_x=MouseInfo.getPointerInfo().getLocation().x-cj.getLocationOnScreen().x;
        int mouse_y=MouseInfo.getPointerInfo().getLocation().y-cj.getLocationOnScreen().y;
        if (mouse_y >= 0 && mouse_y <= height){
            mx = (int)Math.floor(mouse_x/100);
            my = (int)Math.floor(mouse_y/100);
            pointx = mx*100;
            if (mouseClicked){
                onColCl = true;
            }
        }
        else {
            pointx = 90090;
            }
    }
    
    public static void main(String[] args) {
        ConnectJava cj = new ConnectJava();
        cj.setVisible(true);
        Gameplay gp = new Gameplay();
        Board = gp.Generate(Board);       
        while(true){
            mouseClicked = false;
            checkMouseInfo(cj);
            if (onColCl){
                System.out.println("H");
                onColCl= false;
                gp.placePiece(mx,my,Board);
            }
            gui.refresh(pointx, Board);
        }
    }
}