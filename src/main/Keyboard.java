package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class Keyboard implements KeyListener. The listener interface for receiving keyboard events (keystrokes).
 */
public class Keyboard implements KeyListener
{
    public boolean upPressed, downPressed, leftPressed, rightPressed, pPressed, exitPressed;
    GamePanel gp;

    /**
     * Keyboard class constructor
     * @param gp game panel
     */
    public Keyboard(GamePanel gp)
    {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W)
        {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S)
        {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A)
        {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D)
        {
            rightPressed = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();

        if (gp.gameState == gp.titleState)
        {
            if (code == KeyEvent.VK_W)
            {
                gp.playSoundEffect(11);
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0)
                {
                    gp.ui.commandNum = 2;
                }
            }
            if (code == KeyEvent.VK_S)
            {
                gp.playSoundEffect(11);
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 2)
                {
                    gp.ui.commandNum = 0;
                }
            }
            if (code == KeyEvent.VK_ENTER)
            {
                if (gp.ui.commandNum == 0)
                {
                    gp.gameState = gp.playState;
                }
                if (gp.ui.commandNum == 1)
                {
                    ////
                }
                if (gp.ui.commandNum == 2)
                {
                    System.exit(0);
                }
            }
        }

        if (gp.gameState == gp.playState)
        {
            if (code == KeyEvent.VK_W)
            {
                upPressed = true;
            }
            if (code == KeyEvent.VK_S)
            {
                downPressed = true;
            }
            if (code == KeyEvent.VK_A)
            {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_D)
            {
                rightPressed = true;
            }

            if (code == KeyEvent.VK_ESCAPE)
            {
                exitPressed = true;
            }

            if (code == KeyEvent.VK_P)
            {
                pPressed = true;
            }
        }

        if (gp.gameState == gp.winState)
        {
            if (code == KeyEvent.VK_ESCAPE)
            {
                gp.defaultGame();
                gp.gameState = gp.titleState;
            }
        }

        else if (gp.gameState == gp.playState)
        {
            if (code == KeyEvent.VK_P)
            {
                gp.gameState = gp.pauseState;
            }
            if (code == KeyEvent.VK_ESCAPE)
            {
                gp.gameState = gp.titleState;
            }
        }
        else if (gp.gameState == gp.pauseState)
        {
            if (code == KeyEvent.VK_P)
            {
                gp.gameState = gp.playState;
            }
        }
        else if (gp.gameState == gp.dialogueState)
        {
            if (code == KeyEvent.VK_R)
            {
                gp.gameState = gp.playState;
            }
        }

        if (gp.gameState == gp.deadState)
        {
            if (code == KeyEvent.VK_ESCAPE)
            {
                gp.defaultGame();
                gp.gameState = gp.titleState;
            }
        }
    }
}


