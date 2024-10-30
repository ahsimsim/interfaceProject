import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16; // 16x16
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48x48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //   768px
    final int screenHeight = tileSize * maxScreenRow; //  576px

    Thread GameThread;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

    }

    public void startGameThread(){
        GameThread = new Thread(this);
        GameThread.start();
    }

    @Override
    public void run(){
        while(GameThread != null){

//            System.out.println("This gmae is looping");

            // 1 UPDATE: update

        }
    }

}
