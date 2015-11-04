import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 Handles General Game Logic
 */
public class GameManager extends BasicGame {

    static {

    }

    private static GameManager instance;

    private static GameDisplay display = GameDisplay.getInstance();

    private GameManager()
    {
        super("platformer");
    }

    public static GameManager getInstance() {
        if (instance == null)
        {
            instance = new GameManager();
        }

        return instance;
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        GameDisplay.setDisplay(gc.getGraphics(), gc.getScreenWidth(), gc.getScreenHeight());
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {}

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        display.test();
    }

    public static void main(String[] args)
    {
        try
        {
            System.setProperty("java.library.path", "libs/");
            AppGameContainer appGC;
            appGC = new AppGameContainer(getInstance());
            appGC.setDisplayMode(640, 480, false);
            appGC.start();
        }
        catch (SlickException ex)
        {
            Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
