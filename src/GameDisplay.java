import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by Everybody's on 10/6/2015.
 */
public class GameDisplay {

    private static GameDisplay instance;
    private static Graphics g;
    private static int xSize;
    private static int ySize;

    private GameDisplay()
    {

    }

    public static void setDisplay(Graphics graph, int x, int y) {
        g = graph;
        xSize = x;
        ySize = y;
    }

    public static GameDisplay getInstance() {
        return instance;
    }

    public static void test() {
        try {
            g.drawString("heya!",320,240);
            g.drawImage(new Image("img/mario.png"),0,200);
        }
        catch (SlickException ex) {}
    }
}
