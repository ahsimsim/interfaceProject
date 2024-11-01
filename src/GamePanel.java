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

    //FPS
    int fps = 60;


    keyHandler keyH = new keyHandler();
    Thread GameThread;


    //set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;


    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void startGameThread(){
        GameThread = new Thread(this);
        GameThread.start();
    }

//    @Override
//    public void run(){
//
//        double drawnInterval = 1000000000 / fps; //0.01666666 seconds;
//        double nextDrawnTime = System.nanoTime() + drawnInterval;
//
//        while(GameThread != null){
//
//            update();
//
//            repaint();
//
//
//
//            try {
//                double remainingTime = nextDrawnTime - System.nanoTime();
//                remainingTime = remainingTime / 1000000;
//
//                if(remainingTime < 0){
//                    remainingTime = 0;
//                }
//
//                Thread.sleep((long) remainingTime);
//
//                nextDrawnTime += drawnInterval;
//
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//    }
    @Override
    public void run(){

        double drawInetval = 1000000000.0 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(GameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInetval;

            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }

        }

    }

    public void update(){

        if(keyH.upPressed){
            playerY -= playerSpeed;
        }
        else if(keyH.downPressed){
            playerY += playerSpeed;
        }
        else if(keyH.leftPressed){
            playerX -= playerSpeed;
        }
        else if(keyH.rightPressed){
            playerX += playerSpeed;
        }

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();

    }

}
