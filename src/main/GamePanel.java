package main;

import entity.Entity;
import entity.NpcPrincess;
import entity.Player;
import monster.*;
import tile.TileManager;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class GamePanel extends JPanel implements Runnable
{
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;


    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;


    int FPS = 60;


    TileManager tileM = new TileManager(this);
    public Keyboard key = new Keyboard(this);
    Sound sound = new Sound();
    Sound se = new Sound();
    public CollisionTester ctester = new CollisionTester(this);
    public Setter setter = new Setter(this);
    public UI ui = new UI(this);
    Thread gameThread;
    public boolean playMusic = true;

    /**
     * Entity and object settings
     */
    public Player player = new Player(this, key);
    public Bandit bandit = new Bandit(this);
    public Devil_knight devil_knight = new Devil_knight(this);
    public Goblin goblin = new Goblin(this);
    public Knight knight = new Knight(this);
    public Skeleton skeleton = new Skeleton(this);
    public Slime_blue slime_blue = new Slime_blue(this);
    public Slime_green slime_green = new Slime_green(this);
    public Slime_red slime_red = new Slime_red(this);
    public Zombie zombie = new Zombie(this);
    public NpcPrincess npcPrincess = new NpcPrincess(this);

    public Entity[] obj = new Entity[10];
    public Entity[] npc = new Entity[10];
    public Entity[] monster = new Entity[20];
    ArrayList<Entity> entityList = new ArrayList<>();

    /**
     * Setting up the game state
     */
    public int titleState = 0;
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int deadState = 5;
    public final int winState = 6;

    /**
     * Setting game panel attributes - game panel constructor
     */
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
    }

    /**
     *  Game setup with music, objects, NPC, monsters
     */
    public void setupGame()
    {
        setter.setObject();
        setter.setNPC();
        setter.setMonster();
        playMusic(0);
        stopMusic();
        gameState = titleState;
    }

    /**
     * Setting the game values to default
     */
    public void defaultGame()
    {
        player.setDefaultValues();
        setter.setObject();
        setter.setMonster();
        setter.setNPC();
        player.princessState = "";
        player.playerKey = 0;
    }

    /**
     * Start of the game
     */
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    double drawInterval = 1000000000 / FPS;
    double nextDrawTime = System.nanoTime() + drawInterval;
    long lastTime = System.nanoTime();
    long timer = 0;
    int drawCount = 0;
    double alfa = 0;

    /**
     * Method for running the game, setting the timer
     */
    @Override
    public void run()
    {
        while (gameThread != null)
        {
            long currentTime = System.nanoTime();
            alfa += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (alfa >= 1)
            {
                update();
                repaint();
                alfa--;
                drawCount++;
            }
            if (timer >= 1000000000)
            {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

            try
            {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0)
                {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * Regular updating of the game
     */
    public void update()
    {
        if (gameState == playState)
        {
            if (playMusic)
            {
                playMusic(0);
                playMusic = false;
            }
            ui.runGame = true;
            player.update();
            for (int i = 0; i < npc.length; i++)
            {
                if (npc[i] != null)
                {
                    npc[i].update();
                }
            }
            for (int i = 0; i < monster.length; i++)
            {
                if (monster[i] != null)
                {
                    monster[i].update();
                }
            }
        }
    }

    /**
     * Setting up the graphics components
     * @param g graphics component
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (gameState == titleState)
        {
            if (!playMusic)
            {
                stopMusic();
            }
            playMusic = true;
            ui.draw(g2);
        }
        else
        {
            tileM.draw(g2);

            entityList.add(player);

            for (int i = 0; i < npc.length; i++)
            {
                if (npc[i] != null)
                {
                    entityList.add(npc[i]);
                }
            }
            for (int i = 0; i < obj.length; i++)
            {
                if (obj[i] != null)
                {
                    entityList.add(obj[i]);
                }
            }
            for (int i = 0; i < monster.length; i++)
            {
                if (monster[i] != null)
                {
                    entityList.add(monster[i]);
                }
            }

            Collections.sort(entityList, (e1, e2) ->
                    {
                int result = Integer.compare(e1.worldY, e2.worldY);

                return result;
                    }
            );

            for (int i = 0; i < entityList.size(); i++)
            {
                entityList.get(i).draw(g2);
            }

            for (int i = 0; i < entityList.size(); i++)
            {
                entityList.remove(i);
            }

            ui.draw(g2);
        }
    }

    /**
     * Method for playing the music
     * @param i music type
     */
    public void playMusic(int i)
    {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    /**
     * Method for stoping the music
     */
    public void stopMusic()
    {
        sound.stop();
    }

    /**
     * Method for sound effects
     * @param i music type
     */
    public void playSoundEffect(int i)
    {
        se.setFile(i);
        se.play();
    }
}
