//Main ConectJava class

package connect.java;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class ConnectJava extends JFrame{

    public static int width = 700;
    public static int height = 600;
    public static int pointx, pointy = 90999;
    protected static int[][] Board = new int[6][7];
    static boolean mouseClicked = false;
    static boolean onColCl = false;
    static int mx, my;

    public static GraphicsUI gui = new GraphicsUI();
    public static ConnectJava cj = new ConnectJava();
    static PU_DeletePiece pudp = new PU_DeletePiece();
    

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
    
    public static void powerUpSetup(int PU){ // setup parameters for delete piece powerup
        onColCl = false;
        pause();
        
        while(true){
            mouseClicked = false;
            checkMouseInfo(cj, 1);
            
            gui.refresh(pointx, pointy, Board);
            
            if (onColCl && PU == 1){
                onColCl = false;
                pudp.DeletePiece(mx,my,Board);
                break;
            } else if (onColCl && PU == 0){
                onColCl = false;
                pudp.switchPiece(mx,my,Board);
                break;
            }
        }
    }
    
    public static void pause(){ // create short delay for certain actions
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            //do nothing
        }
    }
    public static void checkMouseInfo(ConnectJava cj, int puNum){
        
        int mouse_x=MouseInfo.getPointerInfo().getLocation().x-cj.getLocationOnScreen().x;
        int mouse_y=MouseInfo.getPointerInfo().getLocation().y-cj.getLocationOnScreen().y;
        
        if (mouse_y >= 0 && mouse_y <= height+32){
            mx = (int)Math.floor(mouse_x/100);
            my = (int)Math.floor((mouse_y - 32)/100); // reduced by 32 to accomodate for the window bar
            pointx = mx*100;
           
            if (puNum == 1){ // special values created for DeletePiece power up
                pointy = my*100;
                if (mouseClicked){
                    onColCl = true;
                }
            } else {pointy = 90900;}
            
            if (mouseClicked && puNum == 0){ // check if mouse clicked with column boundaries
                onColCl = true;
            }
        }
        else {
            pointx = 90090;
            }
    }
    
    public static void main(String[] args) {
        Game();
    }
    
    
    public static void Game(){
    cj.setVisible(true);
        Gameplay gp = new Gameplay();
        Board = gp.Generate(Board);       
        while(Gameplay.winner == 0){
            mouseClicked = false;
            checkMouseInfo(cj, 0);
           
            if (onColCl){
                onColCl= false;
                gp.placePiece(mx,my,Board);
            }
            gui.refresh(pointx, pointy, Board);
        }
    }
    
}
