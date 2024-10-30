import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    final int originalTileSzie = 16; // 16x16
    final int scale = 3;

    final int tileSzie = originalTileSzie * scale; // 48x48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSzie * maxScreenCol; //   768px
    final int screenHeight = tileSzie * maxScreenRow; //  576px

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
}
