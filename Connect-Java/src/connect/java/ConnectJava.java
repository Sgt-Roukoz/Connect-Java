//Main ConectJava class

package connect.java;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import java.util.concurrent.TimeUnit;
import java.awt.*;

public class ConnectJava extends JFrame{

public static int width = 700;
public static int height = 600;
public static int pointx = 90999;

public static GraphicsUI gui = new GraphicsUI();

    public ConnectJava(){
        initUI();
    }

    private void initUI(){
        add(gui);
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
            if (mouse_x >=0 && mouse_x<= 1*(width/7) + 2){
                pointx = 0;
            } 
            else if (mouse_x >1*(width/7)+ 2 && mouse_x<= 2* (width/7)+ 2){
                pointx = 1*(width/7);
            } 
            else if(mouse_x >2* (width/7)+ 2 && mouse_x<= 3* (width/7)+ 2){
                pointx = 2*(width/7);
            }
            else if(mouse_x >3* (width/7)+ 2 && mouse_x<= 4* (width/7)+ 2){
                pointx = 3*(width/7);
            }
            else if(mouse_x >4*(width/7)+ 2 && mouse_x<= 5*(width/7)+ 2){
                pointx = 4*(width/7);
            }
            else if(mouse_x >5*(width/7)+ 2 && mouse_x<= 6*(width/7)+ 2){
                pointx = 5*(width/7);
            }
            else if(mouse_x >6*(width/7)+ 2 && mouse_x<= 7*(width/7)+ 2){
                pointx = 6*(width/7);
            }
            else if(mouse_x < 0 || mouse_x > width){
                pointx = 90090;
            }
        }
            else {
                pointx = 90090;
            }
        System.out.println(mouse_x + " : " + mouse_y);
        }
    
    public static void main(String[] args) {
        ConnectJava cj = new ConnectJava();
        cj.setVisible(true);
        //EventQueue.invokeLater(() -> {ConnectJava cj = new ConnectJava();cj.setVisible(true);});
        
        while(true){
            checkMouseInfo(cj);
            gui.refresh(pointx);
        }
    }
}
